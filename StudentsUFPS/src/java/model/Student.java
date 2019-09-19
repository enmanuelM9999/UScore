
package model;

import java.util.ArrayList;
import java.util.List;
import services.CSVController;


public class Student {
    private String name;
    private String email;
    private String id;
    public List<Qualification> qualifications;

    public Student() {
        this("","","",new ArrayList<Qualification>());
    }

    public Student(String name, String email,String id) {
        this(name,email,id,new ArrayList<Qualification>());
    }

    public Student(String email) {
        this("",email,"",new ArrayList<Qualification>());
    }

    public Student(String name, String email, String id, List<Qualification> qualifications) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.qualifications = qualifications;
    }

    public List<String> getQualificationsConcepts(){
     List<String> concepts= new ArrayList<>();
     byte quantQualifications= (byte)qualifications.size();
        for (int i = 0; i < quantQualifications; i++) {
            String concept= qualifications.get(i).getConcept();
            concepts.add(concept);
        }
     return concepts;
    }
    public boolean addqualification(Qualification q){
        return qualifications.add(q);
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
