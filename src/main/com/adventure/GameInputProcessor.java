package main.com.adventure;

import main.com.adventure.settings.Command;
import main.com.adventure.settings.CommandConstants;

import java.util.Locale;
import java.util.Scanner;

public class GameInputProcessor {

    /**
     * Asks the user for their next command.
     * @return the response from the user.
     */
    public String prompt() {
        System.out.println("Enter your next command:");
        Scanner aScanner = new Scanner(System.in);
        String userResponse;
        /*
        int i = userResponse.indexOf(' ');
        if(i != -1) {
            userResponse = userResponse.substring(0, i);
            return userResponse;
        }

         */
        return userResponse = aScanner.nextLine();
    }

    /**
     * Inputs that come into this method represent single action with no object. When building the command, you'll want
     * to supply the first word as the verb and leave the objectName blank.
     * Example input:
     *  "help"
     *  "look"
     *
     *  Note: this command must stay private when running the tests
     *
     * @param input - the input from the user
     * @return - the Command object with the proper verb and blank object
     */
    private Command buildSimpleCommand(String input) {
        int i = input.indexOf(' ');
        String verb = input.substring(0, i);
        return new Command(verb);
    }

    /**
     * Inputs that come into this method will have an object or objects that the action is acting on. You'll need to
     * include the object parameter as part of the Command object.
     * Example input:
     *  "use key"
     *  "examine door"
     *  "move west"
     *
     * You should also account for incomplete actions (i.e. the object is missing). In that case, you should return an
     * empty string for the object parameter.
     * Example bad input:
     *  "move"
     *  " use "
     *
     *  Note: this command must stay private when running the tests
     *
     * @param input - the input from the user
     * @return - the Command object with the proper verb and object
     */
    private Command buildCommandWithObject(String input) {
        int i = input.indexOf(' ');
        String object;
        String verb;
        if(i < 0) { //if there is no 'space in the sentence
            return new Command(input, ""); //just throw input into command function
        }
        else {
            verb = input.substring(0, i);
            object = input.substring(i + 1); //else, break up the input String
            object = object.trim();
        }
        return new Command(verb,  object); //return the spliced string method
    }


    /** DO NOT CHANGE ANYTHING BELOW THIS LINE. **/

    /**
     * Gets the next command from the user.
     * @return a command object
     */
    public Command getNextCommand() {
        String input = prompt();
        return processCommand(input);
    }

    private Command processCommand(String input) {
        String normalizedInput = input.toLowerCase(Locale.ROOT);
        if (normalizedInput.contains(CommandConstants.MOVE) ||
                normalizedInput.contains(CommandConstants.USE) ||
                normalizedInput.contains(CommandConstants.TAKE) ||
                normalizedInput.contains(CommandConstants.EXAMINE)
        ) {
            return buildCommandWithObject(normalizedInput);
        } else {
            return buildSimpleCommand(normalizedInput);
        }
    }

}
