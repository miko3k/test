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
    static public void stroke(Path path, BitmapShape out) {
        for(;!path.end();path.moveToNext()) {
            System.out.println(path.getX() +";"+ path.getY());
            out.set(path.getX(), path.getY(), true);
        }   
    }
}
