public class Computer {

    private CPU processor;
    private RAM memory;
    private Storage storage;
    private Display display;
    private Keyboard keyboard;
    private final String vendor;
    private final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public int getComputerWeight() {
        return processor.getWeight() + memory.getWeight() + storage.getWeight() +
                display.getWeight() + keyboard.getWeight();
    }

    public void setProcessor(int frequency, int coreNumber, String maker, int weight) {
        this.processor = new CPU(frequency, coreNumber, maker, weight);
    }

    public void setMemory(String type, int size, int weight) {
        this.memory = new RAM(type, size, weight);
    }

    public void setStorage(String type, int size, int weight) {
        this.storage = new Storage(type, size, weight);
    }

    public void setDisplay(int screenSize, String type, int weight) {
        this.display = new Display(screenSize, type, weight);
    }

    public void setKeyboard(String type, boolean rgbLight, int weight) {
        this.keyboard = new Keyboard(type, rgbLight, weight);
    }

    public CPU getProcessor() {
        return processor;
    }

    public RAM getMemory() {
        return memory;
    }

    public Storage getStorage() {
        return storage;
    }

    public Display getDisplay() {
        return display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String toString() {
        return "Компьютер:" + "\n" +
                " Процессор: Производитель - " + getProcessor().getMaker() +
                " | Число ядер - " + getProcessor().getCoreNumber() +
                " | Частота - " + getProcessor().getFrequency() + " МГц" +
                " | Вес - " + getProcessor().getWeight() + " г" + "\n" +
                " Память: Тип - " + getMemory().getType() +
                "  | Размер - " + getMemory().getSize() + " гб" +
                "  | Вес - " + getMemory().getWeight() + " г" + "\n" +
                " Жесткий диск: Тип - " + getStorage().getType() +
                "   | Размер - " + getStorage().getSize() + " гб" +
                "   | Вес - " + getStorage().getWeight() + " г" + "\n" +
                " Дисплей: Тип - " + getDisplay().getType() +
                "   | Размер экрана -  " + getDisplay().getScreenSize() + " дюймов" +
                " | Вес - " + getDisplay().getWeight() + " г" + "\n" +
                " Клавиатура: Тип - " + getKeyboard().getType() +
                " | Подсветка - " + getKeyboard().isRgbLight()
                + " | Вес - " + getKeyboard().getWeight() + " г" + "\n" +
                " Разработчик: " + vendor + "\n" +
                " Название: " + name + "\n" +
                " Общий вес: " + getComputerWeight() + " г";
    }
}
