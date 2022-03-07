/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  A deluxe room costs the most, changes all towels
*  and places a hamburger on the pillows.
*/
public class SuiteRoom extends MotelRoom {
   /**
   *  Default constructor.
   */
   public SuiteRoom() {
      roomCost = 100.0;
   }
   
   /**
   *  Returns the description of the room.
   *
   *  @return           description of room
   */
   @Override
   public String getDescription() {
      return "suite";
   }
   
   /**
   *  Prints out what was done to clean the room.
   */
   @Override
	public String cleanRoomsString(){
	  	return "All linens have been cleaned, all the towels have been replaced, and a hamburger is placed on each pillows.";
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
			str += ad.getDescription() + "; ";
		}
		return str;
   }
}