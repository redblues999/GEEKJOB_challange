/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author redblues
 */

//ディーラーが行う処理

//Humanクラスを継承
public class Dealer extends Human{
    ArrayList<Integer> cards = new ArrayList<Integer>(); //元の山札
    
    //初期処理(コンストラクタ)
    public Dealer(){
        //1から13までのカードを4セット用意
        for(int i=0;i<=3;i++){
            for(int j=1;j<=13;j++){
                cards.add(j);
            }
        }
    }
    
    //52枚の山札のカードの中から2枚引く
    public ArrayList<Integer> deal(){
        ArrayList<Integer> initial_card = new ArrayList<Integer>();
        Random rand = new Random();
        
        int init_card1 = rand.nextInt(cards.size());
        initial_card.add(cards.get(init_card1));
        cards.remove(init_card1);
        
        int init_card2 = rand.nextInt(cards.size());
        initial_card.add(cards.get(init_card2));
        cards.remove(init_card2);
        
        return initial_card;
    }
    
    //山札からカードを1枚引く
    public ArrayList<Integer> hit(){
            ArrayList<Integer> draw_card = new ArrayList<>();
            Random rand =new Random();
            
            int draw = rand.nextInt(cards.size());
            draw_card.add(cards.get(draw));
            cards.remove(draw);
            
            return draw_card;
        }
    
    //手札を増やす
    @Override//上書き
    public void setCard(ArrayList<Integer> increase){
        for(int your_hand : increase){
            myCards.add(your_hand);
        }
    }

    //手札の合計点を確認する
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
    
     //手札の合計点の処理(定義)
    @Override
    public int open(){
        int sum = 0; //合計点
        int A_count = 0; //Aが出た数
        //拡張for文の使用:myCardsのカードを増やす
        for(int point : myCards){
            //トランプに書かれてる数字がJ,Q,K(11,12,13)だったとき、点数を10にする。
            if(point >= 11){
                point = 10;
            }
            
            //Aが出た数を記憶し、一旦Aの得点を11にする
            if(point == 1){
                point = 11;
                A_count++;
            }
            
            sum += point;
            //合計が19点を超え、Aが出ていた場合はAを1点として扱う
            if(sum >= 19 && A_count > 0){
                sum -= 10;
                A_count--;
            }
        }
        return sum;
    }
    
    //現在の手札の状態を返す
    public ArrayList<Integer> Current_Hand(){
        return myCards;
    }

}
