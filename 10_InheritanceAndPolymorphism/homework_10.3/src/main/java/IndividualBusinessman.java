public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            amountToPut -= amountToPut / 100;
        } else if (amountToPut >= 1000) {
            amountToPut -= (amountToPut * 0.5) / 100;
        }
        super.put(amountToPut);
    }
}
