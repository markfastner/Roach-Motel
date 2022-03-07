/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  Payment methods for the motel.
*  Strategy Pattern.
*/
public interface PaymentMethod {
   /**
   *  Roaches pay the motel fee.
   *
   *  @param amount           the amount paid
   */
   public abstract void pay(double amount);

   
   /**
   *  Set the payment type of the roach.
   *
   *  @param card             payment type
   */
   public abstract void setPaymentType(PaymentMethod card);
   
   /**
   *  Return the colony name.
   *
   *  @return                 colony name 
   */
   public abstract String getColonyName();
}