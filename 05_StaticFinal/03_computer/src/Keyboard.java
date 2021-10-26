public class Keyboard {

    private final KeyboardType type;
    private final KeyboardRGBLight rgbLight;
    private final int weight;

    public Keyboard(KeyboardType type, KeyboardRGBLight rgbLight, int weight) {
        this.type = type;
        this.rgbLight = rgbLight;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public KeyboardRGBLight getRgbLight() {
        return rgbLight;
    }

}

