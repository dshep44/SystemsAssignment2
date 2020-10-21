
import java.util.Scanner;
import java.time.*;
import java.sql.*;

/**
 * @author William Farrell.
 * @version 2.0, 1-05-2020
 */
public class UI {

    private final String url = "jdbc:mysql://seitux2.adfa.unsw.edu.au/z5260802?autoReconnect=true&useSSL=false";
    private final String user = "z5260802";
    private final String password = "mysqlpass";
    int StudentNumber = 0;

    public UI() {
        updateStudentID();
    }

    public void updateStudentID() {
        int rs2 = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
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
        String first_name = null;
        String last_name = null;
        LocalDate DOBL = null;
        String group_ = null;
        System.out.print("Enter the Students First Name\n");
        first_name = scan.next();
        System.out.print("Enter the Students Last Name\n");
        last_name = scan.next();
        System.out.print("Enter the Students DOB (YYYY-MM-DD)\n");
        DOBL = LocalDate.parse(scan.next());
        Date DOB = Date.valueOf(DOBL);
        System.out.print("Enter the Students Group\n");
        group_ = scan.next();
        updateStudentID();
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Students(ID, first_name, last_name, DOB, group_) "
                    + "VALUES (" + StudentNumber + ",'" + first_name + "','" + last_name
                    + "','" + DOB + "','" + group_ + "')";
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

    public void recordResults() {
        int x;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Student ID");
        x = scan.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM Students WHERE ID = '" + x + "'");
            rs.next();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Unable to load MySQL driver.");
            ex.printStackTrace();
        }
    }

    public void recordAttendance() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Students ID");
        int ID = scan.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Dates(mon) VALUES (1) WHERE ID = " + ID;
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

     public void studentSearch(){
            
        }
    
    public static void main(String[] args) {
        //UI test = new UI();
    }
}
