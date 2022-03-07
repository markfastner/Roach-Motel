/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Abstract class for the room amenities.
*  Decorator Pattern.
*/
public abstract class AmenityDecorator extends MotelRoom {
   // motel room to decorate
   protected MotelRoom decoratedRoom;
   // price of the amenity
   protected double amenityCost;
   
   // Default constructor
   public AmenityDecorator() {
      decoratedRoom = null;
   }
   
   /**
   *  Creates an AmenityDecorator with the given
   *  motel room.
   *
   *  @param decoratedRoom       the room to be decorated
   */
   public AmenityDecorator(MotelRoom decoratedRoom) {
      this.decoratedRoom = decoratedRoom;
   }
   
   /**
   *  Calls the getDescription() method of the 
   *  decorated room. 
   */
   public String getDescription() {
      return decoratedRoom.getDescription();
   }
   
   /**
   *  Calls the getCost() method of the decorated
   *  room.
   */
   public double getCost() {
      return amenityCost;
   }
   
   /**
   *  Return nothing as amenities cannot be cleaned.
   *
   *  @return              empty string
   */
   @Override
   public String cleanRoomsString() {
      return "";
   }
   
   /**
   *  Returns the String representation of the MotelRoom.
   *
   *  @return           the String representation.
   */
   @Override
   public String toString() {
      String str = "This is a " + getDescription() + " with the following amenitites: ";
		for (AmenityDecorator ad : amenities) {
			str += ad.getDescription() + ". ";
		}
		return str;
   }
}