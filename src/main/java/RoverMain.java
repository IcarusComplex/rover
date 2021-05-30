import model.rover.Rover;
import model.rover.RoverLocation;
import model.rover.exceptions.InvalidNavigationOrderException;
import services.navigation.RoverNavigationService;
import util.CardinalDirections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoverMain {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String [] args) throws IOException {
        // TODO ugly hack to get an infinite command line input going for MVP
        Rover rover = new Rover(0, 0, CardinalDirections.NORTH);
        System.out.println("ROVER HAS LANDED AT " + rover.toString() + "\n");
        while (true){
            try {
                System.out.println("ISSUE DIRECTION COMMANDS BY COMBINING INPUT PARAMETERS:\nF (FORWARD), B (BACKWARD), R (RIGHT TURN), L (LEFT TURN)");
                String command = readLine();

                RoverLocation newLocation = RoverNavigationService.getInstance().executeNavigationCommand(rover, command);
                System.out.println("\n\nROVER HAS MOVED TO:");
                System.out.println(newLocation);

                System.out.println("YOU CAN TYPE <exit> to quit at any time");
            } catch (InvalidNavigationOrderException | InterruptedException e) {
                System.out.println("INVALID MOVE COMMAND. PLEASE TRY AGAIN USING ONLY THE CHARACTERS SHOWN IN THE PROMPT...\n");
            }
        }
    }

    private static String readLine() throws IOException, InterruptedException {
        String input = br.readLine();
        if (input.equalsIgnoreCase("exit")){
            System.out.println("DISCONNECTING FROM ROVER...");
            Thread.sleep(300);
            System.out.println("SUCCESSFULLY DISCONNECTED FROM ROVER...");
            System.out.println("SHUTTING DOWN...");
            Thread.sleep(300);

            System.exit(0);
        }

        return input;
    }

}
