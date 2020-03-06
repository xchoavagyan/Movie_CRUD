package com.example.demo.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.demo.mariadb.DatabaseConstants.*;

public class CreateDatabaseAndTables {

    public static void createDatabaseAndTables() {
        try (Connection conn = DriverManager.getConnection(DB_URL_D, USER, PASSWORD)) {
            String query = "CREATE DATABASE IF NOT EXISTS movieCRUD";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("Database Created");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String createTasksTable = "CREATE TABLE IF NOT EXISTS movies" +
                    "(    id      int not null auto_increment," +
                    "    title    varchar(255)," +
                    "    description   varchar(255)," +
                    "    duration int," +
                    "    primary key (id));";
            PreparedStatement preparedStatement = conn.prepareStatement(createTasksTable);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("Table Movies Created");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
