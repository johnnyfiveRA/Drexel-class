
package week06oop;

/**
 *
 * @author John White content provided for typing by Gregory Safko
 */

public class Ellipse extends AbstractShape
{
    //area = pi*majordiag*minordiag
    
    public Ellipse()
    {
        
    }
    
    @Override
    public double getColor()
    {
        return 9.9; 
        /* JTW this isn't meaningful but demonstrates that members of abstract classes
         * must have the methods prototyped inside the abstract classes
         * and all subclasses of abstract classes will have the fields inside them.
         */
    }
    
}
