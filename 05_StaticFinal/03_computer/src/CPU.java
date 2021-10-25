public class CPU {

    private final int frequency;
    private final int coreNumber;
    private final String maker;
    private final int weight;

    public CPU(int frequency, int coreNumber, String maker, int weight) {
        this.frequency = frequency;
        this.coreNumber = coreNumber;
        this.maker = maker;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public String getMaker() {
        return maker;
    }

    public int getWeight() {
        return weight;
    }
}
