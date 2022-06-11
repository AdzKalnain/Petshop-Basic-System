package bscs2b_group4;

import java.io.*;

public class PetReciever implements Serializable {
    
    private String name;
    private String age;
    private String breed;
    private String type;
    private String gender;
    
    public PetReciever() {
        
        name="---";
        age="---";
        breed="---";
        type="---";
        gender="---";
    }
    
    public PetReciever(String name) {
        this();
        setName(name);
        setAge(age);
        setBreed(breed);
        setType(type);
        setGender(gender);
    }
    
    public String getName() {
        return name;
    }
    
    public String getAge() {
        return age;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public String getType() {
        return type;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setAge(String age) {
        this.age=age;
    }
    
    public void setBreed(String breed) {
        this.breed=breed;
    }
    
    public void setType(String type) {
        this.type=type;
    }
    
    public void setGender(String gender){
        this.gender=gender;
    }
    
    public String toString() {
        return "\nPet Name:"+name+ "\nPet Age:" +age+ "\nPet Breed:" +breed+ "\nPet Type:" +type+"\nGender:"+gender;
    }

}
