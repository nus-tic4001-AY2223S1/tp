package seedu.duke.parser;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.ListUserCommand;
import seedu.duke.command.BorrowCommand;
import seedu.duke.command.ReturnCommand;
import seedu.duke.command.ReserveCommand;
import seedu.duke.command.CancelCommand;
import seedu.duke.command.SearchCommand;
import seedu.duke.exception.DukeException;

/**
 * <code>Parser</code> class translates all the user input commands into a Librarian
 * app readable format. In addition, it provides optimized CLI syntax to support
 * efficient typing experience of end-users.
 */
public class Parser {
    public static Command parseUserInput(String userInput) throws DukeException {
        try {
            if ((userInput.split("/")[0].trim()).equalsIgnoreCase("e") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("exit")) {
                return new ExitCommand();
            } else if ((userInput.split("/")[0].trim()).equalsIgnoreCase("h") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("help")) {
                return new HelpCommand();
            } else if ((userInput.split("/")[0].trim() + "/" +
                    userInput.split("/")[1].trim()).equalsIgnoreCase("s/t") ||
                    (userInput.split("/")[0].trim() + "/" +
                            userInput.split("/")[1].trim()).equalsIgnoreCase("s/a") ||
                    (userInput.split("/")[0].trim() + "/" +
                            userInput.split("/")[1].trim()).equalsIgnoreCase("s/c") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("search")) {
                return new SearchCommand();
            } else if ((userInput.split("/")[0].trim() + "/").equalsIgnoreCase("rb/") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("reserve")) {
                return new ReserveCommand();
            } else if ((userInput.split("/")[0].trim() + "/").equalsIgnoreCase("cb/") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("cancel")) {
                return new CancelCommand();
            } else if ((userInput.split("/")[0].trim() + "/").equalsIgnoreCase("b/") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("borrow")) {
                return new BorrowCommand();
            } else if ((userInput.split("/")[0].trim() + "/").equalsIgnoreCase("r/") ||
                    userInput.split("/")[0].trim().equalsIgnoreCase("return")) {
                return new ReturnCommand();
            } else if (userInput.equalsIgnoreCase("l/u") ||
                    (userInput.split("/")[0].trim() + " /" + userInput.split("/")[1].trim()).
                    equalsIgnoreCase("list /user")) {
                return new ListUserCommand();
            } else if (userInput.equalsIgnoreCase("l/l") ||
                    (userInput.split("/")[0].trim() + " /" + userInput.split("/")[1].trim()).
                    equalsIgnoreCase("list /library")) {
                return new ListCommand();
            } else {
                throw new DukeException("\u2639 " + "OOPS!!! I'm sorry, " +
                        "but I don't know what that means :-(");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Refer to documentation for the command syntax: " + e.getMessage());
        }
    }
}

