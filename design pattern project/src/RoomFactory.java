/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Creates rooms of the desired type.
*  Factory Pattern.
*/
public class RoomFactory {
   /**
   *  Creates rooms of the given type.
   *
   *  @param type          type of room to create
   *  @return              desired room type
   */
   public static MotelRoom createRooms(String type) {
      MotelRoom mr = null;
      if (type.equalsIgnoreCase("REGULAR")) {
         mr = new RegularRoom();
      } else if (type.equalsIgnoreCase("DELUXE")) {
         mr = new DeluxeRoom();
      } else if (type.equalsIgnoreCase("SUITE")) {
         mr = new SuiteRoom();
      }
      return mr;
   }
}