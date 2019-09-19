
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EN
 */
public class Subject {
    private String name;
    private List<Student> students;

    public Subject(String name) {
        this(name,new ArrayList<Student>());
    }

    public Subject(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public List<String> getQualificationsConcepts(){
     return students.get(0).getQualificationsConcepts();
     
    }
    public Student getStudent(String email){
       Student s=null; 
       byte quant=(byte)students.size();
        for (int i = 0; i < quant; i++) {
            Student stu= students.get(i);
            if (stu.getEmail().equals(email)) {
                s=stu;
            }
        }
       return s;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
