/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mainaaplication;
/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ContentManager {
    private ArrayList<MediaContent> contentCollection;
    private Scanner inputReader;
    
    public ContentManager() {
        contentCollection = new ArrayList<>();
        inputReader = new Scanner(System.in);
    }
    
    public ArrayList<MediaContent> getContentCollection() {
        return contentCollection;
    }
    
    public void addNewContent() {
        System.out.println("ADD NEW CONTENT");
        System.out.println("***********");
        
        System.out.print("Enter the content id: ");
        String id = inputReader.nextLine();
        
        System.out.print("Enter the content name: ");
        String name = inputReader.nextLine();
        
        String rating;
        while (true) {
            System.out.print("Enter the age rating: ");
            rating = inputReader.nextLine();
            if (validateAgeRating(rating)) {
                break;
            } else {
                System.out.println("You have entered an invalid age rating!!!");
                System.out.print("Please re-enter the age rating >> ");
            }
        }
        
        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = inputReader.nextLine();
        
        MediaContent newContent = new MediaContent(id, name, rating, episodes);
        contentCollection.add(newContent);
        
        System.out.println("Content processed successfully!!!");
    }
    
    public boolean validateAgeRating(String rating) {
        try {
            int ratingValue = Integer.parseInt(rating);
            return ratingValue >= 2 && ratingValue <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public MediaContent findContent(String id) {
        for (MediaContent content : contentCollection) {
            if (content.contentId.equals(id)) {
                return content;
            }
        }
        return null;
    }
    
    public void searchContent() {
        System.out.print("Enter the content id to search: ");
        String id = inputReader.nextLine();
        
        MediaContent foundContent = findContent(id);
        
        if (foundContent != null) {
            System.out.println("---");
            System.out.println("CONTENT ID: " + foundContent.contentId);
            System.out.println("CONTENT NAME: " + foundContent.contentName);
            System.out.println("AGE RATING: " + foundContent.ageRating);
            System.out.println("EPISODE COUNT: " + foundContent.episodeCount);
            System.out.println("---");
        } else {
            System.out.println("---");
            System.out.println("Content with ID: " + id + " was not found!");
            System.out.println("---");
        }
    }
    
    public void modifyContent() {
        System.out.print("Enter the content id to update: ");
        String id = inputReader.nextLine();
        
        MediaContent foundContent = findContent(id);
        
        if (foundContent != null) {
            System.out.print("Enter the content name: ");
            foundContent.contentName = inputReader.nextLine();
            
            String rating;
            while (true) {
                System.out.print("Enter the age rating: ");
                rating = inputReader.nextLine();
                if (validateAgeRating(rating)) {
                    foundContent.ageRating = rating;
                    break;
                } else {
                    System.out.println("You have entered an invalid age rating!!!");
                    System.out.print("Please re-enter the age rating >> ");
                }
            }
            
            System.out.print("Enter the number of episodes: ");
            foundContent.episodeCount = inputReader.nextLine();
            
            System.out.println("Content updated successfully!");
        } else {
            System.out.println("Content with ID " + id + " not found!");
        }
    }
    
    public boolean removeContent(String id) {
        for (int i = 0; i < contentCollection.size(); i++) {
            if (contentCollection.get(i).contentId.equals(id)) {
                contentCollection.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void deleteContent() {
        System.out.print("Enter the content id to delete: ");
        String id = inputReader.nextLine();
        
        System.out.print("Are you sure you want to delete content " + id + " from the system? Yes (y) to delete: ");
        String confirmation = inputReader.nextLine();
        
        if (confirmation.equalsIgnoreCase("y")) {
            boolean deleted = removeContent(id);
            if (deleted) {
                System.out.println("---");
                System.out.println("Content with ID: " + id + " WAS deleted!");
                System.out.println("---");
            } else {
                System.out.println("Content with ID " + id + " not found!");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    public void generateContentReport() {
        System.out.println("CONTENT REPORT - 2025");
        System.out.println("*********************************************************************");
        
        for (int i = 0; i < contentCollection.size(); i++) {
            MediaContent content = contentCollection.get(i);
            System.out.println("Content " + (i + 1));
            System.out.println("--- CONTENT ID: " + content.contentId);
            System.out.println("CONTENT NAME: " + content.contentName);
            System.out.println("AGE RATING: " + content.ageRating);
            System.out.println("EPISODE COUNT: " + content.episodeCount);
            System.out.println("---");
        }
    }
    
    public void exitApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }
    
    public void showMenu() {
        System.out.println("LATEST CONTENT - 2025");
        System.out.println("*********************************************************************");
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Add new content");
        System.out.println("(2) Search for content");
        System.out.println("(3) Update content age rating");
        System.out.println("(4) Delete content");
        System.out.println("(5) Generate content report - 2025");
        System.out.println("(6) Exit Application");
        System.out.print("Enter your choice: ");
    }
}
