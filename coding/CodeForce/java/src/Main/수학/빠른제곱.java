package src.Main.수학;

public class 빠른제곱 {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(Fast_power(2, i));
        }
    }

    public static long Fast_power(int a, int b) {
        long res = 1;
        while (b != 0) {
            if (b % 2 != 0) {
                res *= a;
            }
            a *= a;
            b /= 2;
        }
        return res;
    }
}
