public class Manager extends Employee {

    public Manager() {
        super();
        moneyGot = (Math.random()*((250_000-50_000)+1))+250_000;
        salary = super.salary + ((moneyGot * 5) / 100);
    }
}