
package week07staticfinal;

/**
 *
 * @author John
 */
public class Point 
{
    private int x;
    private int y;
    
    public Point() // constructor by GS
    {
        x=0;
        y=0;
    }
    
    public Point(int x, int y) // secondary constructor by JTW
    {
        
            this.x=x;
            this.y=y;
            
    }// end of second constructor
    
    public void setX(int x) // mutators by GS
    {
        this.x=x;
    }
    
    public void setY(int y) // mutators by GS
    {
        this.y=y;
    }
    
    public int getX() // accessors by GS
    {
        return x;
    }
    public int getY() // accesor by GS
    {
        return y;
    }
    
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
            return false;
        else if (other == this)
            return true;
        else if ( !(other instanceof Point) )
            return false;
        
        Point castedObject = (Point)other;
        if (this.x == castedObject.getX() && this.y == castedObject.getY())
        {
            return true;
        }
        
        return false;
    }
    
} // end of point class

