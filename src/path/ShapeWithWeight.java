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
public interface ShapeWithWeight extends Shape {
    /**
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     * @return value 0 to 1 inclusive, undefined for points outside of shape
     */
    float getStrength(int x, int y);
}
