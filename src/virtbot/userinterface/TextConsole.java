package virtbot.userinterface;

import virtbot.VirtBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextConsole {
    private static final Scanner console = new Scanner(System.in);
    private static String prompt = "> ";

    public static void doREPL() {
        // Implement our Read, Evaluate, Print Loop (REPL) to
        // handle incoming commands from the console.
        while (VirtBot.isRunning()) {
            List<String> command = promptAndWait(prompt);

            // See if we entered at least one token. If so,
            // find that token in the enumeration of commands
            // and run that command, passing in the command, so
            // it can access the arguments.
            if (!command.isEmpty()) {
                ConsoleCommands.stream()
                        .filter(cmd -> cmd.toString().equals(command.get(0).toLowerCase()))
                        .forEach(cmd -> cmd.doCommand(command));
            }
        }
    }

    public static void setPrompt(String prompt) {
        TextConsole.prompt = prompt;
    }

    private static List<String> promptAndWait(String prompt) {
        System.out.print(prompt);

        String command = console.nextLine();
        return parseCommand(command);
    }

    private static List<String> parseCommand(String command) {
        // Rather than use a string split, this is a little fancier,
        // using a Regular Expression (RegEx) to tokenize based both
        // on spaces and double-quoted strings.
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find())
            tokens.add(m.group(1).replace("\"", ""));
        return tokens;
    }
}
