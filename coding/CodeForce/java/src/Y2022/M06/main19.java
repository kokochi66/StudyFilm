package Y2022.M06;

public class main19 {

    public static int count = 0;

    public static int fibo(int n) {
        System.out.println("count = " + ++count);
        if (n <= 1) return n;
        else {
            return fibo(n - 2) + fibo(n - 1);
        }
    }

    // 1 1 2 3 5 8 13 21 34

    // 4
    // 2 3
    // 0 1
    // 1 2
    // 0 1


    public static void main(String[] args) {
        System.out.println(fibo(4));
    }
}
