package blackjack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author redblues
 */

/*
・トランプのマークは意識していません
・チップの概念はありません
・全自動です
*/

public class BlackJack extends HttpServlet {

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
        
        //ディーラーとユーザーと結果フラグを定義
        Dealer dealer = new Dealer();
        User user = new User();
        int result = 0;//0:ユーザー(プレイヤー)の勝利、1:ディーラーの勝利、2:引き分け
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BlackJack</title>");      
            out.println("</head>");
            out.println("<body>");
            
            out.print("ブラックジャックを始めます<br><br>");//<br>:改行
            
            //ユーザー(プレーヤー)とディーラーにカードを2枚ずつ配る
            ArrayList<Integer> dlist = new ArrayList<>(); //ダイヤモンド演算子を使用(ソースコードの簡略化)
            dealer.deal();//52枚の山札のカードの中から2枚引く
            dealer.setCard(dlist);
            user.setCard(dealer.deal());//ユーザーの手札を2枚増やす
            dealer.setCard(dealer.deal());//ディーラーの手札を2枚増やす
            
            Current_UserHand(user,out);//ユーザーの現在の手札を表示

            out.print("ユーザーの行動:<br>");
            //ユーザー(プレイヤー)の行動。手札合計が16以下ならヒットする
            while(user.open() <= 16){
                user.setCard(dealer.hit());
                out.println("あなたはヒットしました！<br>");
                Current_UserHand(user,out);
            }
            
            //22以上でバスト
            if(user.open() >= 22){
                out.println("手札がバストしました…<br><br>");
                //Current_DealerHand(dealer,out);
                out.println("ディーラーの行動:<br>");
            
            //17～21の時、スタンドする
            }else{
                out.println("あなたはスタンドしました。<br><br>");
                //Current_DealerHand(dealer,out);
                out.println("ディーラーの行動:<br>");
            }
            
            // ディーラーの行動。手札合計が16以下ならhitする
            
            while(dealer.open() <= 16){
                dealer.setCard(dealer.hit());
                out.println("ディーラーがヒットしました！<br>");
                //Current_DealerHand(dealer,out);
            }
            
            //22以上でバスト
            if(dealer.open() >= 22){
                out.println("手札がバストしました…<br>");
                Current_DealerHand(dealer,out);
            
            //合計点が17以上でスタンドする
            }else{
                out.println("ディーラーがスタンドしました。<br>");
                Current_DealerHand(dealer,out);
            }
                
            // 結果を表示する
            out.println("<br>...結果発表！<br>");
            
            //両者の合計点を比較
            if (user.checkSum() && dealer.checkSum()){
                
                    //両者の合計点が21点以下の時、点数の多いほうが勝ち
                    if(user.open() > dealer.open()){
                        result = 0;
                        
                    }else if(user.open() < dealer.open()){
                        result = 1;
                        
                    }else{//合計点が同じ場合は引き分け
                        result = 2;
                    }
                //ディーラーがバストしたらユーザーの勝ち
                }else if(user.checkSum() && !dealer.checkSum()){
                    result = 0;
                //ユーザーがバストしたらディーラーの勝ち
                }else if(!user.checkSum() && dealer.checkSum()){
                    result = 1;
                }else{ // 両方バストならディーラーの勝ち
                    result = 2;
                }
            
                switch(result){
                    case 0:
                        out.println("<br>あなたの勝ちです！<br>");
                        break;
                    
                    case 1:
                        out.println("<br>あなたの負けです！<br>");
                        break;
                        
                    case 2:
                        out.println("<br>引き分けです<br>");
                        break;
                        
                }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void Current_UserHand(User u,PrintWriter out){
        out.println("あなたの手札： |");
        for(int num : u.Current_Hand()){
            out.println(num + " | ");
        }
        out.println("合計：" + u.open());//合計点を返す
        out.println("<br>");
    }
    
    public void Current_DealerHand(Dealer d,PrintWriter out){
        out.println("ディーラーの手札： |");
        for(int num : d.Current_Hand()){
            out.println(num + " | ");
        }
        out.println("合計：" + d.open());//合計点を返す
        out.println("<br>");
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
