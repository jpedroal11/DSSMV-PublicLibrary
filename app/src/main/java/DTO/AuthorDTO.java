package DTO;

import android.graphics.Bitmap;

public class AuthorDTO {

    private String id;
    private String name;
    private String bio;
    private String birthDate;
    private String deathDate;
    private String alternateNames;


    public AuthorDTO(String id, String name, String bio, String birthDate, String deathDate, String alternateNames) {
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

    public String getDeathDate() {return deathDate;}

    public void setDeathDate(String deathDate) {this.deathDate = deathDate;}

    public String getAlternateNames() {return alternateNames;}

    public void setAlternateNames(String alternateNames) {this.alternateNames = alternateNames;}

}
