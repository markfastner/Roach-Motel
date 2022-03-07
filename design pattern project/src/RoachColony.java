/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Roaches that want to stay at the Roach Motel.
*/
public class RoachColony implements WaitRoach {
   // the name of the colony
   private String name;
   // the size of the colony
   private double size;
   // the growth rate of the colony
   private double growthRate;
   // motel room of colony
   private MotelRoom mr;
   
   // Default constructor
   public RoachColony() {
      name = "";
      size = 0;
      growthRate = 0.0;
      mr = null;
   }
   
   /**
   *  Initialize a RoachColony with the given
   *  information.
   *  
   *  @param name          name of colony
   *  @param size          size of colony
   *  @param growthRate    growth rate of colony
   */
   public RoachColony(String name, int size, double growthRate) {
      this.name = name;
      this.size = size;
      this.growthRate = growthRate;
   }
   
   /**
   *  Returns the name of the colony.
   *
   *  @return              name of colony
   */
   public String getName() {
      return name;
   }
   
   /**
   *  Set the name of the colony to the given value.
   *
   *  @param               new name of colony
   */
   public void setName(String name) {
      this.name = name;
   }
   
   /**
   *  Returns the size of the colony.
   *
   *  @return              size of colony
   */
   public double getSize() {
      return size;
   }
   
   /**
   *  Sets the size of the colony to the given value.
   *
   *  @param size          new size of colony
   */
   public void setSize(double size) {
      this.size = size;
   }
   
   /**
    *  Returns the growth rate of the colony.
    *
    *  @return              growth rate of colony
    */
   public double getGrowthRate() {
      return growthRate;
   }

   /**
   *  Sets the growth rate to the given value.
   *
   *  @param growthRate    new growth rate of colony
   */
   public void setGrowthRate(int growthRate) {
      this.growthRate = growthRate;
   }
   
   /**
   *  Returns the motel room of the colony.
   *
   *  @return              motel room of colony
   */
   public MotelRoom getRoom() {
      return mr;
   }
   
   /**
   *  Sets the motel room to the given value.
   *
   *  @param mr            new motel room of colony
   */
   public void setRoom(MotelRoom mr) {
      this.mr = mr;
   }
   
   /**
   *  Updates the colony that a new room is available
   *  in the motel.
   *
   *  @param state         current wait list state
   */
   @Override
   public void update(Object state) {
		System.out.println(this.name + " is notified that a room is available.");
	}
   
   /**
   *  Roaches have a party and increase their population
   *  by their growth rate. Then, the room is sprayed down.
   */
   public void roachParty() {
      System.out.println("It's party time!");
      System.out.println(getName() + " is throwing a party");
      size += size * growthRate;
      RoachMotel.sprayRoom(this);
   }
   
   /**
   *  Return a String representation of the class.
   *
   *  @return              the string representation
   */
   @Override
   public String toString() {
      return name + ": " + size;
   }
}