public class Storage {

    private final StorageType type;
    private final int size;
    private final int weight;

    public Storage(StorageType type, int size, int weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public StorageType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
