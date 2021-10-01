public class Main {
    public static void main(String[] args) {

        Aircraft aircraft = new Aircraft("Boeing747", "jetliner");

        System.out.println(aircraft.getModel());
        aircraft.setModel("Airbus");
        System.out.println(aircraft.getModel());
        aircraft.setSpeed(700);
        System.out.println(aircraft.getSpeed());
    }
}
