import java.util.SplittableRandom;

public class Printer {
    private String queue = "";
    private int pendingPageQuantity = 0;
    private int printedPages = 0;

    public void append(String text){append(text, "");
    }
    public void append(String text, String name) {
        queue = queue + "\n" + name + "\n" + text;
    }
    public void append(String text, String name, int pageQuantity){append(text, name);
        queue = queue + "\n" + pageQuantity + "\n";
        pendingPageQuantity = pendingPageQuantity + pageQuantity;
    }
    public void clear(){
        queue = "";
    }
    public void print() {
        System.out.println(queue);
        clear();
        printedPages = printedPages + pendingPageQuantity;
        pendingPageQuantity = 0;
    }
    public int getPendingPagesCount() {
        System.out.print("Кол-во страниц на печать: ");
        System.out.println(pendingPageQuantity);
        return pendingPageQuantity;
    }
    public int getPrintedPages() {
        System.out.print("Общее кол-во напечатанных страниц: ");
        System.out.println(printedPages);
        return printedPages;
    }





}
