package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1108 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        // S[i] 로 시작해서 T[i]로 끝나는 N개의 수업을 최소 강의실을 사용해서 모든 수업을 가능하게 함
        // 수업이 끝난 직후 다음 수업을 바로 수업을 시작할 수 있음 (T[i] <= S[j] 일경우 i수업과 j수업을 같이 들을 수 있음)

        int n = Integer.parseInt(rd.readLine());
        int[] s = new int[n];
        int[] t = new int[n];
        Map<Integer, Integer[]> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            tok = new StringTokenizer(rd.readLine());
            s[i] = Integer.parseInt(tok.nextToken());
            t[i] = Integer.parseInt(tok.nextToken());
            map.put(i, new Integer[]{s[i], t[i]});
        }

//        System.out.println("n = " + n);
//        System.out.println("s = " + Arrays.toString(s));
//        System.out.println("t = " + Arrays.toString(t));

        // n <= 20만 이므로 n^2 불가능
        // s[i], t[i] <= 1억임 (더할필요가 없으니 int로 해도 됨)

        // 1. 남은 것중에서 가장 시작시작이 빠른 강의를 가져온다. (Fst)
        // 2. Lst의 가장 첫 강의의 끝나는 시간보다 시작시간이 빠르다면 강의실을 +1 하고 Lst에 add 한다.
        // 3. 시간이 느리다면, Lst를 하나 꺼내고, Lst에 add 한다.
        // 4. Fst에 더이상 남은게 없을때까지 반복
        PriorityQueue<LessonFirst> pqFst = new PriorityQueue();
        PriorityQueue<LessonSecond> pqLst = new PriorityQueue();

        for(int i=0;i<n;i++) {
            pqFst.add(new LessonFirst(s[i], t[i]));
        }

        int roomCnt = 0;
        while(!pqFst.isEmpty()) {
            LessonFirst lesson = pqFst.poll();
//            System.out.println("lesson = " +lesson.start + " " + lesson.end);
            if (!pqLst.isEmpty()) {
                LessonSecond lessonSec = pqLst.peek();
//                System.out.println("lessonSec = " +lessonSec.start + " " + lessonSec.end);
                if (lessonSec.end > lesson.start) {
                    roomCnt++;
                } else {
                    pqLst.poll();
                }
                pqLst.add(new LessonSecond(lesson.start, lesson.end));

            } else {
                roomCnt++;
                pqLst.add(new LessonSecond(lesson.start, lesson.end));
            }
        }
        System.out.println(roomCnt);
    }


    static class LessonFirst implements Comparable<LessonFirst> {
        int start;
        int end;

        public LessonFirst(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(LessonFirst o) {
            return this.start - o.start;
        }
    }

    static class LessonSecond implements Comparable<LessonSecond> {
        int start;
        int end;

        public LessonSecond(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(LessonSecond o) {
            return this.end - o.end;
        }
    }

}
