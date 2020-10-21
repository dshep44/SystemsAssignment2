
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private final int CONTINUE = 0;
    private final int TEST1 = 1;
    private final int TEST2 = 2;
    private final int TEST3 = 3;
    private final int TEST4 = 4;
    private final int TEST5 = 5;
    private final int TEST6 = 6;
    private final int TEST7 = 7;
    private final int TEST8 = 8;
    private final int TEST9 = 9;
    private final int TEST10 = 10;
    private final int TEST11 = 11;
    private final int TEST12 = 12;
    private final int TEST13 = 13;
    private final int TEST14 = 14;
    private final int EXIT = 15;

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

    public void recordResults(int studentID, int badgeID) {
        int test1 = 0, test2 = 0, test3 = 0, test4 = 0, test5 = 0, test6 = 0,
                test7 = 0, test8 = 0, test9 = 0, test10 = 0, test11 = 0,
                test12 = 0, test13 = 0, test14 = 0;
        try {
            int option = CONTINUE;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (option != EXIT) {
                System.out.println("Which test has the student completed?");
                System.out.println("Please select an option:");
                System.out.println("[1] Test1");
                System.out.println("[2] Test2");
                System.out.println("[3] Test3");
                System.out.println("[4] Test4");
                System.out.println("[5] Test5");
                System.out.println("[6] Test6");
                System.out.println("[7] Test7");
                System.out.println("[8] Test8");
                System.out.println("[9] Test9");
                System.out.println("[10] Test10");
                System.out.println("[11] Test11");
                System.out.println("[12] Test12");
                System.out.println("[13] Test13");
                System.out.println("[14] Test14");
                System.out.println("[5] Exit");
                option = Integer.parseInt(in.readLine());
                switch (option) {
                    case TEST1:
                        test1 = 1;
                        System.out.println("TEST1 added.");
                    case TEST2:
                        test1 = 2;
                        System.out.println("TEST2 added.");
                    case TEST3:
                        test1 = 3;
                        System.out.println("TEST3 added.");
                    case TEST4:
                        test1 = 4;
                        System.out.println("TEST4 added.");
                    case TEST5:
                        test1 = 5;
                        System.out.println("TEST5 added.");
                    case TEST6:
                        test1 = 6;
                        System.out.println("TEST6 added.");
                    case TEST7:
                        test1 = 7;
                        System.out.println("TEST7 added.");
                    case TEST8:
                        test1 = 8;
                        System.out.println("TEST8 added.");
                    case TEST9:
                        test1 = 9;
                        System.out.println("TEST9 added.");
                    case TEST10:
                        test1 = 10;
                        System.out.println("TEST10 added.");
                    case TEST11:
                        test1 = 11;
                        System.out.println("TEST11 added.");
                    case TEST12:
                        test1 = 12;
                        System.out.println("TEST12 added.");
                    case TEST13:
                        test1 = 13;
                        System.out.println("TEST13 added.");
                    case TEST14:
                        test1 = 14;
                        System.out.println("TEST14 added.");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Student" + studentID + "Record()"
                    + "VALUES(0," + badgeID //badge ID to identify which badge to add to
                    + "," + test1 + "," + test2 + "," + test3 + "," + test4
                    + "," + test5 + "," + test6 + "," + test7 + "," + test8
                    + "," + test9 + "," + test10 + "," + test11 + "," + test12
                    + "," + test13 + "," + test14 + ")";
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
            String query = "INSERT INTO Dates(" + day + ") VALUES (1) WHERE ID = " + ID;
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
