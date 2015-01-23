/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import path.Bitmap;
import path.CircleShape;
import path.LinePath;
import path.Path;
import path.Paths;
import path.Rect;
import path.Shape;
import path.Shapes;

/**
 *
 * @author miko
 */
public class Main {

    private static void printBitmap(Bitmap bmp) {
        for(int j=0;j<bmp.getH();++j) {
            for(int i=0;i<bmp.getW();++i) {
                String c = bmp.get(
                        bmp.getX()+i,
                        bmp.getY()+bmp.getH()-j-1) ? "X" : " ";
                System.out.print(c);
            }
            System.out.println();
        }
        
    }
    public static void main0(String[] args) {
        Bitmap bmp = new Bitmap(0, 0, 10, 10);
        /*bmp.set(0,0, true);
        bmp.set(4,0, true);
        bmp.set(0,1, true);(*/
        Path line = new LinePath(5,5,9,4);
        Paths.stroke(line, bmp);
        printBitmap(bmp);
    }
    
    public static void main(String[] args) {
        Shape rc = new CircleShape(2,5,1);
        Bitmap bmp = Shapes.toBitmap(rc);
        printBitmap(bmp);
    }
    
}
