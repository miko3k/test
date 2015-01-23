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
public class CircleShape implements ShapeWithWeight {
    private final int radius;
    private final int x, y;

    public CircleShape(int radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public Rect getBoundingRect() {
        return new Rect(x-radius, y-radius, radius*2+1, radius*2+1);
    }

    @Override
    public boolean isInside(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        int r = radius;
        //System.out.println(x + "," + y + ";" + dx + "," + dy + "," + r + ":" + (dx*dx+dy*dy <= r*r));
        return (dx*dx+dy*dy <= r*r+1);
    }

    @Override
    public float getStrength(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        int r = radius;
        // quite a hack, but results seem ok
        int max = r*r+3;
        
        return (float)(max-(dx*dx+dy*dy))/(float)max;
    }
}
