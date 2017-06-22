/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author redblues
 */
public class login_serv extends HttpServlet {
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
            throws ServletException, IOException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");
            //login.jspから、ログインID、パスワードを取得
            String user=request.getParameter("userID");
            String pass=request.getParameter("password");
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
        
            HttpSession session=request.getSession(true);
            try{
                //checkフラグを作成
                boolean check;
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventry_controle","root","");
                db_st = db_con.prepareStatement("select * from user where userID=? and pass=?");
                db_st.setString(1,user);
                db_st.setString(2,pass);
                
                db_data=db_st.executeQuery();
                
                check = db_data.next();
                
                //ログイン情報が正しかったら、change_table.jspへ移動
                if(check==true){
                    session.setAttribute("login.jsp",user);
                    response.sendRedirect("change_table.jsp");
                    
                }
                //ログイン情報が間違っていたら、再度ログイン画面を表示
                else{
                    session.setAttribute("status","no");
                    response.sendRedirect("login.jsp");
                }
                
            }catch(SQLException sqle){
                out.println("エラーが発生しました。"+sqle.toString());
            }catch(ClassNotFoundException cnfe){
                out.println("エラーが発生しました。"+cnfe.toString());
            }finally{
                if(db_con!=null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        out.println(e_con.getMessage());
                    }
                }
            }
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(login_serv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(login_serv.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(login_serv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(login_serv.class.getName()).log(Level.SEVERE, null, ex);
        }
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