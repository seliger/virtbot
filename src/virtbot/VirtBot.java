package virtbot;

import virtbot.userinterface.TextConsole;

public class VirtBot {
    // Everything in this class is intentionally static. It is the
    // launch point of the VirtualBot program, and it will instantiate
    // the core components, including the user interface implementation.
    // It is intentional that this calls, but does not define the user
    // interface. For example, we want to make it trivial to swap out
    // a text console for a Java Swing implementation, for example.

    private static boolean running = true;

    public static void main(String[] args) {
        // Main entrypoint into VirtualBot.
        TextConsole.doREPL();
    }

    public static boolean isRunning() {
        return running;
    }

    public static void stopRunning() {
        running = false;
    }
}
