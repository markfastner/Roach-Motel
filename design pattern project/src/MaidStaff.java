/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  The maid staff cleans each room that doesn't have 
*  a Do Not Disturb sign on it.
*/
public class MaidStaff implements Cleaning {
   /**
   *  Cleaning visits the given room.
   *
   *  @param room             the room to clean
   */
   @Override
   public double visit(MotelRoom room) {
      return room.getCost();
   }
   
   /**
   *  Returns a String representation of the class.
   *
   *  @return              String representation
   */
   @Override
   public String toString() {
      return "This is the cleaning staff.";
   }
}