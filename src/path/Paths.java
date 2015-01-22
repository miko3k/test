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
public class Paths {
    static public void stroke(Path path, Bitmap out) {
        for(;!path.end();path.moveToNext()) {
            out.set(path.getX(), path.getY(), true);
        }   
    }
}
