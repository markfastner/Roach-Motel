/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Wait list is where roaches wait to get a room.
*  Subject of the Observer pattern.
*/
public interface WaitList {
   /**
   *  Add RoachColony to the wait list.
   *
   *  @param wr            the roachcolony to add
   */
   public abstract void addRoach(WaitRoach wr);
   
   /**
   *  Remove given RoachColony from the wait list.
   *
   *  @param wr            the roachcolony to remove
   */
   public abstract void removeRoach(WaitRoach wr);
   
   /**
   *  Notify all on the waitlist for an open room.
   */
   public abstract void update();
}