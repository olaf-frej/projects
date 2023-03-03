import java.util.Scanner;
import java.text.DecimalFormat;

public class TestMotorBoat {
    public static void main(String[] args) {
        //Get fuel capacity from user to yse for initializing the MotorBoat class
        System.out.println("Enter the capacity of the fuel tank: ");
        Scanner capacity_in = new Scanner(System.in);
        Double fuel_capacity;
        //Input Error Checking, no value can be zero or less.
        //Conditions, Maximum Capacity 250 or less.
        do {
            //Scanning next input
            fuel_capacity = capacity_in.nextDouble();
            if (fuel_capacity <= 0) System.out.println("Please try again. Minimum Capacity: 0 gallons");
            if (fuel_capacity > 250) System.out.println("Please try again. Maximum Capacity: 250 gallons");
            //Repeating until user inputs correct conditions
        } while (fuel_capacity <= 0 | fuel_capacity > 250);

        //Get current fuel amount from user to use for initializing the MotorBoat class
        System.out.println("Enter the amount of fuel in the tank: ");
        Scanner amount_in = new Scanner(System.in);
        Double amount;
        //Input Error Checking, no value can be zero or less.
        //Conditions, cannot have more fuel than capacity.
        do {
            //Scanning next input
            amount = amount_in.nextDouble();
            if (amount <= 0) System.out.println("Please try again. Cannot operate with 0 gallons");
            if (fuel_capacity < amount)
                System.out.println("Please try again. Cannot have more fuel than: " + fuel_capacity);
            //Repeating until user inputs correct conditions
        } while (amount <= 0 | fuel_capacity < amount);

        //Get max speed from user to use for initializing the MotorBoat class
        System.out.println("Enter the maximum speed: ");
        Scanner max_speed_in = new Scanner(System.in);
        Double max_speed;
        //Input Error Checking, no value can be zero or less.
        //Conditions, Maximum Speed of Motorboat is 50 knots or less.
        do {
            //Scanning next input
            max_speed = max_speed_in.nextDouble();
            if (max_speed <= 0) System.out.println("Please try again. Cannot travel at a maximum of 0 knots");
            if (50 < max_speed) System.out.println("Please try again. Maximum Motorboat Speed is 50 knots");
            //Repeating until user inputs correct conditions
        } while (max_speed <= 0 | 50 < max_speed);

        //Get current speed from user to use for initializing the MotorBoat class
        System.out.println("Enter the current speed: ");
        Scanner current_speed_in = new Scanner(System.in);
        Double current_speed;
        //Input Error Checking, no value can be zero or less.
        //Conditions, Current speed cannot be greater than Maximum Speed
        do {
            //Scanning next input
            current_speed = current_speed_in.nextDouble();
            if (current_speed <= 0) System.out.println("Please try again. Cannot travel at 0 knots");
            if (max_speed < current_speed)
                System.out.println("Please try again. Cannot travel faster than: " + max_speed);
            //Repeating until user inputs correct conditions
        } while (current_speed <= 0 | max_speed < current_speed);

        //Get efficiency (as a percentage) from user to use for initializing the MotorBoat class
        System.out.println("Enter the efficiency (percentage): ");
        Scanner efficiency_in = new Scanner(System.in);
        Double efficiency;
        //Input Error Checking, no value can be zero or less.
        //Conditions, Efficiency can be at a maximum of 100%
        do {
            //Scanning next input
            efficiency = efficiency_in.nextDouble();
            if (efficiency <= 0) System.out.println("Please try again. Efficiency cannot be equal to or less than 0%");
            if (100 < efficiency) System.out.println("Please try again. Efficiency cannot be more than 100%");
            //Repeating until user inputs correct conditions
        } while (efficiency <= 0 | 100 < efficiency);


        //Get total distance traveled so far from user to use for initializing the MotorBoat class
        System.out.println("Enter the total distance traveled so far: ");
        Scanner distance_in = new Scanner(System.in);
        Double distance;
        //Input Error Checking, no value can be zero or less.
        do {
            //Scanning next input
            distance = distance_in.nextDouble();
            if (distance <= 0) System.out.println("Please try again. Distance traveled has to be greater than 0");
            //Repeating until user inputs correct conditions
        } while (distance <= 0);

        //Create a new MotorBoat class called my_boat using the given variables
        MotorBoat my_boat = new MotorBoat(fuel_capacity, amount, max_speed, current_speed, efficiency, distance);

        //Print the current amount of fuel in my_boat
        System.out.println("\nFuel Amount: " + my_boat.current_fuel());

        //Ask if the user wants to add more fuel
        System.out.println("Would you like to add more fuel (y/n): ");
        Scanner fuel_q = new Scanner(System.in);
        String fuel_a = fuel_q.nextLine();

        //Check if user response to adding fuel question equals y, if it does ask the user how much
        //and add that amount to the current fuel of my_boat
        if (fuel_a.equalsIgnoreCase("y")) {
            System.out.println("How much fuel would you like to add: ");
            Scanner in_fuel_to_add = new Scanner(System.in);
            Double fuel_to_add;
            Double tempfuel;
            //Input Error Checking, no value can be zero or less.
            //Conditions, Cannot add more fuel than there is capacity
            //            Fuel cannot be removed
            do {
                //Scanning next input
                fuel_to_add = in_fuel_to_add.nextDouble();
                //Creating "temporary" value of new fuel to check if it exceeds capacity without modifying original
                tempfuel = fuel_to_add + my_boat.current_fuel();
                if (fuel_to_add <= 0) System.out.println("Please try again. Cannot refuel 0 or less gallons");
                if (fuel_capacity < tempfuel)
                    System.out.println("Please try again, cannot overfill fuel past: " + fuel_capacity);
                //Repeating until user inputs correct conditions
            } while (fuel_to_add <= 0 | fuel_capacity < tempfuel);

            my_boat.refuel_boat(fuel_to_add);

            //Print the new amount of fuel in my_boat
            System.out.println("Fuel Amount: " + my_boat.current_fuel());
        }

        //Asks the user how many hours they want to operate my_boat for, then use that time variable to calculate
        //the distance the boat travels.
        System.out.println("How long would you like to operate the boat (hours): ");
        Scanner in_operation_time = new Scanner(System.in);
        Double operation_time;
        //Input Error Checking, no value can be zero or less.
        do {
            //Scanning next input
            operation_time = in_operation_time.nextDouble();
            if (operation_time <= 0) System.out.println("Please try again, cannot operate for 0 hours or less. ");
            //Repeating until user inputs correct conditions
        } while (operation_time <= 0);


        //Ask user if they want to change my_boat's current speed
        System.out.println("Would you like to change the current speed of the boat (y/n): ");
        Scanner current_speed_q = new Scanner(System.in);
        String current_speed_a = current_speed_q.nextLine();

        //If user answered y to wanting to change my_boat's current speed, ask for the new current speed value
        //and change my_boat's current speed to that new value
        if (current_speed_a.equalsIgnoreCase("y")) {
            //Get new speed from user
            System.out.println("What is the new current speed of the motorboat: ");
            Scanner in_current_speed = new Scanner(System.in);
            Double new_current_speed;
            //Input Error Checking, no value can be zero or less.
            //Conditions, New Speed cannot exceed Maximum Speed
            do {
                //Scanning next input
                new_current_speed = in_current_speed.nextDouble();
                if (new_current_speed <= 0) System.out.println("Please try again, cannot travel at 0 knots ");
                if (max_speed < new_current_speed)
                    System.out.println("Please try again, cannot travel faster than maximum speed of: " + max_speed);
                //Repeating until user inputs correct conditions
            } while (new_current_speed <= 0 | max_speed < new_current_speed);


            //Change the current speed of my_boat to the new current speed, then print a confirmation message.
            my_boat.change_speed(new_current_speed);
            System.out.println("The motorboat now has a current speed of " + new_current_speed);
        }

        //Alert user that the motorboat is operating now
        System.out.println("\nOperating the motorboat\n");

        //Operate my_boat, this will calculate the amount of fuel needed to travel for the amount of time and
        //at the current speed both provided by the user, if there is not enough fuel it will print a message
        //and end, otherwise it will update the distance traveled and remaining fuel
        my_boat.operate_boat(operation_time);

        //Create formatting for fuel and distance to round them
        DecimalFormat f = new DecimalFormat(".######");

        //Print out the remaining fuel and traveled distance of my_boat
        System.out.println("Remaining Fuel: " + String.format("%.6g%n", my_boat.current_fuel()));
        System.out.println("Updated distance: " + String.format("%.6g%n", my_boat.traveled_distance()));

    }
}