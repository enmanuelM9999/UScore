
<%@page import="services.HtmlCreator"%>
<%@page import="java.io.File"%>
<%@page import="services.CSVController"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%  String email = request.getSession().getAttribute("email").toString();
            request.getSession().setAttribute("email", email);

            String table = "";
            File file = new File("C:\\Users\\Public\\Documents\\NetBeans\\UScore\\Notas.csv");
            if (file.exists()) {
                List<Student> students = CSVController.getStudents(file);
                table += HtmlCreator.getStudentsTable(students);
            }


        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="923881149215-eqacititaiolmnug083n3g59o5qsn6i6.apps.googleusercontent.com">
        <title>Web Programming </title>
    </head>
    <body>
        <h1>Web-B</h1>
        <button onclick="myFunction()">Sign Out</button>
        <script>
            function myFunction() {
                gapi.auth2.getAuthInstance().disconnect();
                location.reload();
            }
        </script>
        <form action="./subirCSV.do" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>
                        <input type="file" name="file"/>
                        <input type="submit" value="SUBIR ARCHIVO"/>
                    </td>
                </tr>
            </table>
        </form>
        <h3>Students</h3>
        <%=table%>
    </body>
</html>
