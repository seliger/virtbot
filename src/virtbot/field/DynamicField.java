package virtbot.field;

public class DynamicField {
    private final int width;
    private final int length;
    private final int locationInterval;

    public DynamicField() {
        // Default constructor with reasonable defaults.
        this(16000, 8000, 400);
    }

    public DynamicField(int width, int length, int locationInterval) {
        this.width = width;
        this.length = length;
        this.locationInterval = locationInterval;


    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    public int getLocationInterval() {
        return this.locationInterval;
    }

}
