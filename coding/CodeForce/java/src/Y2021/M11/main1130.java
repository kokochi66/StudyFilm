package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1130 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
//        System.out.println(Arrays.toString(solution(new String[]{
//                "SLLRLLS",
//                "SLLRLLS",
//                "SLLRLLS",
//                "SLLRLLS",
//                "SLLRLLS"
//        })));
//        System.out.println(solution(new int[][]{
//                {1,0,1,1,1},
//                {1,0,1,0,1},
//                {1,0,1,1,1},
//                {1,1,1,0,1},
//                {0,0,0,0,1},
//        }));
        System.out.println(Arrays.toString(solution(new String[]{
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"
                },
                new String[]{
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"
                }
        )));
    }

    public static int[] solution(String[] info, String[] query) {
        StringTokenizer tok;
        int[][][][][] cntArr = new int[3][2][2][2][100002];
        for(int i=0;i<info.length;i++) {
            tok = new StringTokenizer(info[i]);
            String l = tok.nextToken();
            String j = tok.nextToken();
            String c = tok.nextToken();
            String f = tok.nextToken();
            String p = tok.nextToken();
            int lang = l.equals("java") ? 0 : l.equals("cpp") ? 1 : 2;
            int job = j.equals("backend") ? 0 : 1;
            int career = c.equals("junior") ? 0 : 1;
            int food = f.equals("chicken") ? 0 : 1;
            int point = Integer.parseInt(p);
            cntArr[lang][job][career][food][point]++;
        }
        for(int q=0;q<3;q++) {
            for(int w=0;w<2;w++) {
                for(int e=0;e<2;e++) {
                    for(int r=0;r<2;r++) {
                        for(int t=100000;t>=0;t--) {
                            cntArr[q][w][e][r][t] += cntArr[q][w][e][r][t+1];
                        }
                    }
                }
            }
        }
        int[] answer = new int[query.length];
        for(int i=0;i< query.length;i++) {
            tok = new StringTokenizer(query[i]);
            String lang = tok.nextToken();
            tok.nextToken();
            String job = tok.nextToken();
            tok.nextToken();
            String career = tok.nextToken();
            tok.nextToken();
            String food = tok.nextToken();
            String point = tok.nextToken();
            int l = lang.equals("java") ? 0 : lang.equals("cpp") ? 1 : lang.equals("python") ? 2 : -1;
            int j = job.equals("backend") ? 0 : job.equals("frontend") ? 1 : -1;
            int c = career.equals("junior") ? 0 : career.equals("senior") ? 1 : -1;
            int f = food.equals("chicken") ? 0 : food.equals("pizza") ? 1 : -1;
            int p = Integer.parseInt(point);
//            System.out.println(l+" "+j+" "+c+" "+f+" "+p);
            int cnt = 0;
            for(int q=0;q<3;q++) {
                for(int w=0;w<2;w++) {
                    for(int e=0;e<2;e++) {
                        for(int r=0;r<2;r++) {
                            if( (l == -1 || l == q) && (j == -1 || j == w) && (c == -1 || c == e) && (f == -1 || f == r) ) cnt += cntArr[q][w][e][r][p];
                        }
                    }
                }
            }
            answer[i] = cnt;
        }


        return answer;
    }

    public static int solution3(int[][] maps) {
        Queue<Integer[]> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] check = new boolean[n][m];
        q.add(new Integer[]{0,0,1});
        while(!q.isEmpty()) {
            Integer[] c = q.poll();
            int x = c[0];
            int y = c[1];
            int dist = c[2];
            if(check[x][y]) continue;
            if(x == n-1 && y == m-1) return dist;
            check[x][y] = true;
            if(x+1 < n && !check[x+1][y] && maps[x+1][y] == 1) q.add(new Integer[]{x+1,y,dist+1});
            if(y+1 < m && !check[x][y+1] && maps[x][y+1] == 1) q.add(new Integer[]{x,y+1,dist+1});
            if(x-1 >= 0 && !check[x-1][y] && maps[x-1][y] == 1) q.add(new Integer[]{x-1,y,dist+1});
            if(y-1 >= 0 && !check[x][y-1] && maps[x][y-1] == 1) q.add(new Integer[]{x,y-1,dist+1});
        }
        return -1;
    }


    public static int[] solution2(String[] grid) {
        // S 정지, L 왼쪽, R 오른쪽
        int n = grid.length;
        int m = grid[0].length();
        Direct[][] ga = new Direct[n][m];
        int[][] s = {{1,0,0}, {0,-1,1}, {0,1,2},{-1,0,3}};
        int[][] l = {{0,1,2},{1,0,0},{-1,0,3},{0,-1,1}};
        int[][] r = {{0,-1,1},{-1,0,3},{1,0,0},{0,1,2}};

        for(int i=0;i<n;i++) {
            for(int j=0;j<grid[i].length();j++) {
                ga[i][j] = new Direct(grid[i].charAt(j));
            }
        }

        // 0 - 위, 1- 오른쪽, 2- 왼쪽, 3- 아래
        boolean[][][] check = new boolean[n][m][4];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<4;k++) {
//                    System.out.println("ST :: "+i+" "+j+" "+k);
                    if(check[i][j][k]) continue;
                    Queue<Integer[]> q = new LinkedList<>();
                    if(ga[i][j].c == 'S') {
                        int dir = s[k][2];
//                        if(i + s[k][0] < 0 || i + s[k][0] > n-1 || j + s[k][1] < 0 || j + s[k][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                        q.add(new Integer[]{i + s[k][0] < 0 ? n-1 : (i + s[k][0])%n , j + s[k][1] < 0 ? m-1 : (j + s[k][1])%m  , dir, 1});
                    } else if(ga[i][j].c == 'L') {
                        int dir = l[k][2];
//                        if(i + l[k][0] < 0 || i + l[k][0] > n-1 || j + l[k][1] < 0 || j + l[k][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                        q.add(new Integer[]{i + l[k][0] < 0 ? n-1 : (i + l[k][0])%n , j + l[k][1] < 0 ? m-1 : (j + l[k][1])%m , dir, 1});
                    } else if(ga[i][j].c == 'R') {
                        int dir = r[k][2];
//                        if(i + r[k][0] < 0 || i + r[k][0] > n-1 || j + r[k][1] < 0 || j + r[k][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                        q.add(new Integer[]{i + r[k][0] < 0 ? n-1 : (i + r[k][0])%n , j + r[k][1] < 0 ? m-1 : (j + r[k][1])%m ,dir, 1});
                    }
                    while(!q.isEmpty()){
                        Integer[] ca = q.poll();
                        int x = ca[0];
                        int y = ca[1];
                        int z = ca[2];
                        int dist = ca[3];
//                        System.out.println(x+" "+y+" "+z+" "+dist);
                        if(check[x][y][z]) break;
                        check[x][y][z] = true;
                        if(x == i && y == j && k == z) {
                            ga[x][y].cycle[z] = dist;
                            break;
                        }
                        if(ga[x][y].cycle[z] > 0) break;

                        if(ga[x][y].c == 'S') {
                            int dir = s[z][2];
//                            if(x + s[z][0] < 0 || x + s[z][0] > n-1 || y + s[z][1] < 0 || y + s[z][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                            q.add(new Integer[]{x + s[z][0] < 0 ? n-1 : (x + s[z][0])%n , y + s[z][1] < 0 ? m-1 : (y + s[z][1])%m , dir, dist + 1});
                        } else if(ga[x][y].c == 'L') {
                            int dir = l[z][2];
//                            if(x + l[z][0] < 0 || x + l[z][0] > n-1 || y + l[z][1] < 0 || y + l[z][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                            q.add(new Integer[]{x + l[z][0] < 0 ? n-1 : (x + l[z][0])%n , y + l[z][1] < 0 ? m-1 : (y + l[z][1])%m , dir, dist + 1});
                        } else if(ga[x][y].c == 'R') {
                            int dir = r[z][2];
//                            System.out.println("TEST RR :: " + x+" "+ y+" " +z+" "+dir);
//                            if(x + r[z][0] < 0 || x + r[z][0] > n-1 || y + r[z][1] < 0 || y + r[z][1] > m-1) dir = dir==0?3:dir==1?2:dir==2?1:dir==3?0:-1;
                            q.add(new Integer[]{x + r[z][0] < 0 ? n-1 : (x + r[z][0])%n , y + r[z][1] < 0 ? m-1 : (y + r[z][1])%m , dir, dist + 1});
                        }
                    }
//                    System.out.println("========");
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
        Arrays.sort(answer);
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
}
