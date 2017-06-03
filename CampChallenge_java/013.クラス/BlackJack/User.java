/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author redblues
 */

//ユーザー(プレイヤー)が行う処理

//Humanクラスを継承
public class User extends Human{
    
    // 手札を増やす
    @Override//上書き
    public void setCard(ArrayList<Integer> increase){
        for(int your_hand : increase){
            myCards.add(your_hand);
        }
    }
    
    //手札の合計点の処理(定義)
    @Override
    public int open(){
        int sum = 0; //合計点
        int A_count = 0; //Aが出た数
        for(int point : myCards){
            //トランプに書かれている数字がJ,Q,K(11,12,13)だったとき、点数を10にする。
            if(point >= 11){
                point = 10;
            }
            //Aが出た数を記憶し、一旦Aの得点を11点にする
            if(point == 1){
                point = 11;
                A_count++;
            }
            sum += point;
            //合計が19を超え、Aが出ていた場合はAを1点として扱う
            if(sum >= 19 && A_count > 0){
                sum -= 10;
                A_count--;
            }
        }
        return sum;
    }
    
    //手札の合計点の確認をする
    @Override
    public boolean checkSum(){
        
        //まだカードが必要ならtrueを返す
        if(open() <= 21){
            return true;
        }
        
        //カードが必要なければfalseを返す
        else{
            return false;
        }
    }
    
      //現在の手札の状態を返す
    public ArrayList<Integer> Current_Hand(){
        return myCards;
    }
    
}
