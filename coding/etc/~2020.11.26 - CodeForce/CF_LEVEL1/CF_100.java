package CodeForce.CF_LEVEL1;

import java.io.*;
import java.util.*;

// 코드 포스 100번 https://codeforces.com/problemsets/acmsguru/problem/99999/100

public class CF_100 {

    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        StringTokenizer tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        System.out.println(n+m);
    }
}
