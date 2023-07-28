package src.Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main1108 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        // https://www.acmicpc.net/problem/1033 백준 칵테일
        int n = Integer.parseInt(rd.readLine());
        calRatio[] arr = new calRatio[n];
        for (int i = 0; i < n - 1; i++) {
            tok = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            long aPer = Integer.parseInt(tok.nextToken());
            long bPer = Integer.parseInt(tok.nextToken());

            calRatio aRatio = new calRatio();
            calRatio bRatio = new calRatio();
            aRatio.setRoot(aPer);
            aRatio.setCal(bRatio);
            bRatio.setRoot(bPer);
            bRatio.setCal(aRatio);

            if (arr[a] == null) arr[a] = aRatio;
            else {
                long lcm = lcm(arr[a].root, aRatio.root);
                aRatio.cycle = true;
                calRatio cRatio = aRatio.cal;
                while (!cRatio.cycle) {
                    cRatio.setRoot(cRatio.root * (lcm / aRatio.root));
                    if (cRatio.cal.cycle) {
                        cRatio.cal = arr[a];
                        break;
                    }
                    cRatio = cRatio.cal;
                }
                aRatio.cycle = false;
                aRatio.root = lcm;


                arr[a].cycle = true;
                cRatio = arr[a].cal;
                while (!cRatio.cycle) {
                    cRatio.setRoot(cRatio.root * (lcm / arr[a].root));
                    if (cRatio.cal.cycle) {
                        cRatio.cal = aRatio.cal;
                        break;
                    }
                    cRatio = cRatio.cal;
                }
                arr[a].cycle = false;
                arr[a].root = lcm;
            }
//            wr.write("A :: " + Arrays.toString(arr));
//            wr.newLine();
            if (arr[b] == null) arr[b] = bRatio;
            else {
                long lcm = lcm(arr[b].root, bRatio.root);
                bRatio.cycle = true;
                calRatio cRatio = bRatio.cal;
                while (!cRatio.cycle) {
                    cRatio.setRoot(cRatio.root * (lcm / bRatio.root));
                    if (cRatio.cal.cycle) {
                        cRatio.cal = arr[b];
                        break;
                    }
                    cRatio = cRatio.cal;
                }
                bRatio.cycle = false;
                bRatio.root = lcm;

                arr[b].cycle = true;
                cRatio = arr[b].cal;
                while (!cRatio.cycle) {
                    cRatio.setRoot(cRatio.root * (lcm / arr[b].root));
                    if (cRatio.cal.cycle) {
                        cRatio.cal = bRatio.cal;
                        break;
                    }
                    cRatio = cRatio.cal;
                }
                arr[b].cycle = false;
                arr[b].setRoot(lcm);
            }
//            wr.write("B :: " + Arrays.toString(arr));
//            wr.newLine();
//            wr.flush();
        }

        long gcd = gcdN(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i].root /= gcd;
        }
        for (calRatio c : arr) {
            wr.write(c.root + " ");
        }
        wr.newLine();
        wr.flush();
    }

    static class calRatio {
        long root;
        calRatio cal;
        boolean cycle;

        calRatio() {
        }

        public void setRoot(long root) {
            this.root = root;
        }

        public void setCal(calRatio cal) {
            this.cal = cal;
        }

        public void setCycle(boolean cycle) {
            this.cycle = cycle;
        }

        @Override
        public String toString() {
            return this.root + "";
        }
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
    public static long gcdN(calRatio[] arr) {
        long result = arr[0].root;
        for (int i = 1; i < arr.length; i++) {
            result = gcd(arr[i].root, result);
            if (result == 1) return 1;
        }
        return result;
    }

    // n개의 최소공배수
    public static long lcmN(calRatio[] arr) {
        long result = 1;
        for (calRatio i : arr) {
            result *= i.root;
        }
        return result / gcdN(arr);
    }
}
