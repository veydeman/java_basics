public class Delivery {

    private final Dimensions dimensions;
    private final int weight;
    private final String address;
    private final boolean canBeTurned;
    private final String regNumber;
    private final boolean isFragile;

    public Delivery(Dimensions dimensions, int weight, String address, boolean canBeTurned, String regNumber,
                    boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.canBeTurned = canBeTurned;
        this.regNumber = regNumber;
        this.isFragile = isFragile;
    }

    public Delivery setDimensions(int length, int width, int height) {
        return new Delivery(new Dimensions(length, width, height), weight, address, canBeTurned, regNumber, isFragile);
    }

    public Delivery setAddress(String address) {
        return new Delivery(dimensions, weight, address, canBeTurned, regNumber, isFragile);
    }

    public Delivery setWeight(int weight) {
        return new Delivery(dimensions, weight, address, canBeTurned, regNumber, isFragile);
    }

    public int getLength() {
        return this.dimensions.getLength();
    }

    public int getWidth() {
        return this.dimensions.getWidth();
    }

    public int getHeight() {
        return this.dimensions.getHeight();
    }

    public int getVolume() {
        return this.dimensions.calculateVolume();
    }

    public String getAddress() {
        return this.address;
    }

    public int getWeight() {
        return this.weight;
    }
}
