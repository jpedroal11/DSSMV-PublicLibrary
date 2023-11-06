package model;

import android.graphics.Bitmap;

import java.util.List;

public class Author {

    private String id;
    private String name;
    private String bio;
    private String birthDate;
    private Bitmap deathDate;
    private List<String> alternateNames;


    public Author(String id, String name, String bio, String birthDate, Bitmap deathDate, List<String> alternateNames) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.alternateNames = alternateNames;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getBio() {return bio;}

    public void setBio(String bio) {this.bio = bio;}

    public String getBirthDate() {return birthDate;}

    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

    public Bitmap getDeathDate() {return deathDate;}

    public void setDeathDate(Bitmap deathDate) {this.deathDate = deathDate;}

    public List<String> getAlternateNames() {return alternateNames;}

    public void setAlternateNames(List<String> alternateNames) {this.alternateNames = alternateNames;}
}
