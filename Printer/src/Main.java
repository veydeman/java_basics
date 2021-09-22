public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.append("она макака по знаку зодиака", "ленинград", 4);
        System.out.println("Документ 1");
        printer.getPendingPagesCount();
        printer.print();
        printer.append("osdkfoskdfpoksf", "dskgsodkgfposdk", 5);
        System.out.println("Документ 2");
        printer.getPendingPagesCount();
        printer.print();
        printer.getPrintedPages();
    }
}
