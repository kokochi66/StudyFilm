package src.Main.수학;

public class 진법변환 {

    public static void main(String[] args) {
        System.out.println(parse16(78));
//        System.out.println((char)('A'+3));
    }


    public static StringBuilder parse(long n) {
        long oper = 1;
        long ver = 2;
        StringBuilder res = new StringBuilder("");
        while (n > 0) {
            res.append((n % ver));
            n /= ver;
        }
        return res.reverse();
    }   // 2진법 변환

    public static StringBuilder parse16(long n) {
        long ver = 16;
        StringBuilder res = new StringBuilder("");
        while (n > 0) {
            int op = (int) (n % ver);
            if (n % ver < 10) res.append(op);
            else res.append((char) ('A' + (op - 10)));
            n /= ver;
        }
        return res.reverse();
    }   // 2진법 변환
}
