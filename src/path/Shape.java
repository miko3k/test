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
public interface Shape {
    Rect getBoundingRect();
    boolean isInside(int x, int y);
}
