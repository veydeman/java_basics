public class TwoDimensionalArray {
    public static char symbol = 'X';
    public static char space = ' ';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = space;
                if (i == j || j == (array.length - i)-1)
                    array[i][j] = symbol;
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return array;
    }
}
