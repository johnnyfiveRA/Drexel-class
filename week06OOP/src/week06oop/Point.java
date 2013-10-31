package week06oop;

/**
 *
 * @author John White some provided by instructor Gergory Safko
 */

public class Point 
{
    protected int x; // set to protected from private to demonstrate access
    protected int y;
    
    public Point() // constructor by GS
    {
        x=0;
        y=0;
    }
    
    public Point(int x, int y) // secondary constructor by JTW
    {
        if (x < 0)
        {
            this.x=0;
        }
        
        else 
        {
            this.x=x;
        }
        
        if (y < 0)
        {
            this.y=0;
        }
        
        else 
        {
            this.y=y;
        }
        
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
    
} // end of point class
