package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class main1119_2 {
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
        String sen1 = "HaEaLaLaObWORLDb";
        String sen2 = "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGjRvRvRvRvRvR";
        String sen3 = "AxAxAxAoBoBoB";
        String sen4 = "bBbBbBbBbBbBbaAcAcAcAcAcAcAa";
        System.out.println(solution(sen4));
//        System.out.println(sen1.substring(0,9).replace('a','\u0000'));
    }

    public static String solution(String sentence) {
        char[] sen = sentence.toCharArray();
        int n = sen.length;

        // 1) 문자열 읽어와서 저장
        HashMap<Character, Spe> hm = new HashMap<>();
        ArrayList<Spe> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(sen[i])) {
                if (!hm.containsKey(sen[i])) {
                    Spe spe = new Spe(sen[i]);
                    spe.pos.add(i);
                    hm.put(sen[i], spe);
                    list.add(spe);
                } else {
                    Spe spe = hm.get(sen[i]);
                    spe.pos.add(i);
                }
            }
        }

        // 2) 패턴 판단하기
        int m = list.size();
        Spe prev = null;    // 이전 단어 체크
        for (int i = 0; i < m; i++) {
            Spe sp = list.get(i);
            int left = sp.pos.get(0);
            int right = sp.pos.get(sp.pos.size() - 1);
            boolean mind = false;   // 포함관계 체크
            if (sp.pos.size() == 1 || sp.pos.size() >= 3) {
                // 1이거나 3 이상이면 1 패턴이다.
                sp.pattern = 1;
                for (int j = 1; j < sp.pos.size(); j++) {
                    // 1패턴이면 모든값의 거리가 2가 아니면 invalid
                    if (sp.pos.get(j) - sp.pos.get(j - 1) != 2) return "invalid";
                }
                if (prev != null) {
                    // 이전 단어가 걸쳐있으면 invalid
                    // 포함인데 2패턴이 아니면 invalid
                    // 거리가 2차이 안나면 invalid
                    int prevLeft = prev.pos.get(0);
                    int prevRight = prev.pos.get(prev.pos.size() - 1);
                    if (prevRight < right && prevRight > left) return "invalid";        // 걸쳐있으면 invalid
                    if (prevRight > right) {
                        // 포함인 경우
                        if (prev.pattern != 2) return "invalid";     // 포함인데 패턴 2가 아니면 invalid
                        if (left - prevLeft != 2 || prevRight - right != 2)
                            return "invalid";        // 거리가 2차이 안나면 invalid;
                        mind = true;
                    } else if (prev.pattern == 1 && left - prevRight < 3) return "invalid";
                    // 포함이 아닌데, 1패턴이고 거리차이가 3이상 안나면 invalid
                }
            } else {
                // 2이면 조건체크가 추가로 들어간다.
                if (prev != null) {
                    int prevLeft = prev.pos.get(0);
                    int prevRight = prev.pos.get(prev.pos.size() - 1);
                    // 이전 단어가 걸쳐있으면 invalid
                    // 포함인데 2패턴이 아니면 invalid
                    // 거리가 2차이 안나면 invalid
                    if (prevRight < right && prevRight > left) return "invalid";        // 걸쳐있으면 invalid
                    if (prevRight > right) {
                        // 포함인 경우 패턴 1로 적용
                        sp.pattern = 1;
                        if (prev.pattern != 2) return "invalid";     // 포함인데 패턴 2가 아니면 invalid
                        if (left - prevLeft != 2 || prevRight - right != 2)
                            return "invalid";        // 거리가 2차이 안나면 invalid;
                        mind = true;
                    } else {
                        // 포함도 아니고 걸쳐있지도 않으면 패턴 2로 적용
                        sp.pattern = 2;
                        if (right - left < 2) return "invalid";
                        // 거리가 2 이상인지 확인
                    }
                } else {
                    // 이전 값이 없었으면 패턴 2임
                    sp.pattern = 2;
                    if (right - left < 2) return "invalid";
                    // 거리가 2 이상인지 확인
                }
            }
            prev = sp;
        }

        for (int i = 0; i < m; i++) {
            Spe sp = list.get(i);
            System.out.println("TEST :: sp :: " + sp);
        }
        return "";
    }

    static class Spe {
        List<Integer> pos = new ArrayList<>();
        char sp;
        int pattern;

        public Spe(char s) {
            this.sp = s;
        }

        @Override
        public String toString() {
            return "Spe{" +
                    ", sp=" + sp +
                    ", pattern=" + pattern +
                    '}';
        }
    }
}
