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
public class ShapePath implements Path {
    private final Shape shape;
    private final int x1, y1, x2, y2;
    private boolean end;
    private int x, y;

    private boolean move() {
        ++x;
        if (x >= x2) {
            x = x1;
            ++y;
        }
        return (y < y2);
    }
    
    public ShapePath(Shape shape) {
        this.shape = shape;
        Rect rc = shape.getBoundingRect();
        x1 = rc.getX();
        y1 = rc.getY();
        x2 = x1 + rc.getW();
        y2 = y1 + rc.getH();

        x = x1; y = y1;
        while(true) {
            if(shape.isInside(x, y)) {
                end = false;
                return;
            }
            if(!move()) {
                end = true;
                return;
            }
        }
    }

    @Override
    public boolean end() {
        return end;
    }

    @Override
    public void moveToNext() {
        if(end)
            throw new IllegalStateException("no more elements");
        
        while(true) {
            if(!move())
                end = true;
            if(shape.isInside(x, y))
                break;
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
