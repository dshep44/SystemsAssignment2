package ui1;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static Connection conn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";

    public static boolean isDatabaseExist(String dbFilePath) {
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    public static void connect() {
                try {
                    createNewDatabase("students");
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
    }

    public static void createNewDatabase(String fileName) {
        try (Connection conn = DriverManager.getConnection(sqliteServer+"src\\ui1\\"+fileName+".db")) {
            if (conn != null) {                
                DatabaseMetaData meta = conn.getMetaData();
                Statement statement = conn.createStatement();
                System.out.println("Database Has Been Connected!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}