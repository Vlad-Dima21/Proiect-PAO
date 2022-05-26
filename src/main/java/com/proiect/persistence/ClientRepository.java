package com.proiect.persistence;

import com.proiect.domain.Angajat;
import com.proiect.domain.Client;
import com.proiect.services.io.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientRepository implements GenericRepository<Client>{

    private static Set<Client> clienti = new HashSet<>();

    static {
        setContorId();
    }

    @Override
    public void add(Client entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement statement = connectionManager.prepareStatement(
                    "insert into client values(?,?,?,?,?)"
            );
            statement.setInt(1, entity.getIdClient());
            statement.setString(2, entity.getNume());
            statement.setString(3, entity.getPrenume());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getTelefon());

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client get(int id) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select * from client where idClient=?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
                client.setIdClient(resultSet.getInt(1));
                return client;
            }
            return null;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Client entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "update client set telefon=?" +
                    " where lower(nume)=lower(?)" +
                        " and lower(prenume)=lower(?)" +
                        " and email=?"
            );
            preparedStatement.setString(1, entity.getTelefon());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setString(3, entity.getPrenume());
            preparedStatement.setString(4, entity.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Client entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "delete from client" +
                        " where lower(nume)=lower(?)" +
                        " and lower(prenume)=lower(?)" +
                        " and email=?"
            );
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setString(2, entity.getPrenume());
            preparedStatement.setString(3, entity.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        ConnectionManager connectionManager = null;
        try {
            connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select count(*) from client"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Client> getAll() {
        List<Client> list = new ArrayList<>();
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select * from client"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
                client.setIdClient(resultSet.getInt(1));
                list.add(client);
            }
            return list;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void setContorId() {
        try {
            ResultSet s = ConnectionManager.getInstance().prepareStatement(
                    "select max(idClient) from client"
            ).executeQuery();
            s.next();
            Client.setContorId(s.getInt(1) + 1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
