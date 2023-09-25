// VirtBot will operate out of its own root package, not the
// global namespace.
package virtbot;

import virtbot.field.DynamicField;
import virtbot.userinterface.TextConsole;
import virtbot.robot.Robot;

import java.util.ArrayList;
import java.util.List;

public class VirtBot {
    // Everything in this class is intentionally static. It is the
    // launch point of the VirtualBot program, and it will instantiate
    // the core components, including the user interface implementation.
    // It is intentional that this calls, but does not define the user
    // interface. For example, we want to make it trivial to swap out
    // a text console for a Java Swing implementation.

    private static boolean running = true;
    private static final List<Robot> robots = new ArrayList<>();
    private static final List<DynamicField> fields = new ArrayList<>();

    public static void main(String[] args) {
        // Main entrypoint into VirtualBot.
        TextConsole.doREPL();
    }

    public static List<Robot> getRobots() {
        return VirtBot.robots;
    }

    public static List<DynamicField> getFields() {
        return VirtBot.fields;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void stopRunning() {
        running = false;
    }
}
