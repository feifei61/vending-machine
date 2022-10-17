package com.example.a2;

import java.sql.*;
import java.util.ArrayList;
import java.lang.System;

public class DBManage {

    static Connection connection = null;
    static String url = "jdbc:sqlite:src\\main\\data\\database.sqlite";

    // create the database
    public static void createDB() {
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            // user table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users " +
                    "(username TEXT, " +
                    "password TEXT, " +
                    "userID INTEGER PRIMARY KEY NOT NULL, " +
                    "role TEXT)");
            // products Table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Products " +
                    "(cost FLOAT, " +
                    "name TEXT, " +
                    "prodID INTEGER PRIMARY KEY NOT NULL, " +
                    "quantity INTEGER DEFAULT (7), " +
                    "Category TEXT)");
            // transactions Table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Transactions " +
                    "(transID INTEGER PRIMARY KEY NOT NULL, " +
                    "userID REFERENCES Users(userID) NOT NULL, " +
                    "prodID REFERENCES Products(prodID) NOT NULL," +
                    "success BIT NOT NULL," +
                    "date TIMESTAMP)");
            java.lang.System.out.println("------------DB created------------");
        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at createDB_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
    }

    public static String getUser(String userName){
        String resultPassword = null;

        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "SELECT * FROM Users WHERE (? = Users.Username)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, userName);
            ResultSet result = preparedStatement.executeQuery();

            if(result.isClosed()){
                return null;
            }

            resultPassword = result.getString("password");

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at addUser_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }

        return resultPassword;
    }

    // add user to database
    public static void addUser(String userName, String password, String role){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "INSERT INTO Users (username, password, role) VALUES(?,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3,role);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at addUser_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
    }

    // remove user from database using their ID
    public static void removeUser(int userID){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "DELETE FROM users WHERE userID = ?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at removeUser_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
    }

    // add product to database
    public static void addProduct(double cost, String name, String category){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "INSERT INTO Products (Cost, Name,  Category) VALUES(?,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setDouble(1, cost);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, category);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at addProduct_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
    }

    // remove product from database using their ID
    public static void removeProduct(int prodID){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "DELETE FROM Products WHERE prodID = ?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, prodID);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at removeProduct_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
    }

    // add purchase history (the time of transaction will be recorded when this function is called)
    public static void addTransaction(int userID, int prodID, boolean success){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            int successBit;
            if (success){
                successBit = 1;
            } else {
                successBit = 0;
            }

            Timestamp timestamp = new Timestamp(java.lang.System.currentTimeMillis());

            String insertStatement = "INSERT INTO Transactions (userID, prodID, success, date) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, prodID);
            preparedStatement.setInt(3, successBit);
            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at addTransaction_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
    }

    // get all products currently in db
    public static ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(url);

            // make sure the order is same using "order by"
            String insertStatement = "SELECT * FROM products";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            ResultSet productList = preparedStatement.executeQuery();

            while (productList.next()) {
                int prodID = productList.getInt("prodID");
                String prodName = productList.getString("name");
                double cost = productList.getFloat("cost");
                switch (productList.getString("Category")) {
                    case "Drinks":
                        products.add(new Drinks(prodID, prodName, cost));
                    default:
                        System.out.println("product categry invalid");
                }
            }
        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at getProducts_________________________");
            java.lang.System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                java.lang.System.err.println(e.getMessage());
            }
        }
        return products;
    }
}
