package Mainaaplication;



/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;

public class ApplicationLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("CONTENT MANAGEMENT SYSTEM - 2025");
        System.out.println("*********************************************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            System.exit(0);
        }
        
        ContentManager contentManager = new ContentManager();
        
        while (true) {
            contentManager.showMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    contentManager.addNewContent();
                    break;
                case "2":
                    contentManager.searchContent();
                    break;
                case "3":
                    contentManager.modifyContent();
                    break;
                case "4":
                    contentManager.deleteContent();
                    break;
                case "5":
                    contentManager.generateContentReport();
                    break;
                case "6":
                    contentManager.exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            input = scanner.nextLine();
            if (!input.equals("1")) {
                break;
            }
        }
        
        scanner.close();
    }
}