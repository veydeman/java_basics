public class Arithmetic {
    private int a = 0;
    private int b = 0;

    public Arithmetic(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int prod() {
        return a * b;
    }

    public int max() {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int min() {
        if (a < b) {
          return a;
        }
        return b;
    }
}
