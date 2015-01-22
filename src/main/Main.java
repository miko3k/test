/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import path.Bitmap;
import path.LinePath;
import path.Path;
import path.Paths;

/**
 *
 * @author miko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int bw = 10, bh = 10;
        Bitmap bmp = new Bitmap(0, 0, 10, 10);
        /*bmp.set(0,0, true);
        bmp.set(4,0, true);
        bmp.set(0,1, true);(*/
        Path line = new LinePath(5,5,9,4);
        Paths.stroke(line, bmp);
        
        for(int j=0;j<bh;++j) {
            for(int i=0;i<bw;++i) {
                String c = bmp.get(i,bh-j-1) ? "X" : " ";
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
}
