public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {
        amountToTake += amountToTake / 100;
        super.take(amountToTake);
    }
}
