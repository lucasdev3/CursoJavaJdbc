package br.com.lucasdev3.cursojdbc;

import br.com.lucasdev3.cursojdbc.entities.User;

import static br.com.lucasdev3.cursojdbc.services.UserService.persistUser;
import static br.com.lucasdev3.cursojdbc.services.UserService.findAll;
import static br.com.lucasdev3.cursojdbc.services.UserService.findById;
import static br.com.lucasdev3.cursojdbc.services.UserService.findByUsername;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = "";
        String password = "";

        //CADASTRO DE USUARIO
        try {
            System.out.println("Informe o username: ");
            username = sc.nextLine();
            System.out.println("Informe a senha: ");
            password = sc.nextLine();
            persistUser(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // CONSULTAS
        try {
            System.out.println("Find All");
            List<User> listUser =  findAll();
            if(Objects.requireNonNull(listUser).size() > 0) {
                for(User user : listUser) {
                    System.out.println("ID: " + user.getId() + " | Username: " + user.getUsername() + " | Password: " + user.getPassword());
                }
            } else {
                System.out.println("Nenhum usuario encontrado! Método findAll");
            }

//            System.out.println("\nFind By Id");
//            findById(6);
//            System.out.println("\nFind By Username");
//            User user = findByUsername("TESTE2");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}