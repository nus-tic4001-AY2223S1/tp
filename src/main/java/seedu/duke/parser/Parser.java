package seedu.duke.parser;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.BorrowCommand;
import seedu.duke.command.ReturnCommand;
import seedu.duke.exception.DukeException;

public class Parser {
    public static Command parseUserInput(String userInput) throws DukeException {
        String[] firstWord = userInput.split(" ", 2);

//        int pos = userInput.indexOf(" ");
//        int pos1 = userInput.indexOf(" ", pos+1);
//        String secondWord = userInput.substring(pos+1, pos1);
//        System.out.println(secondWord);
        String secondWord = "";


        if (firstWord[0].equalsIgnoreCase("exit")) {
            return new ExitCommand();
        } else if (firstWord[0].equalsIgnoreCase("list")) {
            return new ListCommand();
//        } else if (firstWord[0].equalsIgnoreCase("list")) {
//            if (secondWord.equalsIgnoreCase("user")) {
//                return new ListUserCommand();
//            } else return new ListCommand();
        } else if (firstWord[0].equalsIgnoreCase("borrow")) {
            return new BorrowCommand();
        } else if (firstWord[0].equalsIgnoreCase("return")) {
            return new ReturnCommand();
        } else {
            throw new DukeException("\u2639 " + "OOPS!!! I'm sorry, " +
                    "but I don't know what that means :-(");
        }
    }
}

