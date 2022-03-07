/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Food bar is an amenity that costs extra.
*/
public class FoodBar extends AmenityDecorator {
   // Default constructor
   public FoodBar() {
      amenityCost = 10.0;
      amenities.add(this);
   }
   
   /**
   *  Calls the getDescription() method of the 
   *  decorated room. 
   */
   @Override
   public String getDescription() {
      return "food bar";
   }
   
   /**
   *  Returns the String representation of the MotelRoom.
   *
   *  @return           the String representation.
   */
   @Override
   public String toString() {
      return "food bar";
   }
}