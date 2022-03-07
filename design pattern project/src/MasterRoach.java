/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  MasterRoach cards must provide a name, a security code,
*  a card number, and an expiration date.
*/
public class MasterRoach implements PaymentMethod {
   // name of owner
   private String name;
   // security code
   private String cvv;
   // card number
   private String number;
   // expiration date
   private String date;
   // payment type
   private String type;
   
   // Default constructor
   public MasterRoach() {
      name = "";
      cvv = "";
      number = "";
      date = "";
      type = "MasterRoach";
   }
   
   /**
   *  Initializes a MasterRoach card with the given
   *  information.
   *
   *  @param name             name of owner
   *  @param cvv              security code
   *  @param number           card number
   *  @param date             expiration date
   */
   public MasterRoach(String name, String cvv,
                      String number, String date) {
      this.name = name;
      this.cvv = cvv;
      this.number = number;
      this.date = date;
      type = "MasterRoach";
   }
   
   /**
   *  Roaches pay the motel fee.
   *
   *  @param amount           the amount paid
   */
   @Override
   public void pay(double amount) {
      System.out.println(amount + "$ paid with credit/debit.");
   }

   
   /**
   *  Set the payment type of the roach.
   *
   *  @param card             payment type
   */
   @Override
   public void setPaymentType(PaymentMethod card) {
      type = "MasterRoach";
   }
   
   /**
   *  Return the colony name.
   *
   *  @return                 colony name 
   */
   @Override
   public String getColonyName() {
      return name;
   }
   
   /**
   *  Return a String representation of the class.
   *
   *  @return              the string representation
   */
   @Override
   public String toString() {
      return name + " " + number + " " + type;
   }
}