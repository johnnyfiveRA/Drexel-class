package tranglecli;
/**
 *
 * @author John White
 */

public class Triangle 
{
    // Class properties 
    
    //maybe make these doubles or floats? might be more useful
    
    private int side1;
    private int side2;
    private int side3;
    private boolean isRight; // flag within object to tell if it is right
        
    // Constructors
    
    public Triangle()
    {
        side1 = 1;
        side2 = 1;
        side3 = 1;
        isRight = false;
        
    } // default constructor end
    
    public Triangle(int providedSide1, int providedSide2, int providedSide3 )
    {
        side1 = providedSide1;
        side2 = providedSide2;
        side3 = providedSide3;
        isRight = this.isRight(); // is this thing a right triangle?
        
    } // parameterized constructor end
    
    // Accessors
    
    public int getSide1()
    {
        return side1;
    }
    
    public int getSide2()
    {
        return side2;
    }
    
    public int getSide3()
    {
        return side3;
    }
    
    public int getPerimeter()
    {
        return (side1 + side2 + side3); // parentheses for clarity
    }
    
    // some heron formula usage? (done, probably ok but needs testing)
    
    public double getArea()
    {
        // get semi perimeter for heron's formula
        
        double semiPerimeter = (this.getPerimeter() / 2.0); // auto type cast
        
        return Math.sqrt(semiPerimeter * (semiPerimeter-side1) * (semiPerimeter-side2) * (semiPerimeter-side3) ); 
        // another (technically series) of auto type casts were done above. 
    }
    
    public boolean getIsRight()
    {
        return isRight;
    }
    
    // get angles? (option) easy logic with right triangle
    
    /* get angle from sides? (option) 
    * law of cosines target^2 = aside^2 + otherside^2 - 2aside*otherside cos(target) could be useful
    */
    
    // end of get methods 
    //--------------------------------------------------------------------
    
    // Mutators
    
    public void setSide1(int newSide1)
    {
        side1 = newSide1;
    }
    
    public void setSide2(int newSide2)
    {
        side2 = newSide2;
    }
    
    public void setSide3(int newSide3)
    {
        side3 = newSide3;
    }
    
    // Facilitators 
    
    /* explore implementing a sanity check function that makes sure that the sides that are input 
     * actually make a triangle. Although this maybe a job for the user of this object
     * a+b>c a+c>b b+c>a 
    */
    
    private boolean isRight() 
    {
      /*Yea I could have just set the variable but I already wrote it as an accessor
      * then I made it a facilitator which would mean it should be private in this case
      * I did that after seeing project 3-2. Wanted to get this object complete 
      * to use it for it. Having to call this function everytime to get the triangle state
      * was dumb anyway.
      */ 
    
        // find out which side is bigger. Might be doing this in a dumb way but
        // it'll work (so long as the logic is right
        
        if ( (side1 > side2) && (side1 > side3)) // if side1 is the biggest
        {
            if (Math.pow(side2,2) + Math.pow(side3,2) == Math.pow(side1, 2) )
            {
                // add up the squares of the other two sides and if they are equal
                return true; //then it is a right triangle 
            }
            else
            {
                return false;
            }
        }   // side1 logic ends
        
        // logic repeats for sides 2 and 3
        
        if ( (side2 > side1) && (side2 > side3)) // if side2 is the biggest
        {
            if (Math.pow(side1,2) + Math.pow(side3,2) == Math.pow(side2, 2) )
            {
                // add up the squares of the other two sides and if they are equal
                return true; //then it is a right triangle 
            }
            else
            {
                return false;
            }
        }   // side2 logic ends
        
        if ( (side3 > side1) && (side3 > side2)) // if side3 is the biggest
        {
            if (Math.pow(side1,2) + Math.pow(side2,2) == Math.pow(side3, 2) )
            {
                // add up the squares of the other two sides and if they are equal
                return true; //then it is a right triangle 
            }
            else
            {
                return false; 
            }
        }   // side3 logic ends
        
        return false; // this statement should only be reached in one edge case (all sides the same) 
    
    } // Right trangle check over 
    
} // class over 
