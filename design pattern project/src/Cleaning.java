/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Cleaning needs to go around each room. 
*  Visitor Pattern.
*/
public interface Cleaning {
   /**
   *  Cleaning visits the given room.
   *
   *  @param room             the room to clean
   */
   public abstract double visit(MotelRoom room);
}