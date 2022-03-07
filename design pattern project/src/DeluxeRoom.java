/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  A deluxe room costs more and changes all towels.
*/
public class DeluxeRoom extends MotelRoom {
   /**
   *  Default constructor.
   */
   public DeluxeRoom() {
      roomCost = 75.0;
   }
   
   /**
   *  Returns the description of the room.
   *
   *  @return           description of room
   */
   @Override
   public String getDescription() {
      return "deluxe";
   }
   
   /**
   *  Prints out what was done to clean the room.
   */
   @Override
	public String cleanRoomsString(){
	  	return "All linens have been cleaned and all the towels have been replaced";
	}
   
   /**
   *  Returns the String representation of the MotelRoom.
   *
   *  @return           the String representation.
   */
   @Override
   public String toString() {
      String str = getDescription() + "with: ";
		for (AmenityDecorator ad : amenities) {
			str += ad.getDescription() + ", ";
		}
		return str;
   }
}