public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("ASUS", "TRB434");
        computer.setProcessor(4000, 4, "Intel", 500);
        computer.setKeyboard("Механическая", false, 1500);
        computer.setDisplay(29, "IPS", 5000);
        computer.setMemory("DDR3", 16, 100);
        computer.setStorage("SSD", 500, 300);
        System.out.println(computer.getComputerWeight());
        System.out.println(computer.toString());
    }
}

