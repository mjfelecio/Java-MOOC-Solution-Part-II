package FlightControl;

import FlightControl.logic.FlightControl;
import FlightControl.ui.FlightControlInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // test your code here
        Scanner scanner = new Scanner(System.in);
        FlightControl flightControl = new FlightControl();

        FlightControlInterface controlInterface = new FlightControlInterface(flightControl, scanner);
        controlInterface.start();
    }
}
