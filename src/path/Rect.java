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
final public class Rect implements Shape {
    final int x, y;
    final int w, h;

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    @Override
    public Rect getBoundingRect() {
        return this;
    }

    @Override
    public boolean isInside(int x, int y) {
        x-=this.x; y -= this.y;
        return x >= 0 && y >= 0 && x < w && y < h;
    }
    
    
}
