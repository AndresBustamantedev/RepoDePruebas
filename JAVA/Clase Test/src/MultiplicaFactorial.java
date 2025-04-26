package src;
public class MultiplicaFactorial {


    public int multiplica(int a, int b) {
        return a * b;
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

