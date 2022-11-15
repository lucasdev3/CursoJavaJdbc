package br.com.lucasdev3.cursojdbc.services;

import br.com.lucasdev3.cursojdbc.config.connection.ConnectionDataBase;
import br.com.lucasdev3.cursojdbc.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserService {

    public static void findById(Integer id) {
        try {
            Connection connection = ConnectionDataBase.getConnection();
            System.out.println("Conexão Realizada com sucesso!");

            String sql = "SELECT * FROM TB_USERS WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println("ID: " + user.getId() + " | Username: " + user.getUsername() + " | Password: " + user.getPassword());
            } else {
                System.out.println("Nenhum usuario encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByUsername(String username) {
        try {
            Connection connection = ConnectionDataBase.getConnection();
            System.out.println("Conexão Realizada com sucesso!");

            String sql = "SELECT * FROM TB_USERS WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println("ID: " + user.getId() + " | Username: " + user.getUsername() + " | Password: " + user.getPassword());
            } else {
                System.out.println("Nenhum usuario encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<User> findAll() {
        try {
            Connection connection = ConnectionDataBase.getConnection();
            System.out.println("Conexão Realizada com sucesso!");

            String sql = "SELECT * FROM TB_USERS";

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<User> listUsers = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                listUsers.add(new User(id, username, password));
            }

            for (User user : listUsers) {
                System.out.println("ID: " + user.getId() + " | Username: " + user.getUsername() + " | Password: " + user.getPassword());
            }
            connection.close();
            System.out.println("Conexão encerrada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void persistUser(String username, String password) {
        try {
            Connection connection = ConnectionDataBase.getConnection();
            System.out.println("Conexão Realizada com sucesso!");

            String sql = "INSERT INTO TB_USERS (username, password) VALUES (?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ps.execute();
            System.out.println("Usuario cadastrado com sucesso!");
            connection.close();
            System.out.println("Conexão encerrada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
