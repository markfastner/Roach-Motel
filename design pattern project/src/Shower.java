/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Shower is an amenity that costs extra and protects
*  against sprays.
*/
public class Shower extends AmenityDecorator {
   // Default constructor
   public Shower() {
      amenityCost = 25.0;
      amenities.add(this);
   }
   
   /**
   *  Calls the getDescription() method of the 
   *  decorated room. 
   */
   @Override
   public String getDescription() {
      return "shower";
   }
   
   /**
   *  Returns the String representation of the MotelRoom.
   *
   *  @return           the String representation.
   */
   @Override
   public String toString() {
      return "shower";
   }
}