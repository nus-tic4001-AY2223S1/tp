package seedu.duke.parser;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.ListUserCommand;
import seedu.duke.command.BorrowCommand;
import seedu.duke.command.ReturnCommand;
import seedu.duke.command.SearchCommand;
import seedu.duke.exception.DukeException;

public class Parser {
    public static Command parseUserInput(String userInput) throws DukeException {
        try {
            if (userInput.split("/")[0].trim().equalsIgnoreCase("exit")) {
                return new ExitCommand();
            } else if (userInput.split("/")[0].trim().equalsIgnoreCase("search")) {
                return new SearchCommand();
            } else if (userInput.split("/")[0].trim().equalsIgnoreCase("borrow")) {
                return new BorrowCommand();
            } else if (userInput.split("/")[0].trim().equalsIgnoreCase("return")) {
                return new ReturnCommand();
            } else if ((userInput.split("/")[0].trim() + " /" + userInput.split("/")[1].trim()).
                    equalsIgnoreCase("list /user") || (userInput.split("/")[0].trim() +
                    " /" + userInput.split("/")[1].trim()).equalsIgnoreCase("list /u")) {
                return new ListUserCommand();
            } else if ((userInput.split("/")[0].trim() + " /" + userInput.split("/")[1].trim()).
                    equalsIgnoreCase("list /library") || (userInput.split("/")[0].trim() +
                    " /" + userInput.split("/")[1].trim()).equalsIgnoreCase("list /l")) {
                return new ListCommand();
            } else if (userInput.split("/")[0].trim().equalsIgnoreCase("borrow")) {
                return new BorrowCommand();
            } else if (userInput.split("/")[0].trim().equalsIgnoreCase("return")) {
                return new ReturnCommand();
            } else {
                throw new DukeException("\u2639 " + "OOPS!!! I'm sorry, " +
                        "but I don't know what that means :-(");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Refer to documentation for the command syntax: " + e.getMessage());
        }
    }
}

