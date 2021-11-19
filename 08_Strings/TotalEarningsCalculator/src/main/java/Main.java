public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        String substr = text.substring(15, 19);
        String substr1 = text.substring(35, 39);
        String substr2 = text.substring(56, 61);
        int a = Integer.parseInt(substr);
        int b = Integer.parseInt(substr1);
        int c = Integer.parseInt(substr2);
        int sum = a + b + c;
        System.out.println(sum);
    }
}


