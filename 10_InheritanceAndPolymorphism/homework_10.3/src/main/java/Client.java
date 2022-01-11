public abstract class Client {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0) {
            amount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake > 0 & getAmount() >= amountToTake) {
            amount = amount - amountToTake;
        }
    }
}
