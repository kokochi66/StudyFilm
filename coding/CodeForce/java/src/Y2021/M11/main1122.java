package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class main1122 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        int TT = Integer.parseInt(rd.readLine());
        for (int TS = 0; TS < TT; TS++) {
            tok = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            int[] arr = new int[n];

            HashSet<Integer> setA = new HashSet<>();
            HashSet<Integer> setB = new HashSet<>();
            HashSet<Integer> setC = new HashSet<>();
            int conCnt = 0;
            int ncCnt = 0;

            for (int i = a; i <= n; i++) {
                setA.add(i);
            }
            for (int i = 1; i <= b; i++) {
                setB.add(i);
                if (setA.contains(i)) conCnt++;
                else ncCnt++;
            }
            ncCnt += (setA.size() - conCnt);

            int aMns = setA.contains(b) ? 1 : 0;
            int bMns = setB.contains(a) ? 1 : 0;

            boolean pass = false;
            if (setA.size() - aMns >= (n / 2) && (setB.size() - bMns >= (n / 2))) {

                if (conCnt + ncCnt - (n / 2) >= (n / 2)) {
                    pass = true;
                    arr[0] = a;
                    arr[n / 2] = b;
                    setC.add(a);
                    setC.add(b);
                    int curr = n;
                    if (curr == b) curr--;
                    for (int i = 1; i < n; i++) {
                        if (i == (n / 2)) {
                            curr = 1;
                            if (setC.contains(curr)) curr++;
                            continue;
                        }
                        arr[i] = curr;
//                        wr.write(arr[i]+" ");
                        setC.add(curr);

                        if (i == (n / 2) - 1) {
                            curr = 1;
                            if (setC.contains(curr)) curr++;
                        } else if (i > (n / 2) - 1) {
                            while (setC.contains(curr)) curr++;
                        } else {
                            while (setC.contains(curr)) curr--;
                        }

                    }
//                    wr.write("] :: " + TS);
//                    wr.newLine();
                }
            }
            if (!pass) wr.write((-1) + "");
            else {
                for (int i = 0; i < n; i++) {
                    wr.write(arr[i] + " ");
                }
            }

/*


            wr.write("] :: "+ TS);
            wr.newLine();
            if(check) {
                wr.write((-1)+"");
            } else {
                for(int i=0;i<n;i++) {
                    wr.write(arr[i]+" ");
                }
            }*/


/*            if(a <= (n/2)+1 && b >= (n/2) && !((a<=b) && b == (n/2)) && !((a>=b) && a == ((n/2)+1))) {

            } else {
                wr.write((-1)+"");
            }*/
            wr.newLine();
        }
        wr.flush();
    }

    public static void solution2() throws Exception {
        int TT = Integer.parseInt(rd.readLine());
        for (int TS = 0; TS < TT; TS++) {
            tok = new StringTokenizer(rd.readLine());

            int n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());
            if ((n % 2 == 0 && m % 2 == 0) || (n % 2 == 1 && m % 2 == 1)) {
                int left = 0, right = 0;
                if (n > m) {
                    left = (n + m) / 2;
                    right = 0;

                } else {
                    left = 0;
                    right = (n + m) / 2;
                }
                wr.write(left + " " + right);
            } else {
                wr.write((-1) + " " + (-1));
            }
            wr.newLine();
        }
        wr.flush();
    }
}
