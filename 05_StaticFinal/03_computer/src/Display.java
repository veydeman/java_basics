public class Display {

    private final int screenSize;
    private final DisplayType type;
    private final int weight;

    public Display(int screenSize, DisplayType type, int weight) {
        this.screenSize = screenSize;
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public DisplayType getType() {
        return type;
    }
}
