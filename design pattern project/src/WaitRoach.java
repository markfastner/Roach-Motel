/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Roaches on the wait list.
*  Observers of the Observer Pattern.
*/
public interface WaitRoach {
   /**
   *  Updates when the wait list is updated.
   *
   *  @param newState         the updated waitlist
   */
   public abstract void update(Object newState);
}