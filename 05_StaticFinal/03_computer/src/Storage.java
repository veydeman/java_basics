public class Storage {

    private final String type;
    private final int size;
    private final int weight;

    public Storage(String type, int size, int weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
