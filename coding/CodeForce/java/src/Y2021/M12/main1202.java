package src.Y2021.M12;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main1202 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        // 양의 정수 A,B
        // A < B
        // A <= x <= B를 만족하는 x가 집합 S에 속하지 않음
        // ㄷ
        int TT = Integer.parseInt(rd.readLine());
        for(int TS=0;TS<TT;TS++) {
            tok = new StringTokenizer(rd.readLine());

        }
    }

    public static void solution3() throws Exception {
        tok = new StringTokenizer(rd.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++) {
            String str = rd.readLine();
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(Character.toString((str.charAt(j))));
            }
        }
//        for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));

        long max = -1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for (int l = 1-n; l < n; l++) {
                    for (int r = 1-m; r < m; r++) {
                        int x = i;
                        int y = j;
                        StringBuilder res = new StringBuilder("");
                        while (x < n && x >= 0 && y >= 0 && y < m) {
                            res.append(arr[x][y]);
                            x += l;
                            y += r;
                            long a = Long.parseLong(res.toString());
                            if (max < a && isPow(a)) max = a;
                            long b = Long.parseLong(new StringBuilder(res).reverse().toString());
                            if (max < b && isPow(b)) max = b;
                            if (l == 0 & r == 0) break;
                        }

                    }
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isPow(long a) {
        for(int i=0;i<=Math.sqrt(a);i++) {
            if(i*i == a) {
                return true;
            }
        }
        return false;
    }

    public static void solution2() throws Exception {
        int TT = Integer.parseInt(rd.readLine());
        for(int TS=0;TS<TT;TS++) {
            StringBuilder s = new StringBuilder(rd.readLine());
            int idx = 0;
            boolean check = false;

            while(idx < s.length()) {
//                System.out.println("TEST :: " + idx + "  "+s.charAt(idx));
                if(s.charAt(idx) == '1') {
                    // 패턴 1
                    idx++;
                    if(idx >= s.length() || s.charAt(idx) == '1') {
                        check=true;
                        break;
                    }    // 0 체크
                    idx++;
                    if(idx >= s.length() || s.charAt(idx) == '1') {
                        check=true;
                        break;
                    }    // 0 체크
                    while(idx < s.length() && s.charAt(idx) == '0') idx++;     // 연속된 0 체크
                    if(idx >= s.length()) {
                        check=true;
                        break;
                    }    // 범위체크
                    int idxC = idx;
                    while(idx < s.length() && s.charAt(idx) == '1') idx++;     // 연속된 1 체크
                    if(idx - idxC > 1 && idx + 1 < s.length() && s.charAt(idx+1) == '0') idx--;

                } else {
                    // 패턴 2
                    idx++;
                    if(idx >= s.length() || s.charAt(idx) == '0') {
                        check=true;
                        break;
                    }    // 1 체크
                    idx++;
                }

            }
            if(check) wr.write("NO");
            else wr.write("YES");
            wr.newLine();
        }
        wr.flush();
    }
}
