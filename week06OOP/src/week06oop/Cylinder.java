/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week06oop;

/**
 *
 * @author John White some content provided for typing by Gregory Safko
 */
public class Cylinder extends Circle implements RoundArea
{
    protected double height;
    
    public Cylinder() // constructor by JTW
    {
        super(); 
        height = 0.0;
    }
    
    public Cylinder (int x, int y, double firstRadius, double firstHeight) // by JTW
    {
        super(x,y,firstRadius);
        height = firstHeight;
    }
    
    public double getVolume() // by GS
    {
        return super.area()*height; // getArea is from circle changed to area for interface by jtw
    }
    
    
    @Override // added by jtw 
    public double area()
    {
        return ( 2*Math.PI*Math.pow(radius, 2) )+ (2*Math.PI*radius*height);
    }
    
    
}
