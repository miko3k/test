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
public class ShapeWithStrengthImpl implements ShapeWithWeight {
    private final float strength;
    private final Shape shape;

    public ShapeWithStrengthImpl(float strength, Shape shape) {
        this.strength = strength;
        this.shape = shape;
    }

    @Override
    public float getStrength(int x, int y) {
        return strength;
    }

    @Override
    public Rect getBoundingRect() {
        return shape.getBoundingRect();
    }

    @Override
    public boolean isInside(int x, int y) {
        return shape.isInside(x, y);
    }
}
