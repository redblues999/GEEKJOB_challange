/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import  java.util.ArrayList;

/**
 *
 * @author redblues
 */

//抽象クラスの作成
public abstract class Human {
    protected ArrayList<Integer> myCards = new ArrayList<Integer>();
    //公開メソッドの作成
    abstract protected int open();
    abstract protected void setCard(ArrayList<Integer> list);
    abstract protected boolean checkSum();
}