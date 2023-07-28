import java.util.*;
import java.io.*;

public class BKJ1119 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static char[][] carr;
    static boolean[] used, check;
    static int h, w, n;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        h = Integer.parseInt(tok.nextToken());
        w = Integer.parseInt(tok.nextToken());
        Queue<marble> q = new LinkedList<>();
        int[] swit = new int[4];
        carr = new char[h][w];
        for(int i=0;i<h;i++) {
            carr[i] = Read.readLine().toCharArray();
            for(int j=0;j<w;j++) {
                if(carr[i][j] == 'B') {
                    swit[0] = i;
                    swit[1] = j;
                    carr[i][j] = '.';
                } else if(carr[i][j] == 'R') {
                    swit[2] = i;
                    swit[3] = j;
                    carr[i][j] = '.';
                }
            }
        }
        q.offer(new marble(swit[0],swit[1],swit[2],swit[3]));
        // 입력부 O

        HashSet<String> set = new HashSet<>();
        boolean pass = false;
        int count = 0;
        long sum = 0;
        while(!q.isEmpty() && !pass && count<10) {
            count++;
            int Today = q.size();
            sum += Today;
            int index, rs=0, bs=0;
            for(int i=0;i<Today;i++){
                marble mr = q.poll();
                // mr.print();
                String ts = mr.bh+" "+mr.bw+" "+mr.rh+" "+mr.rw;
                if(!set.contains(ts)){
                    boolean fr = mr.bh > mr.rh;
                    set.add(ts);
                    // 1. 위로 올리기 O
                    if(fr) {
                        boolean flt = false;
                        index = mr.rh;
                        while(carr[index][mr.rw]!='O' && !(index==mr.bh&&mr.rw==mr.bw) && carr[index][mr.rw]!='#') index--;
                        if(carr[index][mr.rw]=='O') {
                            pass = true;
                            rs = index;
                        }
                        else rs = index+1;
                        index = mr.bh;
                        while(carr[index][mr.bw]!='O' && !(index==rs&&mr.rw==mr.bw) && carr[index][mr.bw]!='#') index--;
                        if(carr[index][mr.bw]=='O') {
                            flt = true;
                            pass =false;
                        }
                        bs = index+1;
                        if(pass) break;
                        if(!flt) q.offer(new marble(bs, mr.bw,rs, mr.rw));
                    }
                    else {
                        boolean flt = false;
                        index = mr.bh;
                        while(carr[index][mr.bw]!='O' && !(index==mr.rh&&mr.rw==mr.bw) && carr[index][mr.bw]!='#') index--;
                        if(carr[index][mr.bw]=='O') flt = true;
                        bs = index+1;
                        index = mr.rh;
                        while(carr[index][mr.rw]!='O' && !(index==bs&&mr.rw==mr.bw) && carr[index][mr.rw]!='#') index--;
                        if(carr[index][mr.rw]=='O' && !flt) {
                            pass = true;
                            break;
                        }
                        rs = index+1;
                        if(!flt) q.offer(new marble(bs, mr.bw,rs, mr.rw));
                    }

                    // 2. 아래로 내리기 OO
                    fr = mr.bh < mr.rh;
                    if(fr) {
                        boolean flt = false;
                        index = mr.rh;
                        while(carr[index][mr.rw]!='O' && !(index==mr.bh&&mr.rw==mr.bw) && carr[index][mr.rw]!='#') index++;
                        if(carr[index][mr.rw]=='O') {
                            pass = true;
                            rs = index;
                        }
                        else rs = index-1;
                        index = mr.bh;
                        while(carr[index][mr.bw]!='O' && !(index==rs&&mr.rw==mr.bw) && carr[index][mr.bw]!='#') index++;
                        if(carr[index][mr.bw]=='O') {
                            flt = true;
                            pass =false;
                        }
                        bs = index-1;
                        if(pass) break;
                        if(!flt) q.offer(new marble(bs, mr.bw,rs, mr.rw));
                    }
                    else {
                        boolean flt = false;
                        index = mr.bh;
                        while(carr[index][mr.bw]!='O' && !(index==mr.rh&&mr.rw==mr.bw) && carr[index][mr.bw]!='#') index++;
                        if(carr[index][mr.bw]=='O') flt = true;
                        bs = index-1;
                        index = mr.rh;
                        while(carr[index][mr.rw]!='O' && !(index==bs&&mr.rw==mr.bw) && carr[index][mr.rw]!='#') index++;
                        if(carr[index][mr.rw]=='O' && !flt) {
                            pass = true;
                            break;
                        }
                        rs = index-1;
                        if(!flt) q.offer(new marble(bs, mr.bw,rs, mr.rw));
                    }

                    // 3. 왼쪽으로 기울이기 OO
                    fr = mr.bw > mr.rw;
                    if(fr) {
                        boolean flt = false;
                        index = mr.rw;
                        while(carr[mr.rh][index]!='O' && !(index==mr.bw&&mr.rh==mr.bh) && carr[mr.rh][index]!='#') index--;
                        if(carr[mr.rh][index]=='O') {
                            pass = true;
                            rs = index;
                        } else rs = index+1;
                        index = mr.bw;
                        while(carr[mr.bh][index]!='O' && !(index==rs&&mr.rh==mr.bh) && carr[mr.bh][index]!='#') index--;
                        if(carr[mr.bh][index]=='O') {
                            flt = true;
                            pass = false;
                        }
                        bs = index+1;
                        if(pass) break;
                        if(!flt) q.offer(new marble(mr.bh, bs,mr.rh, rs));
                    }
                    else {
                        boolean flt = false;
                        index = mr.bw;
                        while(carr[mr.bh][index]!='O' && !(index==mr.rw&&mr.rh==mr.bh) && carr[mr.bh][index]!='#') index--;
                        if(carr[mr.bh][index]=='O') flt = true;
                        bs = index+1;
                        index = mr.rw;
                        while(carr[mr.rh][index]!='O' && !(index==bs&&mr.rh==mr.bh) && carr[mr.rh][index]!='#') index--;
                        if(carr[mr.rh][index]=='O' && !flt) {
                            pass = true;
                            break;
                        }
                        rs = index+1;
                        if(!flt) q.offer(new marble(mr.bh, bs,mr.rh, rs));
                    }

                    // // 4. 오른쪽으로 기울이기
                    fr = mr.bw < mr.rw;
                    if(fr) {
                        boolean flt = false;
                        index = mr.rw;
                        while(carr[mr.rh][index]!='O' && !(index==mr.bw&&mr.rh==mr.bh) && carr[mr.rh][index]!='#') index++;
                        if(carr[mr.rh][index]=='O') {
                            pass = true;
                            rs = index;
                        }
                        else rs = index-1;
                        index = mr.bw;
                        while(carr[mr.bh][index]!='O' && !(index==rs&&mr.rh==mr.bh) && carr[mr.bh][index]!='#') index++;
                        if(carr[mr.bh][index]=='O') {
                            flt = true;
                            pass =false;
                        }
                        bs = index-1;
                        if(pass) break;
                        if(!flt) q.offer(new marble(mr.bh, bs,mr.rh, rs));
                    }
                    else {
                        boolean flt = false;
                        index = mr.bw;
                        while(carr[mr.bh][index]!='O' && !(index==mr.rw&&mr.rh==mr.bh) && carr[mr.bh][index]!='#') index++;
                        if(carr[mr.bh][index]=='O') flt = true;
                        bs = index-1;
                        index = mr.rw;
                        while(carr[mr.rh][index]!='O' && !(index==bs&&mr.rh==mr.bh) && carr[mr.rh][index]!='#') index++;
                        if(carr[mr.rh][index]=='O' && !flt) {
                            pass = true;
                            break;
                        }
                        rs = index-1;
                        if(!flt) q.offer(new marble(mr.bh, bs,mr.rh, rs));
                    }
                }
            }
        }
        if(!pass) System.out.println("-1");
        else System.out.println(count);
    }
    static class marble {
        int bh, bw;
        int rh, rw;
        public marble(int a, int b, int c, int d){
            this.bh = a;
            this.bw = b;
            this.rh = c;
            this.rw = d;
        }
        public void print() {
            System.out.println(bh+" "+bw+" "+rh+" "+rw);
        }
    }
    public static void BKJ1119_1() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        int mc = Integer.parseInt(tok.nextToken());
        char[][] carr = new char[n][mc];
        for(int i=0;i<n;i++){
            carr[i] = Read.readLine().toCharArray();
        }
        // 입력부 O

        boolean[][] dused = new boolean[n][mc];
        boolean[][] noboom = new boolean[n][mc];
        Queue<moveit> q = new LinkedList<>();
        q.offer(new moveit(0,0,true));
        boolean pass = false;
        int count = 0;
        // 주요 선언부
        long sum = 0;
        while(!q.isEmpty() && !pass){
            count++;
            int Today = q.size();
            sum += Today;
            for(int tt=0;tt<Today;tt++){
                moveit m = q.poll();
                // System.out.println(m.hi+" "+m.wi+" "+m.boom); 
                if(m.hi == n-1 && m.wi == mc-1) {
                    pass = true;
                    break;
                }
                if(!dused[m.hi][m.wi]&&((!m.boom&&!noboom[m.hi][m.wi]) || m.boom)) {
                    if(m.boom) dused[m.hi][m.wi] = true;
                    else noboom[m.hi][m.wi] = true;
                    if(m.hi>0) {
                        if(carr[m.hi-1][m.wi] == '1' && m.boom) q.offer(new moveit(m.hi-1,m.wi,false));
                        else if(carr[m.hi-1][m.wi] == '0') q.offer(new moveit(m.hi-1,m.wi,m.boom));
                    }
                    if(m.wi>0) {
                        if(carr[m.hi][m.wi-1] == '1' && m.boom) q.offer(new moveit(m.hi,m.wi-1,false));
                        else if(carr[m.hi][m.wi-1] == '0') q.offer(new moveit(m.hi,m.wi-1,m.boom));
                    }
                    if(m.hi<n-1) {
                        if(carr[m.hi+1][m.wi] == '1' && m.boom) q.offer(new moveit(m.hi+1,m.wi,false));
                        else if(carr[m.hi+1][m.wi] == '0') q.offer(new moveit(m.hi+1,m.wi,m.boom));
                    }
                    if(m.wi<mc-1) {
                        if(carr[m.hi][m.wi+1] == '1' && m.boom) q.offer(new moveit(m.hi,m.wi+1,false));
                        else if(carr[m.hi][m.wi+1] == '0') q.offer(new moveit(m.hi,m.wi+1,m.boom));
                    }
                }
            }
            // System.out.println("현재 카운트 ::::::: "+count);
            // for(int i=0;i<n;i++){
            //     System.out.println(Arrays.toString(dused[i]));
            // }
            // System.out.println();
            // for(int i=0;i<n;i++){
            //     System.out.println(Arrays.toString(noboom[i]));
            // }
        }
        // System.out.println(sum);
        if(!pass) System.out.println(-1);
        else System.out.println(count);
    }
    static class moveit {
        int hi, wi;
        boolean boom;
        public moveit(int a, int b, boolean bm) {
            this.hi = a;
            this.wi = b;
            this.boom = bm;
        }
    }
}