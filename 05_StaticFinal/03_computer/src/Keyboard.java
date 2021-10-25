public class Keyboard {

    private final String type;
    private final boolean rgbLight;
    private final int weight;

    public Keyboard(String type, boolean rgbLight, int weight) {
        this.type = type;
        this.rgbLight = rgbLight;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String isRgbLight() {
        if (this.rgbLight) {
            return "Есть";
        } else
            return "Отсутствует";
    }
}
