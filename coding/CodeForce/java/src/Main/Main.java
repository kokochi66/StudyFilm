package src.Main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
//        solution();
//        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
//        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
//        System.out.println(Arrays.toString(solution(new String[]{"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"}, new int[]{2,3,4})));
/*        ArrayList<String> res = new ArrayList<>();
        String input = "ABCFG";
        char[] arr = input.toCharArray();
        boolean[] check = new boolean[arr.length];
        int n = 3;
        char[] s = new char[n];
        btk(res,s,arr,check,n,0, 0);
        for (String re : res) {
            System.out.println(re);
        }*/
//        String[][] input = {
//                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//        };
//        System.out.println(Arrays.toString(solution(input)));
//        System.out.println(Arrays.toString(solution(new String[]{"SL","LR"})));
        System.out.println(Arrays.toString(solution(new String[]{"R","R"})));


    }

    public static int[] solution(String[] grid) {
        // S 정지, L 왼쪽, R 오른쪽
        int n = grid.length;
        int m = grid[0].length();
        Direct[][] ga = new Direct[n][m];
        int[][] s = {{1,0,0}, {0,-1,1}, {0,1,2},{-1,0,3}};
        int[][] l = {{0,1,2},{1,0,0},{1,0,3},{0,-1,1}};
        int[][] r = {{0,-1,1},{-1,0,3},{1,0,0},{0,1,2}};

        for(int i=0;i<n;i++) {
            for(int j=0;j<grid[i].length();j++) {
                ga[i][j] = new Direct(grid[i].charAt(j));
            }
        }

        // 0 - 위, 1- 오른쪽, 2- 왼쪽, 3- 아래

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<4;k++) {
                    Queue<Integer[]> q = new LinkedList<>();
                    boolean[][][] check = new boolean[n][m][4];
                    check[i][j][k] = true;
                    if(ga[i][j].c == 'S') {
                        int dir = s[k][2];
                        if(i + s[k][0] < 0 || i + s[k][0] > n-1 || j + s[k][1] < 0 || j + s[k][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                        q.add(new Integer[]{i + s[k][0] < 0 ? n-1 : (i + s[k][0])%n , j + s[k][1] < 0 ? m-1 : (j + s[k][1])%m  , s[k][2], 1});
                    } else if(ga[i][j].c == 'L') {
                        int dir = l[k][2];
                        if(i + l[k][0] < 0 || i + l[k][0] > n-1 || j + l[k][1] < 0 || j + l[k][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                        q.add(new Integer[]{i + l[k][0] < 0 ? n-1 : (i + l[k][0])%n , j + l[k][1] < 0 ? m-1 : (j + l[k][1])%m , l[k][2], 1});
                    } else if(ga[i][j].c == 'R') {
                        int dir = r[k][2];
                        if(i + r[k][0] < 0 || i + r[k][0] > n-1 || j + r[k][1] < 0 || j + r[k][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                        q.add(new Integer[]{i + r[k][0] < 0 ? n-1 : (i + r[k][0])%n , j + r[k][1] < 0 ? m-1 : (j + r[k][1])%m , r[k][2], 1});
                    }
                    while(!q.isEmpty()){
                        Integer[] ca = q.poll();
                        int x = ca[0];
                        int y = ca[1];
                        int z = ca[2];
                        int dist = ca[3];
                        if(x == i && y == j && k == z) {
                            ga[x][y].cycle[z] = dist;
                            break;
                        }
                        if(ga[x][y].cycle[z] > 0) break;
                        if(check[x][y][z]) continue;

                        check[x][y][z] = true;

                        if(ga[x][y].c == 'S') {
                            int dir = s[z][2];
                            if(x + s[z][0] < 0 || x + s[z][0] > n-1 || y + s[z][1] < 0 || y + s[z][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                            q.add(new Integer[]{x + s[z][0] < 0 ? n-1 : (x + s[z][0])%n , y + s[z][1] < 0 ? m-1 : (y + s[z][1])%m , s[z][2], dist + 1});
                        } else if(ga[x][y].c == 'L') {
                            int dir = l[z][2];
                            if(x + l[z][0] < 0 || x + l[z][0] > n-1 || y + l[z][1] < 0 || y + l[z][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                            q.add(new Integer[]{x + l[z][0] < 0 ? n-1 : (x + l[z][0])%n , y + l[z][1] < 0 ? m-1 : (y + l[z][1])%m , l[z][2], dist + 1});
                        } else if(ga[x][y].c == 'R') {
                            int dir = r[z][2];
                            if(x + r[z][0] < 0 || x + r[z][0] > n-1 || y + r[z][1] < 0 || y + r[z][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                            q.add(new Integer[]{x + r[z][0] < 0 ? n-1 : (x + r[z][0])%n , y + r[z][1] < 0 ? m-1 : (y + r[z][1])%m , r[z][2], dist + 1});
                        }
                    }
                }
            }
        }

        ArrayList<Integer> cycleList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<4;k++) {
                    if(ga[i][j].cycle[k] > 0) {
                        cycleList.add(ga[i][j].cycle[k]);
                    }
                }
            }
        }

        int[] answer = new int[cycleList.size()];
        for(int i=0;i<cycleList.size();i++) answer[i] = cycleList.get(i);
        return answer;
    }

    static class Direct {
        char c;
        Integer[][] p;
        boolean[] k;
        int[] cycle;

        public Direct(char c) {
            this.c = c;
            this.p = new Integer[4][2];
            this.k = new boolean[4];
            this.cycle = new int[4];
        }

        @Override
        public String toString() {
            return "Direct{" +
                    "c=" + c +
                    ", cycle=" + Arrays.toString(cycle) +
                    ", k=" + Arrays.toString(k) +
                    '}';
        }
    }

    public static int[] solution4(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<places.length;i++) {
            answer[i] = 1;
            char[][] classroom = new char[5][5];
            ArrayList<Integer[]> pShit = new ArrayList<>();
            for(int j=0;j<places[0].length;j++) {
                classroom[j] = places[i][j].toCharArray();
                for(int k=0;k<classroom[j].length;k++) {
                    if(classroom[j][k] == 'P') pShit.add(new Integer[]{j,k});
                }
            }
//            for(int j=0;j< classroom.length;j++) System.out.println(Arrays.toString(classroom[j]));

            for (Integer[] ic : pShit) {
                Queue<Integer[]> q = new LinkedList<>();
                boolean[][] check = new boolean[5][5];
                check[ic[0]][ic[1]] = true;
                if(ic[0]+1 < 5) q.add(new Integer[]{ic[0]+1, ic[1], 1});
                if(ic[1]+1 < 5) q.add(new Integer[]{ic[0], ic[1]+1, 1});
                if(ic[0]-1 >= 0) q.add(new Integer[]{ic[0]-1, ic[1], 1});
                if(ic[1]-1 >= 0) q.add(new Integer[]{ic[0], ic[1]-1, 1});

                while(!q.isEmpty()) {
                    Integer[] p = q.poll();
                    int px = p[0];
                    int py = p[1];
                    int dist = p[2];
                    if(check[px][py] || classroom[px][py] == 'X') continue;
                    check[px][py] = true;
                    if (classroom[px][py] == 'P' && dist <= 2) {
//                        System.out.println("TEST :: " + px +" " + py+ " " + dist +" ic1=" + ic[0] +" ic2="+ic[1]);
                        answer[i] = 0;
                        break;
                    }
                    if(px+1 < 5) q.add(new Integer[]{px+1, py, dist+1});
                    if(py+1 < 5) q.add(new Integer[]{px, py+1, dist+1});
                    if(px-1 >= 0) q.add(new Integer[]{px-1, py, dist+1});
                    if(py-1 >= 0) q.add(new Integer[]{px, py-1, dist+1});
                }
            }

        }
        return answer;
    }
    public static String[] solution3(String[] orders, int[] course) {

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();

        for(int i=0;i<course.length;i++) {
            for(int j=0;j< orders.length;j++) {
                ArrayList<String> sol = new ArrayList<>();
                char[] arr = orders[j].toCharArray();
                boolean[] check = new boolean[arr.length];
                int n = course[i];
                char[] s = new char[n];
                btk(sol,s,arr,check,n,0,0);
                for (String s1 : sol) {
                    if(map.containsKey(s1)) {
                        map.replace(s1, map.get(s1)+1);
                    } else {
                        map.put(s1, 1);
                        res.add(s1);
                    }
                }
            }
        }
        int[] courseMax = new int[course.length];
        Collections.sort(res,(a,b) -> {
            return map.get(b) - map.get(a);
        });

        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<res.size();i++) {
            for(int j=0;j< course.length;j++) {
                String s = res.get(i);
                if(s.length() == course[j] && courseMax[j] <= map.get(s) && s.length() >= 2 && map.get(s) >= 2) {
//                    System.out.println("TEST :: " + s +" " + map.get(s));
                    courseMax[j] = map.get(s);
                    ans.add(s);
                }
            }
        }

        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++) {
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void btk(ArrayList<String> res, char[] s, char[] arr, boolean[] check, int n, int c, int ci) {
        if(c >= n) {
            char[] temp = new char[s.length];
            for(int i=0;i<s.length;i++) temp[i] = s[i];
            Arrays.sort(temp);
            res.add(String.valueOf(temp));
            return;
        } else {
            for(int i=ci;i<arr.length;i++) {
                if(!check[i]) {
                    s[c] = arr[i];
                    check[i] = true;
                    btk(res,s,arr,check,n,c+1, i+1);
                    check[i] = false;
                }
            }
        }
    }

}
