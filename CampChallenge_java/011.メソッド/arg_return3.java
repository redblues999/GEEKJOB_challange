/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author redblues
 */
public class arg_return3 extends HttpServlet {
    
    public String[] profile(PrintWriter pw){
        Integer limit = 2;
        String data1[] = {"20192385","九段下　太郎","1993年8月27日","東京都千代田区丸の内５８-９１"};
        String data2[] = {"14201942","大手町　愛子","1987年4月6日",null};
        String data3[] = {"25381049","日本橋　次郎","1993年11月13日","神奈川県横浜市中区新港７－１６３"};
        int j = 0;
            for(String a: data1){
                if (j != 0){
                pw.print(a+"<br>");
                }
                j++;
            }
            
        int k = 0;
            for(String a: data2){
                if(a == null){
                    continue;
                }
                if (k != 0){
                pw.print(a+"<br>");
                }
                k++;
            }
            
        int l = 0;
            for(String a: data3){
                if(limit == 2){
                    break;
                }
                if (l != 0){
                pw.print(a+"<br>");
                }   
                l++;
            }
        return data1;
    }

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet arg_return3</title>");            
            out.println("</head>");
            out.println("<body>");
            profile(out);
            out.println("</body>");
            out.println("</html>");
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
