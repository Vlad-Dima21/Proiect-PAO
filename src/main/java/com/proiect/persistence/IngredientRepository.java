package com.proiect.persistence;

import com.proiect.domain.Client;
import com.proiect.domain.Ingredient;
import com.proiect.services.io.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class IngredientRepository implements GenericRepository<Ingredient>{
    private static Vector<Ingredient> ingrediente = new Vector<>();

    static {
        setIdContor();
    }

    @Override
    public void add(Ingredient entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "insert into ingredient values(?,?,?,?,?)"
            );
            preparedStatement.setInt(1, entity.getIdIngredient());
            preparedStatement.setString(2, entity.getNume());
            preparedStatement.setInt(3, entity.getStoc());
            preparedStatement.setInt(4, entity.getStocLunar());
            preparedStatement.setString(5, entity.getNumeFurnizor());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ingredient get(int id) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select * from ingredient where idIngredient=?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Ingredient ingredient = new Ingredient(
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)
                );
                ingredient.setIdIngredient(resultSet.getInt(1));
                return ingredient;
            }
            return null;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Ingredient entity) {
        PreparedStatement cerere = null;
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "update ingredient set " +
                        "stoc=?, " +
                        "stocLunar=? " +
                    "where lower(nume)=lower(?) " +
                        "and lower(numeFurnizor)=lower(?)"
            );
            preparedStatement.setInt(1, entity.getStoc());
            preparedStatement.setInt(2, entity.getStocLunar());
            preparedStatement.setString(3, entity.getNume());
            preparedStatement.setString(4, entity.getNumeFurnizor());

            cerere = preparedStatement;
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(cerere);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ingredient entity) {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "delete from ingredient set " +
                            "where lower(nume)=lower(?) " +
                            "and lower(numeFurnizor)=lower(?)"
            );
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setString(2, entity.getNumeFurnizor());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(
                    "select count(*) from ingredient"
            );
            ResultSet rs =  preparedStatement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Ingredient> getAll() {
        List<Ingredient> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionManager.getInstance().prepareStatement(
                    "select * from ingredient"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient(
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)
                );
                ingredient.setIdIngredient(resultSet.getInt(1));
                list.add(ingredient);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void setIdContor() {
        try {
            ResultSet r = ConnectionManager.getInstance().prepareStatement(
                    "select max(idIngredient) from ingredient"
            ).executeQuery();
            r.next();
            Ingredient.setContorId(r.getInt(1) + 1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
