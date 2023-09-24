package virtbot.userinterface;

import virtbot.VirtBot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum ConsoleCommands {
    // An enumeration of all the commands available to the
    // console REPL.
    help {
        public void doCommand(List<String> command) {
            // Iterate through all the commands in the
            // enumeration and display the help message.
            Arrays.asList(ConsoleCommands.values())
                    .forEach(cmd -> System.out.println(
                            cmd.toString()
                                    + "\t - \t"
                                    + cmd.getHelpString()
                    ));
        }

        public String getHelpString() {
            return "Prints this help message.";
        }
    },
    exit {
        public void doCommand(List<String> command) {
            System.out.println("Shutting down VirtBot...");
            VirtBot.stopRunning();
        }
        public String getHelpString() {
            return "Stops the VirtualBot program.";
        }
    },
    forward {
        public void doCommand(List<String> command) {
            System.out.println("Up command stub");
        }
        public String getHelpString() {
            return "Move the robot forward X increments.";
        }
    };

    // Require that all choices provide a method we will override for each
    // console command. That method will take the intended action, assuming
    // the correct arguments are passed to a given command.
    public abstract void doCommand(List<String> doCommand);
    // Require that all choices provide a method to handle help messages.
    public abstract String getHelpString();

    // This exposes a method returning an iterable stream of
    // the commands to be used by functional syntax like map,
    // filter, forEach, etc.
    public static Stream<ConsoleCommands> stream() {
        return Stream.of(ConsoleCommands.values());
    }
}
