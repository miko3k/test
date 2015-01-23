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
public class BitmapShapeWithWeight implements ShapeWithWeight {
    float [] data;
    final int x,y,w,h;

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
    
    public BitmapShapeWithWeight(int x, int y, int w, int h) {
        this.data = new float[w*h];
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        for(int i=0;i<data.length;++i) {
            data[i] = -1;
        }
    } 
    
    
    public float get(int x, int y) {
        x -= this.x;
        y -= this.y;
        if(x < 0 || y < 0 || x >= w || y >= h) throw new IllegalArgumentException(x + "," + y);
        
        return data[y*w+x];
    }    
    
   
    
    public void set(int x, int y, boolean val) {
        x -= this.x;
        y -= this.y;
        if(x < 0 || y < 0 || x >= w || y >= h) throw new IllegalArgumentException(x + "," + y);
        
        data[y*w+x] = val ? 1 : -1;
    }
    
    public void set(int x, int y, float f) {
        x -= this.x;
        y -= this.y;
        if(x < 0 || y < 0 || x >= w || y >= h) throw new IllegalArgumentException(x + "," + y);
        
        if(f < 0) f = 0;
        if(f > 1) f = 1;
        data[y*w+x] = f;
    }    

    @Override
    public Rect getBoundingRect() {
        return new Rect(x, y, w, h);
    }

    @Override
    public boolean isInside(int x, int y) {
        return get(x,y) >= 0;
    }    

    @Override
    public float getStrength(int x, int y) {
        return get(x,y);
    }
}
