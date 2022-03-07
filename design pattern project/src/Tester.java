/**
 * @author Michael Gallagher   michael.gallagher@student.csulb.edu
 * @author Justin Chiang       justin.chiang01@student.csulb.edu
 * @author Jason Vo            jason.vo@student.csulb.edu
 * @author Mark Fastner        mark.fastner@student.csulb.edu
 * @author Colin Creasman      colin.creasman@student.csulb.edu
 * @date 12/7/20
 * CECS 277 Term Project
 *
 *  Test for roachmotel
 */
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        //creates roach motel and adds 3 rooms for it(can be easily changed in RoachMotel class)
        RoachMotel rm = RoachMotel.getInstance();
        rm.createRooms();
        System.out.println(rm);

        //creates 3 rooms and roach colonies
        //adds different amenities to each room and prints out the roach motel tostring after each room is assigned
        RoachColony rc1 = new RoachColony("Roach 1", 50, 2.5);
        ArrayList<AmenityDecorator> amenities1 = new ArrayList<AmenityDecorator>();
        amenities1.add(new Spa());
        amenities1.add(new FoodBar());
        MotelRoom r1 = rm.checkIn(rc1, "regular", amenities1);
        System.out.println(rm + "\n");

        RoachColony rc2 = new RoachColony("Roach 2", 100, .4);
        ArrayList<AmenityDecorator> amenities2 = new ArrayList<AmenityDecorator>();
        amenities2.add(new Spa());
        amenities2.add(new Shower());
        MotelRoom r2 = rm.checkIn(rc2, "deluxe", amenities2);
        System.out.println(rm + "\n");

        RoachColony rc3 = new RoachColony("Roach 3", 3000, 1.2);
        ArrayList<AmenityDecorator> amenities3 = new ArrayList<AmenityDecorator>();
        amenities3.add(new Spa());
        amenities3.add(new Shower());
        amenities3.add(new FoodBar());
        amenities3.add(new RefillBar());
        MotelRoom r3 = rm.checkIn(rc3, "suite", amenities3);
        System.out.println(rm + "\n");

        //max occupancy is 3 rooms so rc4 can not check in and will be put on the waitlist
        RoachColony rc4 = new RoachColony("Roach 4", 10, 54);
        MotelRoom r4 = rm.checkIn(rc4, "suite", amenities3);

        //testing roach party and spray
        System.out.println("\n" + rc1);
        rc1.roachParty();
        System.out.println(rc1);
        System.out.println(rc2);
        rc2.roachParty();
        System.out.println(rc2 + "\n");

        //testing donotdisturb and cleansrooms
        r1.flipDoNotDisturb();
        rm.cleanRooms();

        //testing checkout
        //checkout roach colony 1 and 2 and check in roach colony4
        System.out.println("\n");
        rm.checkOut(r1, 3,new MasterRoach(rc1.getName(), "269", "12435215", "12/08"));
        rm.checkIn(rc4, "regular", amenities1);
        rm.checkOut(r2, 5, new RoachPay(rc2.getName(), "Roachlover@yahoo.com"));
        System.out.println(rm + "\n");

        //write transaction to output and create log file with all transactions
        rm.writeTransaction();


    }
}
