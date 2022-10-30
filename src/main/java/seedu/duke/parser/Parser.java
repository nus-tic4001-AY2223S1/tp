package seedu.duke.parser;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.ListUserCommand;
import seedu.duke.command.BorrowCommand;
import seedu.duke.command.ReturnCommand;
import seedu.duke.exception.DukeException;

public class Parser {
    public static Command parseUserInput(String userInput) throws DukeException {
        if (userInput.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        } else if (userInput.contains("borrow /")) {
            return new BorrowCommand();
        } else if (userInput.contains("return /")) {
            return new ReturnCommand();
        } else if (userInput.equalsIgnoreCase("list /user") ||
                userInput.equalsIgnoreCase("list /u")) {
            return new ListUserCommand();
        } else if (userInput.equalsIgnoreCase("list /library") ||
                userInput.equalsIgnoreCase("list /lib") ||
                userInput.equalsIgnoreCase("list /l") ||
                userInput.equalsIgnoreCase("list")) {
            return new ListCommand();
        } else if (userInput.startsWith("borrow")) {
            return new BorrowCommand();
        } else if (userInput.startsWith("return")) {
            return new ReturnCommand();
        } else {
            throw new DukeException("\u2639 " + "OOPS!!! I'm sorry, " +
                    "but I don't know what that means :-(");
        }
    }
}

