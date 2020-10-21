
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ***********************************************
 *
 * Description: Main method for triggering the SwarmDataReader
 *
 * (DSR Assignment 2)
 *
 * @author Kathryn Kasmarik
 * @date Feb 2020
 *
 ************************************************
 */
public class UImain {
    // Main menu constants

    private final int CONTINUE = 0;
    private final int ADDSTUDENT = 1;
    private final int RECORDATTENDANCE = 2;
    private final int RECORDRESULTS = 3;
    private final int SEARCH = 4;
    private final int EXIT = 5;

    public UImain(){
    }
    
    public void runUI() {
        UI sdr = new UI();

        try {
            int option = CONTINUE;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (option != EXIT) {
                System.out.println("WELCOME TO THE SNB DATABASE");
                System.out.println("Please select an option:");
                System.out.println("[1] Add a student");
                System.out.println("[2] Record weekly attendance");
                System.out.println("[3] Record Results");
                System.out.println("[4] Search for a student");
                System.out.println("[5] Exit");
                option = Integer.parseInt(in.readLine());
                Scanner s = new Scanner(System.in);
                switch (option) {
                    case ADDSTUDENT:
                        sdr.addStudent();
                        System.out.println("Data has been transferred.");
                        break;
                    case RECORDATTENDANCE:
                        sdr.recordAttendance();
                        System.out.println();
                        break;
                    case RECORDRESULTS:
                        sdr.recordResults();
                        System.out.println();
                        break;
                    case SEARCH:
                        sdr.studentSearch();
                    case EXIT:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Please enter a valid option [1-5].");
                        break;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UImain m = new UImain();
        m.runUI();
    }
}
