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
public interface Spec {
    public boolean isBlocking(int x, int y);
    public void affect(int x, int y, float strength);
}
