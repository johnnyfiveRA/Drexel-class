
package week06oop;

/**
 *
 * @author John White some code provided for typing by Gregory Safko
 */

public class Circle extends Point implements RoundArea
{
    protected double radius; // changed to protected from private JTW
    
    public Circle()
    {
        super(); // calls superclass constructor must be first statment in class
        radius = 0.0;
        this.setX(0);
        this.setY(0);
        x=0; // done after access set to protected
        y=0; // done after access set to protected
        
    }
    
    public Circle(int x, int y, double firstRadius) //by JTW
    {
        super(x,y); // super class constructor 
        radius = firstRadius;
    }
    
    public double getDiameter()
    {
        return radius*2;
    }
    
    @Override // added for overridden interface class by jtw and GS
    public double area() // by JTW changed to area by GS for interface
    {
        
        return (Math.pow(radius,2)* Math.PI);
    }
    
    
} // end of class
