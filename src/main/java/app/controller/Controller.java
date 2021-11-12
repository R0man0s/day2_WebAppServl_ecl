package app.controller;

import app.entities.Product;
import app.enums.Products_status;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class Controller {
    public static Connection GetConnection() {
        String driver;
        String url;
        String username;
        String password;

        Connection conn;

        FileInputStream fis;
        Properties property = new Properties();

        try {

            String propFileName = "config.properties";

            InputStream inputStream = Controller.class.getClassLoader().getResourceAsStream(propFileName);

            property.load(inputStream);

            driver = property.getProperty("db.driver");
            url = property.getProperty("db.url");
            username = property.getProperty("db.username");
            password = property.getProperty("db.password");

            inputStream.close();

        } catch (IOException e) {
            System.err.println("Error: properties file does not exist!");
            return null;
        }

        try{

            Class.forName(driver);

            conn = DriverManager.getConnection(url,username,password);
            //System.out.println("    Connected database successfully...");
        } catch (Exception e) {
            System.out.println("getConnection(): connection error- "+ e.getMessage());
            return null;
        }

        return conn;
    }

    public static void ShowAllProducts() {
        Connection conn = GetConnection();
        if (conn == null) {
            return;
        }
        try{
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select id, name, price, status from products");

            System.out.println("\n#    Product name       Price       Status");

            while(rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Products_status status = Products_status.valueOf(rs.getString("status"));

                System.out.println(""+ id + "    "+ name + "               " + price + "          " + status);

            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("showAllProducts(): error- " + e.getMessage());
        }

    }

    public static List<String> GetAllProductsViews() {
        Connection conn = GetConnection();
        if (conn == null) {
            return null;
        }
        List<String> productsViews = null;

        try{
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select id, name, price, status from products");

            //System.out.println("\n#    Product name       Price       Status");

            while(rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Products_status status = Products_status.valueOf(rs.getString("status"));

                Product tmpProduct = new Product(id,name,price,status,"");
                productsViews.add(tmpProduct.toString());

                //System.out.println(""+ id + "    "+ name + "               " + price + "          " + status);

            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("showAllProducts(): error- " + e.getMessage());
            return null;
        }

        return productsViews;
    }

}
