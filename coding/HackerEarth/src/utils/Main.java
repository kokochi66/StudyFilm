package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer pp = Integer.parseInt(br.readLine());
//        System.out.println(pp);

        for (int i=0;i<pp;i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
//            System.out.println(x +" " + y);
        }
    }
}
