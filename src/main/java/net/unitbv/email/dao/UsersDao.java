package net.unitbv.email.dao;

import net.unitbv.email.dao.util.DaoUtil;
import net.unitbv.email.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsersDao {



    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();

        String query = "Select id, user_name, first_name, last_name from user";

        try {
            Connection connection = DaoUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userName = resultSet.getString(2);
                String firstName= resultSet.getString(3);
                String lastName= resultSet.getString(4);

                users.add(
                        new User(id, userName, firstName, lastName)
                );
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<User> getUsersOld() {
        List<User> users = new ArrayList<User>();
        users.add(
                new User("UserName 1", "FirstName 1", "LastName 1")
        );
        users.add(
                new User("UserName 2", "FirstName 2", "LastName 2")
        );

        return users;
    }
}
