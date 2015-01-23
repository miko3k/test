/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import path.BitmapShape;
import path.CircleShape;
import path.LinePath;
import path.Path;
import path.Paths;
import path.Rect;
import path.ShapeWithWeight;
import path.ShapePath;
import path.Shapes;
import path.Spec;
import path.Filler;
import path.BitmapShapeWithWeight;

/**
 *
 * @author miko
 */
public class Main {

    private static void printBitmap(BitmapShape bmp) {
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
    
    private static void printShape(ShapeWithWeight s) {
        Rect rc = s.getBoundingRect();
        for(int j=0;j<rc.getH();++j) {
            for(int i=0;i<rc.getW();++i) {
                int x = rc.getX()+i;
                int y = rc.getY()+rc.getH()-j-1;
                
                if(s.isInside(x, y)) {
                    System.out.printf("%02.0f ", s.getStrength(x, y)*99);
                } else {
                    System.out.print("-- ");
                }
            }
            System.out.println();
        }        
    }
    
    public static void main0(String[] args) {
        BitmapShape bmp = new BitmapShape(0, 0, 10, 10);
        /*bmp.set(0,0, true);
        bmp.set(4,0, true);
        bmp.set(0,1, true);(*/
        Path line = new LinePath(5,5,9,4);
        Paths.stroke(line, bmp);
        printBitmap(bmp);
    }
    
    public static void main(String[] args) {
        ShapeWithWeight rc = new CircleShape(4,5,5);
        final BitmapShapeWithWeight bitmapShapeWithWeight = new BitmapShapeWithWeight(0, 0, 10, 10);
        Spec s = new Spec() {

            @Override
            public boolean isBlocking(int x, int y) {
                //if(x == 4 || y == 6 || x == 4 || y == 6) return true;
                return x == 3 || (x == 6 && (y == 5 || y == 6));
            }

            @Override
            public void affect(int x, int y, float w) {
                bitmapShapeWithWeight.set(x, y, w);
            }
        };

        Filler f = new Filler(rc, s, 5,5,false);
        f.run();
        
        printShape(bitmapShapeWithWeight);
    }
    
}
