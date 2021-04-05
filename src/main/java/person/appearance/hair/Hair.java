package person.appearance.hair;

public class Hair {
    private final String hairLength;
    private final String color;

    public Hair(final String hairLength, final String color) {
        this.hairLength = hairLength;
        this.color = color;
    }

    @Override
    public final String toString() {
        return hairLength + color;
    }
}