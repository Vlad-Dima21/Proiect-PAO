package com.proiect.persistence;

import com.proiect.domain.Angajat;
import com.proiect.domain.Client;
import com.proiect.domain.OperatorComenzi;
import com.proiect.domain.SoferLivrari;
import com.proiect.services.io.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AngajatRepository implements GenericRepository<Angajat> {

    //    lista este nefolosita odata cu adaugarea partii de persistenta
    private static List<Angajat> angajati = new ArrayList<>();

    static {
        setContorId();
    }

    @Override
    public void add(Angajat entity) {
        String statement = "";
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            if (entity instanceof OperatorComenzi operatorComenzi) {
                PreparedStatement stmt = connectionManager.prepareStatement(statement = "insert into operatorcomenzi values(" +
                        entity.getIdAngajat() + ",'" +
                        entity.getNume() + "','" +
                        entity.getPrenume() + "'," +
                        entity.getSalariu() + ",'" +
                        entity.getSex() + "','" +
                        entity.getCnp() + "','" +
                        entity.getTelefon() + "','" +
                        "[" + Arrays.stream(operatorComenzi.getProgram())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")) + "]" + "','" +
                        "[" + Arrays.stream(operatorComenzi.getZileLucratoare())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")) + "]" + "'," +
                        operatorComenzi.getCoefiecientBonus() + ",'" +
                        operatorComenzi.getParolaAngajat() + "')"
                );
                stmt.executeUpdate();
            } else {
                SoferLivrari soferLivrari = (SoferLivrari) entity;
                PreparedStatement stmt = connectionManager.prepareStatement(statement = "insert into soferlivrari values(" +
                        entity.getIdAngajat() + ",'" +
                        entity.getNume() + "','" +
                        entity.getPrenume() + "'," +
                        entity.getSalariu() + ",'" +
                        entity.getSex() + "','" +
                        entity.getCnp() + "','" +
                        entity.getTelefon() + "'," +
                        soferLivrari.getNumarLivrariZi() + ",'" +
                        soferLivrari.getNrInmatriculareMasina() + "'," +
                        soferLivrari.getCapacitateMaximaPachete() + ")"
                );
                stmt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(statement);
            e.printStackTrace();
        }
    }

    @Override
    public Angajat get(int id) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select * from operatorcomenzi where idAngajat = " + id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int[] program;
                int[] zileLucratoare;
                String[] aux1, aux2;

                aux1 = rs.getString("program").replaceAll("\\[", "").
                        replaceAll("]", "").split(" ");

                aux2 = rs.getString("zileLucratoare").replaceAll("\\[", "").
                        replaceAll("]", "").split(" ");

                program = new int[aux1.length];
                zileLucratoare = new int[aux2.length];

                for (int i = 0; i < aux1.length; i++) {
                    program[i] = Integer.parseInt(aux1[i]);
                }

                for (int i = 0; i < aux2.length; i++) {
                    zileLucratoare[i] = Integer.parseInt(aux2[i]);
                }

                OperatorComenzi operatorComenzi = new OperatorComenzi(rs.getString("nume"),
                        rs.getString("prenume"),
                        (int) rs.getLong("salariu"),
                        rs.getString("sex").charAt(0),
                        rs.getString("cnp"),
                        rs.getString("telefon"),
                        program,
                        zileLucratoare,
                        rs.getDouble("coeficientBonus"),
                        rs.getString("parolaAngajat"));
                operatorComenzi.setIdAngajat((int) rs.getLong("idAngajat"));

                return operatorComenzi;
            } else {
                preparedStatement = connectionManager.prepareStatement(
                        "select * from soferlivrari where idAngajat = " + id);
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    SoferLivrari soferLivrari = new SoferLivrari(rs.getString("nume"),
                            rs.getString("prenume"),
                            (int) rs.getLong("salariu"),
                            rs.getString("sex").charAt(0),
                            rs.getString("cnp"),
                            rs.getString("telefon"),
                            (int) (rs.getLong("numarLivrariZi")),
                            rs.getString("nrInmatriculareMasina"),
                            (int) rs.getLong("capacitateMaximaPachete"));
                    soferLivrari.setIdAngajat((int) rs.getLong("idAngajat"));

                    return soferLivrari;
                } else {
                    return null;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Angajat entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            if (entity instanceof OperatorComenzi operatorComenzi) {
                String program = Arrays.stream(operatorComenzi.getProgram())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
                String zileLucratoare = Arrays.stream(operatorComenzi.getZileLucratoare())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));

                PreparedStatement preparedStatement = connectionManager.prepareStatement(
                        "update operatorcomenzi set salariu=" + operatorComenzi.getSalariu() +
                                ", sex='" + operatorComenzi.getSex() +
                                "', cnp='" + operatorComenzi.getCnp() +
                                "', telefon='" + operatorComenzi.getTelefon() +
                                "', program='[" + program +
                                "]', zileLucratoare='[" + zileLucratoare +
                                "]', coeficientBonus=" + operatorComenzi.getCoefiecientBonus() +
                                ", parolaAngajat='" + operatorComenzi.getParolaAngajat() + "'" +
                                " where lower(nume)=lower('" + operatorComenzi.getNume() + "')" +
                                " and lower(prenume)=lower('" + operatorComenzi.getPrenume() + "')" +
                                " and cnp=" + operatorComenzi.getCnp());
                preparedStatement.executeUpdate();
            } else if (entity instanceof SoferLivrari soferLivrari) {
                PreparedStatement preparedStatement = connectionManager.prepareStatement(
                        "update soferlivrari set salariu=" + soferLivrari.getSalariu() +
                                ", sex='" + soferLivrari.getSex() +
                                "', cnp='" + soferLivrari.getCnp() +
                                "', telefon='" + soferLivrari.getTelefon() +
                                "', numarLivrariZi=" + soferLivrari.getNumarLivrariZi() +
                                ", nrInmatriculareMasina='" + soferLivrari.getNrInmatriculareMasina() +
                                "', capacitateMaximaPachete=" + soferLivrari.getCapacitateMaximaPachete() +
                                " where lower(nume)=lower('" + soferLivrari.getNume() + "')" +
                                " and lower(prenume)=lower('" + soferLivrari.getPrenume() + "')" +
                                " and cnp=" + soferLivrari.getCnp());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Angajat entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            if (entity instanceof OperatorComenzi operatorComenzi) {
                PreparedStatement preparedStatement = connectionManager.prepareStatement(
                        "delete from operatorcomenzi where " +
                                "lower(nume)=lower('" + operatorComenzi.getNume() + "')" +
                                " and lower(prenume)=lower('" + operatorComenzi.getPrenume() + "')" +
                                " and cnp=" + operatorComenzi.getCnp());
                preparedStatement.executeUpdate();
            } else if (entity instanceof SoferLivrari soferLivrari) {
                PreparedStatement preparedStatement = connectionManager.prepareStatement(
                        "delete from soferlivrari where " +
                                "lower(nume)=lower('" + soferLivrari.getNume() + "')" +
                                " and lower(prenume)=lower('" + soferLivrari.getPrenume() + "')" +
                                " and cnp=" + soferLivrari.getCnp());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement statement1 = connectionManager.prepareStatement(
                    "select count(*) from operatorcomenzi"
            );
            PreparedStatement statement2 = connectionManager.prepareStatement(
                    "select count(*) from soferlivrari"
            );
            ResultSet set1 = statement1.executeQuery();
            ResultSet set2 = statement2.executeQuery();
            if (set1.next()) {
                if (set2.next()) {
                    return set1.getInt(1) + set2.getInt(1);
                } else {
                    return set1.getInt(1);
                }
            }
            return 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Angajat> getAll() {
        List<Angajat> lista = new ArrayList<>();
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select * from operatorcomenzi"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OperatorComenzi operatorComenzi = new OperatorComenzi(
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        (int) resultSet.getLong("salariu"),
                        resultSet.getString("sex").charAt(0),
                        resultSet.getString("cnp"),
                        resultSet.getString("telefon"),
                        Arrays.stream(resultSet.getString("program").
                                        replaceAll("[\\[\\]]", "").
                                        split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray(),
                        Arrays.stream(resultSet.getString("zileLucratoare").
                                        replaceAll("[\\[\\]]", "").
                                        split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray(),
                        Double.parseDouble(resultSet.getString("coeficientBonus")),
                        resultSet.getString("parolaAngajat")
                );
                operatorComenzi.setIdAngajat(resultSet.getInt(1));
                lista.add(operatorComenzi);
            }
            preparedStatement = connectionManager.prepareStatement(
                    "select * from soferlivrari"
            );
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SoferLivrari soferLivrari = new SoferLivrari(
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        (int) resultSet.getLong("salariu"),
                        resultSet.getString("sex").charAt(0),
                        resultSet.getString("cnp"),
                        resultSet.getString("telefon"),
                        (int) resultSet.getLong("numarLivrariZi"),
                        resultSet.getString("nrInmatriculareMasina"),
                        (int) resultSet.getLong("capacitateMaximaPachete")
                );
                soferLivrari.setIdAngajat(resultSet.getInt(1));
                lista.add(soferLivrari);
            }
            return lista;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void setContorId() {
        try {
            ResultSet s1 = ConnectionManager.getInstance().prepareStatement(
                    "select max(idAngajat) from soferlivrari"
            ).executeQuery();

            ResultSet s2 = ConnectionManager.getInstance().prepareStatement(
                    "select max(idAngajat) from soferlivrari"
            ).executeQuery();

            s1.next();
            s2.next();

             Angajat.setContorId(Math.max(s1.getInt(1), s2.getInt(1)) + 1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
