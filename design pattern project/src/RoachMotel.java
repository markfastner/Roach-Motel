/**
* @author Michael Gallagher   michael.gallagher@student.csulb.edu
* @author Justin Chiang       justin.chiang01@student.csulb.edu
* @author Jason Vo            jason.vo@student.csulb.edu
* @author Mark Fastner        mark.fastner@student.csulb.edu
* @author Colin Creasman      colin.creasman@student.csulb.edu
* @date 12/7/20
* CECS 277 Term Project
* 
*  The roach motel hosts an assortment of roaches 
*  within their rooms.
*  Singleton Pattern.
*/
import java.util.*;
import java.io.*;

public class RoachMotel implements WaitList {
   // instance of RoachMotel
   private static RoachMotel instance;
   // capacity of motel
   private int capacity;
   // colonies on waitList
   private ArrayList<WaitRoach> waitList;
   // list of roach names
   private ArrayList<String> roachRoomList;
   // list of rooms available
   private ArrayList<Integer> availableRooms;
   // list of rooms being used
   private ArrayList<MotelRoom> usedRooms;
   // file writer
   private ArrayList<String> history;
   private PrintWriter pw;
   
   // Default constructor
   private RoachMotel() {
      capacity = 3;
      waitList = new ArrayList<WaitRoach>();
      roachRoomList = new ArrayList<String>();
      availableRooms = new ArrayList<Integer>();
      usedRooms = new ArrayList<MotelRoom>();
      history = new ArrayList<String>();

   }
   
   /**
   *  Returns an instance of the RoachMotel.
   *
   *  @return           instance of RoachHotel
   */
   public static RoachMotel getInstance() {
      if (instance == null) {
         instance = new RoachMotel();
      }
      return instance; 
   }
   
   /**
   *  Create the rooms in the motel.
   */
   public void createRooms() {
      for (int i = 100; i < 100 + capacity; i++) {
         availableRooms.add(i);
      }
   }
   
   /**
   *  Visual notification that there is no vacancy.
   *
   *  @param colony           the colony coming in
   */
   public void noVacancy(RoachColony colony) {
      System.out.println("There are no vacant rooms.");
      addRoach(colony);
   }
   
   /**
   *  Visual notification that there is vacancy.
   */
   public void vacancy() {
      System.out.println("There are vacant rooms!");
   }
   
   /**
   *  Displays all the amenities of a room.
   *
   *  @param amenities        list of amenities
   *  @param room             the room to list
   */
   public void displayAmenities(ArrayList<AmenityDecorator> amenities, MotelRoom room) {
      System.out.println("Adding these amenities to this room: " + amenities.toString() + "\n");
   }
   
   /**
   *  Checks in the roaches if there is an available
   *  room.
   *
   *  @param colony           roach colony
   *  @param type             type of room
   *  @param amenities        list of amenities
   *  @return                 room prepared
   */
   public MotelRoom checkIn(RoachColony colony, String type,
                            ArrayList<AmenityDecorator> amenities) {
      if (capacity == 0) {
         noVacancy(colony);
         return null;
      } else {
         capacity = availableRooms.size();
         vacancy();
         MotelRoom room = RoomFactory.createRooms(type);
         for (AmenityDecorator amen : amenities) {
//            if(amen instanceof RefillBar){
//               for(AmenityDecorator temp: amenities){
//                  if(temp instanceof FoodBar){
//                     break;
//                  }
//                  else{
//                     amenities.add(new FoodBar());
//                  }
//               }
//            }
            room.addAmenity(amen);
         }
         displayAmenities(amenities, room);
         //adds to roachroom list and used roomlist
         roachRoomList.add(room.toString() + " = " + colony.toString() + " ");
         usedRooms.add(room);
         //sets room number to the first available room
         room.setRoomNum(availableRooms.get(0));
         //removes the first vailable room number from the arraylist
         availableRooms.remove(0);
         colony.setRoom(room);
         for (int i = 0; i < waitList.size(); i++) {
            if (waitList.get(i).equals(colony)) {
               removeRoach(colony);
            }
         }
         //lowers the capacity
         capacity--;
         return room;
      }
   }
   
   /**
   *  Check out the roach out of the room and charge them.
   *
   *  @param room             the room being checked out of
   *  @param numDays          days stayed
   *  @param card             the payment method
   */
   public double checkOut(MotelRoom room, int numDays, PaymentMethod card) {
      MaidStaff cashier = new MaidStaff();
      double charge = cashier.visit(room) * numDays;
      String colony = "";
      availableRooms.add(availableRooms.size(), room.getRoomNum());
      for (int i = 0; i < roachRoomList.size(); i++) {
         if (roachRoomList.get(i).contains(room.toString())) {
            roachRoomList.remove(i);
         }
      }
      usedRooms.remove(room);
      card.pay(charge);
      card.setPaymentType(card);
      colony = card.getColonyName();
      capacity = availableRooms.size();
      if (capacity == 1) {
         update();
      }
      logTransaction(charge, colony, card);
      return charge;
   }
   
   /**
   *  Return a formatted transaction and adds it to arraylist
   *
   *  @param charge           the price of the stay
   *  @param name           name of the colony
   *  @param card             the payment type
   */
   public void logTransaction(double charge, String name, PaymentMethod card) {
      String log = name + " paid $" + charge + " using " + card.toString();
      history.add(log);
   }
   
   /**
   *  Write the transaction to the file.
   *  
   *  @param transaction            the receipt statement
   */
   
   /**
   *  Add RoachColony to the wait list.
   *
   *  @param wr            the roachcolony to add
   */
   @Override
   public void addRoach(WaitRoach wr) {
      waitList.add(wr);
   }
   
   /**
   *  Remove given RoachColony from the wait list.
   *
   *  @param wr            the roachcolony to remove
   */
   @Override
   public void removeRoach(WaitRoach wr) {
      waitList.remove(wr);
   }
   
   /**
   *  Notify all on the waitList for an open room.
   */
   @Override
   public void update() {
      for (int i = 0; i < waitList.size(); i++) {
         waitList.get(i).update(waitList.get(i));
      }
   }
   
   /**
   *  Display which rooms need to be cleaned. 
   */
   public void cleanRooms() {
      String intro = "Rooms needed to be cleaned: ";
      for (int i = 0; i < usedRooms.size(); i++) {
         intro += usedRooms.get(i).getRoomNum() + ", ";
      }
      System.out.println(intro);
      for (int i = 0; i < usedRooms.size(); i++) {
         MotelRoom room = usedRooms.get(i);
         if (room.getDoNotDisturb()) {
            System.out.println("Room " + room.getRoomNum() + " doesn't want to be disturbed.");
         } else {
            System.out.println("Room " + room.getRoomNum() + ": " + room.cleanRoomsString()); 
         }
      }
   }
   
   /**
   *  Reads in a file and prints out the transaction log.
   *
   *  creates and fills a transaction file and reads from it
   */
   public void writeTransaction() {
      try {
         pw = new PrintWriter("log.txt");

            for (String charge : history) {
               pw.println(charge);
            }
         }
      catch (IOException io) {
         System.out.println("File could not be written.");
      }
      finally {
         pw.close();
      }
      try{
         Scanner scan = new Scanner(new File("log.txt"));
            while(scan.hasNextLine()){
               String line = scan.nextLine();
               System.out.println(line);
            }
         }

         catch(FileNotFoundException e){

      }
   }
   
   /**
   *  Returns the String representation of the class.
   *
   *  @return                    the String representation
   */
   @Override
   public String toString() {
      return "Roach Motel has " + roachRoomList + "\nAvailable Rooms: " + availableRooms;
   }
   
   /**
   *  Spray a room down after the roaches have partied. 
   *
   *  @param colony              the partying roach colony
   */
   public static void sprayRoom(RoachColony colony) {
      ArrayList<AmenityDecorator> amenities = colony.getRoom().getAmenities();
      for (AmenityDecorator amen : amenities) {
         if (amen instanceof Shower) {
            System.out.println("Room has spray-resistant shower.");
            colony.setSize(colony.getSize() * 0.75);
            return;
         }
      }
      System.out.println("Room will be sprayed at full capacity.");
      colony.setSize(colony.getSize() * 0.50);
   }
}