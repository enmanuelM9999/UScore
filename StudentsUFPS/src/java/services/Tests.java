/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.util.List;
import static javax.servlet.SessionTrackingMode.URL;
import model.*;
import services.*;
import static services.CSVController.getStudents;

public class Tests {
    public static void main(String[] args) {
        List<Student> students=CSVController.getStudents(new File("C:\\Users\\Public\\Documents\\NetBeans\\UScore\\Notas.csv"));
        System.out.println(students.get(0).getEmail());
    }
}
