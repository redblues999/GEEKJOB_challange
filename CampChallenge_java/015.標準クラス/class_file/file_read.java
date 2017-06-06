/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author redblues
 */
public class file_read {
     public static void main(String[] args) throws IOException {
         
         
             File file = new File("C:\\Users\\ユーザー\\Desktop\\test.txt");
             BufferedReader br = new BufferedReader(new FileReader(file));
             
             String str = br.readLine();
             while(str != null){
                 System.out.println(str);
                 str = br.readLine();
             }
             
             br.close();
     
     }
}