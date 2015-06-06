package net.unitbv.email.dao;

import net.unitbv.email.dao.util.DaoUtil;
import net.unitbv.email.model.Email;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmailDao {

    public List<Email> getEmails(String userId) {
        List<Email> emails = new ArrayList<Email>();

        String query = "Select id, sender, subject from email where receiver = '" + userId + "'";

        try {
            Connection connection = DaoUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String senderId = resultSet.getString(2);
                String subject = resultSet.getString(3);

                Email email = new Email();
                email.setId(id);
                email.setSenderId(senderId);
                email.setSubject(subject);
                emails.add(
                        email
                );

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }

    public Email getEmail(String emailId) {
        Email email = new Email();

        String query = "Select id, sender, receiver, subject, body from email where id = '" + emailId + "'";

        try {
            Connection connection = DaoUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String senderId = resultSet.getString(2);
                String receiverId = resultSet.getString(3);
                String subject = resultSet.getString(4);
                String body = resultSet.getString(5);

                email.setId(id);
                email.setSenderId(senderId);
                email.setReceiverId(receiverId);
                email.setSubject(subject);
                email.setBody(body);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return email;
    }

    public void saveEmail(Email email) {
        Connection connection = DaoUtil.getConnection();
        String insertTableSQL = "INSERT INTO email"
        		+ "(sender, receiver, subject, body) VALUES"
        		+ "(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, email.getSenderId());
            preparedStatement.setString(2, email.getReceiverId());
            preparedStatement.setString(3, email.getSubject());
            preparedStatement.setString(4, email.getBody());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
