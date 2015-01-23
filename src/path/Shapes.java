/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path;

/**
 *
 * @author miko
 */
public class Shapes {
    public static BitmapShape toBitmap(Shape shape) {
        Rect rc = shape.getBoundingRect();
        BitmapShape result = new BitmapShape(rc.getX(), rc.getY(), rc.getW(), rc.getH());
        int x1 = rc.getX();
        int y1 = rc.getY();
        int x2 = x1 + rc.getW();
        int y2 = y1 + rc.getH();
        
        for(int y=y1; y < y2; ++y) {
            for(int x=x1; x < x2; ++x) {
                result.set(x, y, shape.isInside(x, y));
            }
        }
        return result;
    }
}
