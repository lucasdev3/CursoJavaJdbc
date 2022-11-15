package br.com.lucasdev3.cursojdbc;

import static br.com.lucasdev3.cursojdbc.services.UserService.persistUser;
import static br.com.lucasdev3.cursojdbc.services.UserService.findAll;
import static br.com.lucasdev3.cursojdbc.services.UserService.findById;
import static br.com.lucasdev3.cursojdbc.services.UserService.findByUsername;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String username = "";
        String password = "";

        //CADASTRO DE USUARIO
//        try {
//            System.out.println("Informe o username: ");
//            username = sc.nextLine();
//            System.out.println("Informe a senha: ");
//            password = sc.nextLine();
//            persistUser(username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // CONSULTAS
        try {
            System.out.println("Find All");
            findAll();
            System.out.println("\nFind By Id");
            findById(6);
            System.out.println("\nFind By Username");
            findByUsername("TESTE2");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}