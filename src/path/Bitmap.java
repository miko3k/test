/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path;

import java.util.BitSet;

/**
 *
 * @author miko
 */
public class Bitmap {
    final BitSet bits;
    final int x,y,w,h;
    
    public Bitmap(int x, int y, int w, int h) {
        this.bits = new BitSet(w*h);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    } 
    
    public boolean get(int x, int y) {
        x -= this.x;
        y -= this.y;
        if(x < 0 || y < 0 || x >= w || y >= h) throw new IllegalArgumentException(x + "," + y);
        
        return bits.get(y*w+x);
    }
    
    public void set(int x, int y, boolean val) {
        x -= this.x;
        y -= this.y;
        if(x < 0 || y < 0 || x >= w || y >= h) throw new IllegalArgumentException(x + "," + y);
        
        bits.set(y*w+x, val);
    }
}
