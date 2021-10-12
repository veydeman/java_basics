public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(1, 2, 3);
        Delivery delivery = new Delivery(dimensions, 10, "kkk", true, "34hjh",
                false);
        System.out.println("Length: " + delivery.getLength());
        System.out.println("Width: " + delivery.getWidth());
        System.out.println("Height: " + delivery.getHeight());
        System.out.println("Volume: " + delivery.getVolume());
        System.out.println("Weight: " + delivery.getWeight());
        System.out.println("Address: " + delivery.getAddress() + "\n");

        Delivery delivery1 = delivery.setDimensions(3, 4, 5);
        System.out.println("Length: " + delivery1.getLength());
        System.out.println("Width: " + delivery1.getWidth());
        System.out.println("Height: " + delivery1.getHeight());
        System.out.println("Volume: " + delivery1.getVolume());
        System.out.println("Weight: " + delivery1.getWeight());
        System.out.println("Address: " + delivery1.getAddress() + "\n");

        Delivery delivery2 = delivery.setAddress("Hjkjhkh");
        System.out.println("Length: " + delivery2.getLength());
        System.out.println("Width: " + delivery2.getWidth());
        System.out.println("Height: " + delivery2.getHeight());
        System.out.println("Volume: " + delivery2.getVolume());
        System.out.println("Weight: " + delivery2.getWeight());
        System.out.println("Address: " + delivery2.getAddress() + "\n");

        Delivery delivery3 = delivery1.setWeight(30);
        System.out.println("Length: " + delivery3.getLength());
        System.out.println("Width: " + delivery3.getWidth());
        System.out.println("Height: " + delivery3.getHeight());
        System.out.println("Volume: " + delivery3.getVolume());
        System.out.println("Weight: " + delivery3.getWeight());
        System.out.println("Address: " + delivery3.getAddress() + "\n");
    }
}
