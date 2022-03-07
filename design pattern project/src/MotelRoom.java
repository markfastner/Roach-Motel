/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  A motel room has a list of amenities and a price per room.
*/
import java.util.*;

public abstract class MotelRoom {
   // the list of amenities
   protected ArrayList<AmenityDecorator> amenities;
   // room number of the room
   protected int roomNum;
   // cost of the room
   protected double roomCost;
   // true if there is no cleaning necessary, false otherwise
   protected boolean doNotDisturb;
   
   /**
   *  Default constructor
   */
   public MotelRoom() {
      amenities = new ArrayList<AmenityDecorator>();
      doNotDisturb = false;
   } 
   
   /**
   *  Returns the description of the room.
   *
   *  @return           description of room
   */
   public abstract String getDescription();
   
   /**
   *  Returns the cost of the room.
   *
   *  @return           cost of the room
   */
   public double getCost() {
      return roomCost + getAmenityCost();
   }
   
   /**
   *  Prints out what was done to clean the room.
   */
	public abstract String cleanRoomsString();
    
   /**
   *  Adds an amenity to the room.
   *
   *  @param a          amenity to be added
   */
   public void addAmenity(AmenityDecorator a) {
      amenities.add(a);
   }
   
   /**
   *  Returns the cost of the amenities in the room.
   *
   *  @return           the total cost of amenities
   */
   public double getAmenityCost() {
      double cost = 0;
      for (AmenityDecorator amen : amenities) {
         cost += amen.getCost();
      }
      return cost; 
   }
   /**
    *  Sets the amenities in the room to the
    *  given list.
    *
    *  @param list       the new list of amenities
    */
   public void setAmenities(ArrayList<AmenityDecorator> list) {
      this.amenities = list;
   }

   /**
   *  Return the list of amenities in the room.
   *
   *  @return           the list of amenities
   */
   public ArrayList<AmenityDecorator> getAmenities() {
      return amenities;
   }

   
   /**
   *  Returns the room number of the room.
   *
   *  @return           the room number
   */
   public int getRoomNum() {
      return roomNum;
   }
   
   /**
   *  Sets the room number to the given number.
   *
   *  @param num        the new room number
   */
   public void setRoomNum(int num) {
      this.roomNum = num;
   }
   
   /**
   *  Returns if the room does not want to be disturbed.
   *
   *  @return           state of do not disturb
   */
   public boolean getDoNotDisturb() {
      return doNotDisturb;
   }
   
   /**
   *  Flips the sign on do not disturb.
   */
   public void flipDoNotDisturb() {
      doNotDisturb = !doNotDisturb;
   }
   
   /**
   *  Returns the String representation of the MotelRoom.
   *
   *  @return           the String representation.
   */
   @Override
   public String toString() {
      String str = "This is a " + getDescription() + " with the following amenitites: ";
		for (AmenityDecorator amen : amenities) {
			str += amen.getDescription() + ". ";
		}
		return str;
   }
}