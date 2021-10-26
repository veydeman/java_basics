public class RAM {

    private final RAMType type;
    private final int size;
    private final int weight;

    public RAM(RAMType type, int size, int weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public RAMType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
