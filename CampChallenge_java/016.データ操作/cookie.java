/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author redblues
 */
public class cookie extends HttpServlet {
    
    public void timestamp(PrintWriter pw,HttpServletResponse response,HttpServletRequest request){
        //現在時刻のタイムスタンプを作成
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //現在の時刻を表示
        pw.print("現在時刻:"+sdf.format(d)+"<br>");
        String d2 = sdf.format(d);
        //cookieへ"Date"という名前で現在時刻のタイムスタンプを取得(現在時刻を記録)
        Cookie c = new Cookie("Date",d2);
        //クッキーを追加(更新)
        response.addCookie(c);
        Cookie[] cs = request.getCookies();
        
        if(cs != null){
            pw.print("クッキーが取得されました<br>");
            for (int i = 0; i < cs.length; i++) {
            if (cs[i].getName().equals("Date"))//equals(クッキー名)
                {
                pw.print("最後のログインは、" + cs[i].getValue());
                break;
                }
            }
        }
        else{//null例外処理
            pw.print("クッキーが取得されていません<br>");
        }
        
        
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
            out.println("<title>Servlet cookie</title>");            
            out.println("</head>");
            out.println("<body>");
            timestamp(out,response,request);
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
