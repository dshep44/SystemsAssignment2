
import java.util.Scanner;
import java.time.*;
import java.sql.*;

/**
 * @author William Farrell.
 * @version 2.0, 1-05-2020
 */
public class UI {

    private final String url = "jdbc:mysql://seitux2.adfa.unsw.edu.au/z5260789?autoReconnect=true&useSSL=false";
    private final String user = "z5260789";
    private final String password = "mysqlpass";
    int StudentNumber = 0;

    public UI() {
        updateStudentID();
    }

    private void updateStudentID() {
        int rs2 = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM Students");
            rs.next();
            stmt.close();
            conn.close();
            rs2 = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Unable to load MySQL driver.");
            ex.printStackTrace();
        }
        StudentNumber = rs2;
    }

    public void addStudent() {
        Scanner scan = new Scanner(System.in);
        int ID = StudentNumber++;
        System.out.print("Enter the Students First Name\n");
        String first_name = scan.next();
        System.out.print("Enter the Students Last Name\n");
        String last_name = scan.next();
        System.out.print("Enter the Students DOB (YYYY-MM-DD)\n");
        LocalDate DOBL = LocalDate.parse(scan.next());
        Date DOB = Date.valueOf(DOBL);
        System.out.print("Enter the Students Group\n");
        String group_ = scan.next();
        updateStudentID();
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Students(ID, first_name, last_name, DOB, group_) "
                    + "VALUES (" + StudentNumber + ",'" + first_name + "','" + last_name
                    + "','" + DOB + "','" + group_ + "')";
            stmt.executeUpdate(query);
            query = "CREATE TABLE Student" + ID + "Record(b_name varchar(255), "
                    + "b_ID int NOT NULL, PRIMARY KEY (b_ID), 1_ int, 2_ int, "
                    + "3_ int, 4_ int, 5_ int, 6_ int, 7_ int, 8_ int, 9_ int, "
                    + "10_ int, 11_ int, 12_ int, 13_ int, 14_ int "
                    + "VALUES (Badge1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
            stmt.executeUpdate(query);//b_id is the badge ID - indicating which badge
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Unable to load MySQL driver.");
            ex.printStackTrace();
        }
    }

    public void recordResults() {
        int x;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Student ID");
        x = scan.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Student" + x + "Record()"
                    + "VALUES(0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
            stmt.close();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Unable to load MySQL driver.");
            ex.printStackTrace();
        }
    }

    public void recordAttendance(String day, int ID) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Dates("+day+") VALUES (1) WHERE ID = " + ID;
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Unable to load MySQL driver.");
            ex.printStackTrace();
        }
    }

    public void studentSearch() {
        
    }

    public static void main(String[] args) {
        //UI test = new UI();
    }
}
