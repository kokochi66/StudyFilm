package src.Main.수학;

public class 최소공배수_최대공약수 {
    public static void main(String[] args) {
        long[] arr = {360, 120, 378, 504};
        System.out.println(gcd(3, 5));
        System.out.println(lcm(3, 5));
        System.out.println(gcdN(arr));
        System.out.println(lcmN(arr));
    }

    // 최대 공약수
    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소 공배수
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // n개의 최대공약수 = 유클리드 호제법
    public static long gcdN(long[] arr) {
        long result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(arr[i], result);
            if (result == 1) return 1;
        }
        return result;
    }

    // n개의 최소공배수
    public static long lcmN(long[] arr) {
        long result = 1;
        for (long i : arr) {
            result *= i;
        }
        return result / gcdN(arr);
    }
}
