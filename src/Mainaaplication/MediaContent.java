/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mainaaplication;
/**
 *
 * @author lab_services_student
 */
public class MediaContent {
 public String contentId;
    public String contentName;
    public String ageRating;
    public String episodeCount;
    
    public MediaContent(String id, String name, String rating, String episodes) {
        this.contentId = id;
        this.contentName = name;
        this.ageRating = rating;
        this.episodeCount = episodes;
    }   
}
