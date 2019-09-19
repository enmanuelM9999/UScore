/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import javax.servlet.ServletException;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.CSVController;

/**
 *
 * @author EN
 */
public class SubirCSV extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getSession().getAttribute("email").toString();
        request.getSession().setAttribute("email", email);
        boolean isUploaded = false;

        /*String appRelativePath= getServletContext().getRealPath(File.separator);  //retorna null
       File targetPath = new File(appRelativePath).getParentFile().getParentFile();
       String targetFolder= targetPath.toString()+File.separator+"web"+File.separator+"files";
       System.out.println("ruta test: "+targetFolder);
         */
        String targetFolder = "C:\\Users\\Public\\Documents\\NetBeans\\UScore";
        System.out.println(targetFolder);

        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(1024);

        factory.setRepository(new File(targetFolder));

        ServletFileUpload upload = new ServletFileUpload((FileItemFactory) factory);

        try {

            List<FileItem> partes = upload.parseRequest(request);

            for (FileItem items : partes) {
                File file = new File(targetFolder, items.getName());
                items.write(file);
            }

            isUploaded = true;

            request.getRequestDispatcher("./jsp/teacherSubject.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.print("Exception: " + e.getMessage() + "");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
