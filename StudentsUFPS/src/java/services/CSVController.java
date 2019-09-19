/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import model.*;

/**
 *
 * @author xcheko51x. Modified by: EM.
 *
 */
public class CSVController {

    public static final String FILE_PATH = "C:Users\\EN\\Documentos\\NetBeansProjects\\StudentsUFPS\\web\\files\\";
    public static final String FILE_NAME = "Students.csv";

    public static void exportCSV(List<Student> usuarios, File targetOutput) {
        String salidaArchivo = targetOutput.getAbsolutePath(); // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

        // Si existe un archivo llamado asi lo borra
        if (existe) {
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }

        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Telefono");
            salidaCSV.write("Email");

            salidaCSV.endRecord(); // Deja de escribir en el archivo

            // Recorremos la lista y lo insertamos en el archivo
            for (Student user : usuarios) {
                salidaCSV.write(user.getName());
                salidaCSV.write(user.getEmail());

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[][] importCSV(File pathFile) {
        try {
            List<Student> usuarios = new ArrayList<Student>(); // Lista donde guardaremos los datos del archivo
            CsvReader leerUsuarios = new CsvReader(pathFile.getAbsolutePath());
            leerUsuarios.readHeaders();

            // Mientras haya lineas obtenemos los datos del archivo
            while (leerUsuarios.readRecord()) {
                String nombre = leerUsuarios.get(0);
                String telefono = leerUsuarios.get(1);
                String email = leerUsuarios.get(2);

                usuarios.add(new Student(nombre, email, "")); // Añade la informacion a la lista
            }

            leerUsuarios.close(); // Cierra el archivo

            // Recorremos la lista y la mostramos en la pantalla
            for (Student user : usuarios) {
                System.out.println(user.getName() + " , "
                        + user.getEmail());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[][] s = new String[0][0];
        return s;
    }

    public static List<Student> getStudents(File filePath) {
        List<Student> students = new ArrayList<Student>();
        try {

            CsvReader readStudents = new CsvReader(filePath.getPath());
            System.out.println("paso 1, el absolute: " + filePath.getPath());//*************************************************
            readStudents.readHeaders();

            // Mientras haya lineas obtenemos los datos del archivo
            byte actualRow = 0;
            List<String> qualificationConcepts = new ArrayList<>();
            byte quantColumns = 0;

            while (readStudents.readRecord()) {

                if (actualRow ==0) { //para ignorar la primera fila con el titulo

                } else if (actualRow == 1) { //fila que contiene los qualificationConcepts
                    quantColumns = (byte) readStudents.getColumnCount();
                    
                    for (int i = 4; i < quantColumns; i++) {
                        qualificationConcepts.add(readStudents.get(i));

                    }
                } else if(actualRow>1){
                    String sId = readStudents.get(1);
                    String sName = readStudents.get(2);
                    String sEmail = readStudents.get(3);
                    List<Qualification> qualifications = new ArrayList<>();
                    for (int i = 4; i < quantColumns; i++) {
                        String concept = qualificationConcepts.get(i - 4);
                        float value = Float.parseFloat(readStudents.get(i));
                        qualifications.add(new Qualification(concept, value));

                    }
                    students.add(new Student(sName, sEmail, sId, qualifications));
                }
                else{}

                actualRow++;
            }

            readStudents.close(); // Cierra el archivo

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
