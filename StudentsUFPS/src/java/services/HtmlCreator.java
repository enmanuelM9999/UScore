/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.Qualification;
import model.Student;

/**
 *
 * @author EN
 */
public class HtmlCreator {

    private static String td = "<td>", _td = "</td>", tr = "<tr>", _tr = "</tr>", th = "<th>", _th = "</th>";

    public static String getStudentsTable(List<Student> students) {
        String table = "<table>" + tr + th + "Nro." + _th;
        table += th + "CODIGO" + _th;
        table += th + "NOMBRE" + _th;
        table += th + "EMAIL" + _th;

        List<String> concepts = students.get(0).getQualificationsConcepts();
        byte quantQual = (byte) concepts.size();
        for (int i = 0; i < quantQual; i++) {
            table += th + concepts.get(i) + _th;
        }
        table += _tr;

        byte quantStudents = (byte) students.size();
        for (int i = 0; i < quantStudents; i++) {
            table += tr;
            table += td + (i + 1) + _td;
            Student actualStudent = students.get(i);
            table += td + actualStudent.getId() + _td;
            table += td + actualStudent.getName() + _td;
            table += td + actualStudent.getEmail() + _td;
            List<Qualification> quals = actualStudent.getQualifications();
            for (int j = 0; j < quantQual; j++) {
                table += td + quals.get(j).getValue() + _td;
            }
            table += _tr;
        }

        table += "</table>";
        return table;
    }

    public static String getStudentTable(Student student) {
        String table = "<table>" + tr + th + "Nro." + _th;
        table += th + "CODIGO" + _th;
        table += th + "NOMBRE" + _th;
        table += th + "EMAIL" + _th;

        List<String> concepts = student.getQualificationsConcepts();
        byte quantQual = (byte) concepts.size();
        for (int i = 0; i < quantQual; i++) {
            table += th + concepts.get(i) + _th;
        }
        table += _tr;
        table += tr;
        table += td + (1) + _td;
        table += td + student.getId() + _td;
        table += td + student.getName() + _td;
        table += td + student.getEmail() + _td;
        List<Qualification> quals = student.getQualifications();
        for (int j = 0; j < quantQual; j++) {
            table += td + quals.get(j).getValue() + _td;
        }
        table += _tr;

        table += "</table>";
        return table;
    }
}
