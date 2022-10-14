package com.example.a2;

import java.sql.*;
import java.util.ArrayList;

public class DBManage {

    static Connection connection = null;
    static String url = "jdbc:sqlite:src/main/data/database.sqlite";

    // create the database
    public static void createDB() {
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users " +
                    "(username TEXT, password TEXT, userID INT PRIMARY KEY, role TEXT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Products " +
                    "(cost FLOAT, name TEXT, prodID int PRIMARY KEY, Category TEXT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Purchased " +
                    "(userID REFERENCES Users(userID), prodID REFERENCES Products(prodID))");
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

    // add user to database
    public static void addUser(String userName, String password, int userID, String role){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "INSERT INTO Users (username, password, userID, role) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, userID);
            preparedStatement.setString(4,role);
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
    public static void addProduct(double cost, String name, int prodID, String category){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "INSERT INTO Products (Cost, Name, ProdID, Category) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setDouble(1, cost);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, prodID);
            preparedStatement.setString(4, category);
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

    // add purchased history
    public static void addPurchased(int userID, int prodID){
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String insertStatement = "INSERT INTO Purchased (userID, prodID) VALUES(?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, prodID);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            java.lang.System.out.println("_________________________ERROR at addPurchased_________________________");
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

    // get name of all products currently in db
    public static ArrayList<String> getProducts(){
        ArrayList<String> products = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(url);

            // make sure the order is same using "order by"
            String insertStatement = "SELECT name FROM products";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertStatement);
            ResultSet productList = preparedStatement.executeQuery();

            while (productList.next()) {
                products.add(productList.getString("name"));
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
