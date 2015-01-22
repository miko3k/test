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
public class EffectAreaFiller implements Runnable {
    final private Shape shape;
    final private EffectAreaSpec spec;
    final private int originX, originY;

    /**
     * @param shape   Shape to fill, (0,0) of shape will be placed at (originX, originY)
     * @param spec   
     * @param originX
     * @param originY 
     */
    public EffectAreaFiller(ShapeWithStrength shape, EffectAreaSpec spec, int originX, int originY) {
        this.shape = shape;
        this.spec = spec;
        this.originX = originX;
        this.originY = originY;
    }
    
    @Override
    public void run() {
        
    }
}
