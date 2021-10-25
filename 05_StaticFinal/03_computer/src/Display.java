public class Display {

    private final int screenSize;
    private final String type;
    private final int weight;

    public Display(int screenSize, String type, int weight) {
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

    public String getType() {
        return type;
    }
}
