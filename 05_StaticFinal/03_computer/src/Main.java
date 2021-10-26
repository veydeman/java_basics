public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(ComputerVendor.MSI, ComputerName.NBM500);
        computer.setProcessor(4000,4,CPUMaker.INTEL,400);
        computer.setKeyboard(KeyboardType.Mechanic,KeyboardRGBLight.YES,400);
        computer.setDisplay(29,DisplayType.IPS,4000);
        computer.setMemory(RAMType.DDR3, 16, 200);
        computer.setStorage(StorageType.SSD,500,500);
        System.out.println(computer.getComputerWeight());
        System.out.println(computer);
    }
}

