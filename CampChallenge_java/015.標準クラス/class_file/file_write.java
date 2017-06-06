/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author redblues
 */
public class file_write {
      public static void main(String[] args) throws IOException {
    
        //ファイルを開く
        File fp = new File("C:\\Users\\ユーザー\\Desktop\\test.txt");
        //FireWriter(インスタンス)を作成
        FileWriter fw = new FileWriter(fp);
        //書き込み
        fw.write("私の名前は山下 翔太です。");
        fw.write("趣味はゲームと音楽を聞くことです。");
        //閉じる
        fw.close();
    }
    
}