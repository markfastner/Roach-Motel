/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  RoachPay requires the name and the email of
*  the colony paying.
*/
public class RoachPay implements PaymentMethod {
   // name of owner
   private String name;
   // email of owner
   private String email;
   // payment type
   private String type;
   
   // Default constructor
   public RoachPay() {
      name = "";
      email = "";
      type = "RoachPay";
   }
   
   /**
   *  Initializes a RoachPay with the given values.
   *
   *  @param name          name of owner
   *  @param email         email of owner
   */
   public RoachPay(String name, String email) {
      this.name = name;
      this.email = email;
   }
   
   /**
   *  Roaches pay the motel fee.
   *
   *  @param amount           the amount paid
   */
   @Override
   public void pay(double amount) {
      System.out.println(amount + "4 paid with RoachPay.");
   }
   
   /**
   *  Returns the name of the owner.
   *
   *  @return              name of owner
   */
   @Override
   public String getColonyName() {
      return name;
   }


   /**
   *  Sets the card type to the given value.
   *
   *  @return              new card type
   */
   @Override
   public void setPaymentType(PaymentMethod card) {
      this.type = "RoachPay";
   }
   
   /**
   *  Return a String representation of the class.
   *
   *  @return              the string representation
   */
   @Override
   public String toString() {
      return name + " " + email + " " + type;
   }
}