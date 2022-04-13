public class Operation {

    private final String accountType;
    private final String accountNumb;
    private final String currency;
    private final String operationDate;
    private final String refProvod;
    private final String opDiscpription;
    private final double prihod;
    private final double rashod;

    public Operation(String accountType, String accountNumb, String currency, String operationDate, String refProvod,
                     String opDiscpription, double prihod, double rashod) {
        this.accountType = accountType;
        this.accountNumb = accountNumb;
        this.currency = currency;
        this.operationDate = operationDate;
        this.refProvod = refProvod;
        this.opDiscpription = opDiscpription;
        this.prihod = prihod;
        this.rashod = rashod;
    }

    public double getPrihod() {
        return prihod;
    }

    public double getRashod() {
        return rashod;
    }

    public String getOpDiscpription() {
        return opDiscpription;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "accountType='" + accountType + '\'' +
                ", accountNumb='" + accountNumb + '\'' +
                ", currency='" + currency + '\'' +
                ", operationDate='" + operationDate + '\'' +
                ", refProvod='" + refProvod + '\'' +
                ", opDiscpription='" + opDiscpription + '\'' +
                ", prihod='" + prihod + '\'' +
                ", rashod='" + rashod + '\'' +
                '}';
    }
}
