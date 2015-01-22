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
public class LinePath implements Path {
    void plot(int x, int y) { }
    
    private int x, y, D;
    final private int octant;
    final private int x1, dx, dy;

/*    
    void plot(int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        int D = 2 * dy - dx;
        
        plot(x0, y0);
        int y = y0;
        
        for(int x = x0+1; x <= x1; ++x) {
            if(D > 0) {
                y = y + 1;
                plot(x,y);
                D += (2 * dy - 2 * dx);
            } else {
                plot(x,y);
                D += (2 * dy);
            }
        }
    }*/    
    
    public LinePath(int X0_, int Y0_, int X1_, int Y1_) {
        final int a = X1_-X0_, b = Y1_-Y0_;
        final int X0,Y0,X1,Y1;
        
        if(b >= 0) {
            if(a >= 0) {
                if(a >= b) {
                    X0 = X0_; Y0 = Y0_;
                    X1 = X1_; Y1 = Y1_;
                    octant = 0;
                } else {
                    X0 = Y0_; Y0 = X0_;
                    X1 = Y1_; Y1 = X1_;
                    octant = 1;
                }
            } else {
                if(b >= -a) {
                    X0 = Y0_; Y0 = -X0_;
                    X1 = Y1_; Y1 = -X1_;
                    octant = 2;
                } else {
                    X0 = -X0_; Y0 = Y0_;
                    X1 = -X1_; Y1 = Y1_;
                    octant = 3;
                }
            }
        } else {
            if(a <= 0) {
                if(-a >= -b) {
                    X0 = -X0_; Y0 = -Y0_;
                    X1 = -X1_; Y1 = -Y1_;
                    octant = 4;
                } else {
                    X0 = -Y0_; Y0 = -X0_;
                    X1 = -Y1_; Y1 = -X1_;
                    octant = 5;
                } 
            } else {
                if(-b >= a) {
                    X0 = -Y0_; Y0 = X0_;
                    X1 = -Y1_; Y1 = X1_;
                    octant = 6;
                } else {
                    X0 = X0_; Y0 = -Y0_;
                    X1 = X1_; Y1 = -Y1_;
                    octant = 7;
                } 
            }
            
        }
        //System.out.println(X0_ + "," + Y0_ + "..." + X1_ + "," + Y1_ + ":" + octant);
        //System.out.println(X0 + "," + Y0 + "..." + X1 + "," + Y1);
        
        this.x1 = X1;
        this.dx = X1 - X0;
        this.dy = Y1 - Y0;
        this.D = 2 * dy - this.dx;
        
        this.y = Y0;
        this.x = X0;
        
    }

    @Override
    public boolean end() {
        return x > x1;
    }

    @Override
    public void moveToNext() {
        ++x;
        if (D > 0) {
            y = y + 1;
            D += (2 * dy - 2 * dx);
        } else {
            D += (2 * dy);
        }
    }

    @Override
    public int getX() {
        switch(octant) {
            case 0: return x;
            case 1: return y;
            case 2: return -y;
            case 3: return -x;
            case 4: return -x;
            case 5: return -y;
            case 6: return y;
            case 7: return x;
            default: throw new IllegalStateException();
        }
    }

    @Override
    public int getY() {
        switch(octant) {
            case 0: return y;
            case 1: return x;
            case 2: return x;
            case 3: return y;
            case 4: return -y;
            case 5: return -x;
            case 6: return -x;
            case 7: return -y;
            default: throw new IllegalStateException();
        }
    }
}
