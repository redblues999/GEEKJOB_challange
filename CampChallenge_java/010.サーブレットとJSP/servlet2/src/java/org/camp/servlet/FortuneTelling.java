/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author redblues
 */
public class FortuneTelling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
public ResultData data;{
    //
}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            final String result = "/WEB-INF/jsp/FortuneTellingResult.jsp";
            
            String luckList[] = {"大吉","中吉","吉","半吉","末小吉","凶","小凶","半凶","末凶",
                "凶","大凶"};
            //乱数クラス生成
            Random rand = new Random();
            //乱数取得
            Integer index = rand.nextInt(luckList.length);
            //リクエストスコープへ結果を送信
            ResultData data = new ResultData();
            data.setD(new Date());

            data.setLuck(luckList[index]);
            
            //リクエストスコープに情報を入れる(dataにDAtAを)
            request.setAttribute("DATA", data);
          
            //リクエストディスパッチャーを取得
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);//JSPを呼び出す
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FortuneTelling</title>");            
            out.println("</head>");
            out.println("<body>");
            //luckListのindex番目(乱数で設定したやつ)を表示
            out.println("<h2>今日のあなたの運勢は。。。"+ luckList[index] +"!</h2>");
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
