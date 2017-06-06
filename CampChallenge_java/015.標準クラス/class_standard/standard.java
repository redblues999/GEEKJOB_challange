/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_standard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author redblues
 */
public class standard {
    public static void main(String args[]) throws IOException{
        double a = 225;
        double b = -16331;
        
        //処理の経過を書き込むログファイルを作成する
        File fp = new File("C:\\Users\\ユーザー\\Desktop\\log.txt");
        FileWriter fw = new FileWriter(fp);
        fw.write("処理を開始\n");
        //現在時刻のタイムスタンプを作成
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        fw.write(sdf.format(d)+"\n");
        fw.write(a+"の3乗は"+Math.pow(a, 3)+"です\n");
        fw.write(b+"の絶対値は"+Math.abs(b)+"です\n");
        fw.write("処理を終了");
        
        fw.close();
        
        File file = new File("C:\\Users\\ユーザ-\\Desktop\\log.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(file));
             
             String str = br.readLine();
             while(str != null){
                 System.out.println(str);
                 str = br.readLine();
             }
             
             br.close();
    }
    
}
