package src.Main.수학;

public class 에라토스테네스의체 {
    public static void main(String[] args) {
        에라토스테네스의체(10000);
    }

    public static boolean 소수구하기(int n) {
        // 제곱근까지만 확인하면 약수의 대칭관계로 인해서 소수인지 확인할 수 있다.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void 에라토스테네스의체(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = i;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue;
            for (int j = i * 2; j < n; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + "  ");
            }
        }
    }
}
