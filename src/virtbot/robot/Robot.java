package virtbot.robot;
public class Robot {

    private enum Face {
        NORTH ("⍓"),
        SOUTH ("⍌"),
        EAST ("⍄"),
        WEST ("⍃");

        private final String face;

        Face(String face) {
            this.face = face;
        }

        public String getFace() {
            return face;
        }

    }

    private String name;
}
