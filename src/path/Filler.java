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
public class Filler implements Runnable {
    final private ShapeWithWeight shape;
    final private Spec spec;
    final private int originX, originY;
    final private boolean includeBlocking;

    /**
     * @param shape 
     * @param spec   
     * @param originX
     * @param originY 
     * @param includeBlocking 
     */
    public Filler(ShapeWithWeight shape, Spec spec, int originX, int originY, boolean includeBlocking) {
        this.shape = shape;
        this.spec = spec;
        this.originX = originX;
        this.originY = originY;
        this.includeBlocking = includeBlocking;
        
        if(!shape.isInside(originX, originY))
            throw new IllegalArgumentException("origin must be inside of shape");
    }
    
    @Override
    public void run() {
        Rect rc = shape.getBoundingRect();
        BitmapShape bmp = new BitmapShape(rc.getX(), rc.getY(), rc.getW(), rc.getH());
        for(ShapePath path = new ShapePath(shape); !path.end(); path.moveToNext()) {
            int x = path.getX(), y = path.getY();
            bmp.set(x, y, spec.isBlocking(x,y));
        }
        for(ShapePath path = new ShapePath(shape); !path.end(); path.moveToNext()) {
            int ax = path.getX(), ay = path.getY();
            System.out.printf("%d %d ---> %d %d\n",originX,originY,ax,ay);
            int past = 0;
            
            for(LinePath line = new LinePath(originX, originY, ax, ay); !line.end(); line.moveToNext()) {
                int x = line.getX();
                int y = line.getY();
                boolean ok = !bmp.get(x, y);
                if(ok || includeBlocking) {
                    spec.affect(x, y, shape.getStrength(x, y));
                }
                if(!ok)
                    break;
            }
        }
    }
}
