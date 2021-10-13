public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Корзина");

        System.out.println(Basket.getAllItemsCount());
        System.out.println(Basket.getAllItemsPrice() + "\n");

        basket.add("Хлеб", 20, 3);
        basket.add("Пиво", 300, 3, 0.5);

        System.out.println(Basket.getAllItemsCount());
        System.out.println(Basket.getAllItemsPrice() + "\n");

        Basket basket1 = new Basket();

        basket1.add("Водка", 100, 3, 1.0);

        Basket basket2 = new Basket();

        basket2.add("Сметана", 50, 3);
        basket2.add("Пельмени", 200, 2);

        System.out.println(Basket.getAllItemsCount());
        System.out.println(Basket.getAllItemsPrice() + "\n");

        System.out.println(Basket.averageBasketPrice());
        System.out.println(Basket.averageItemPrice());
    }
}
