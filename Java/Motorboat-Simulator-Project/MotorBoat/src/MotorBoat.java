//Main class
public class MotorBoat {
    //All attributes
    private double fuel_capacity;
    private double fuel_amount;
    private double max_speed;
    private double current_speed;
    private double motor_efficiency;
    private double distance_traveled;

    //MotorBoat class constructor, gets initial values from user
    public MotorBoat(double init_fuel_capacity, double init_fuel_amount, double init_max_speed, double init_current_speed,
    double init_motor_efficiency, double init_distance_traveled) {
        //Initialize each class attribute to the initial values given by the user.
        fuel_capacity = init_fuel_capacity;
        fuel_amount = init_fuel_amount;
        max_speed = init_max_speed;
        current_speed = init_current_speed;
        motor_efficiency = init_motor_efficiency;
        distance_traveled = init_distance_traveled;
    }

    //Change the class's current_speed to a new speed given by the user.
    public void change_speed(double new_speed) {
        current_speed = new_speed;
    }

    //Get an amount of fuel from the user, add that fuel to the current fuel_amount.
    public void refuel_boat(double fuel) {
        fuel_amount += fuel;
    }

    //Return the fuel_amount to the user.
    public double current_fuel() {
        return fuel_amount;
    }

    //Return the distance_traveled to the user.
    public double traveled_distance() {
        return distance_traveled;
    }

    //Get the amount of time to travel from user, calculate the amount of fuel needed to travel this distance,
    //If there is less fuel_amount than fuel needed, send an error and return, otherwise reduce the fuel_amount
    //by the fuel needed, and update the distance traveled.
    public void operate_boat(double time) {
        double fuel_burn = ((Math.pow(current_speed, 2)) * motor_efficiency*time)/100;

        //If there is not enough fuel to travel, state it then end method.
        if (fuel_burn >= fuel_amount) {
            System.out.println("\nNot enough fuel, cannot operate the motorboat\n");
            return;
        }

        //State that the boat is operating (there is enough fuel)
        System.out.println("The boat is now operating.");

        //reduce the fuel amount by the amount of fuel used to travel
        fuel_amount -= fuel_burn;

        //update the distance traveled
        distance_traveled += (current_speed * time);
    }
}
