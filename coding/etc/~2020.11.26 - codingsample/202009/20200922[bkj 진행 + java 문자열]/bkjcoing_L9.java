import java.io.*;
public class bkjcoing_L9 {
    public static void P1() throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        String[] inputToken = input.split(" ");
        int A = Integer.parseInt(inputToken[0]), B = Integer.parseInt(inputToken[1]), C = Integer.parseInt(inputToken[2]);
        if(C-B <= 0) bfw.write(-1+"");
        else bfw.write((A/(C-B))+1+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    //고정수입 A, 재료비 B, 가격C라고 했을때, 손익분기점이 되는 개수를 출력.

    public static void P2() throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int A = Integer.parseInt(input);
        int temp = A/5;
        A = A%5;
        if(A%3!=0) {
            if(temp==0) bfw.write(-1+"");
            else while(temp>0){
                temp--;
                A+=5;
                if(A%3==0) {
                    bfw.write((temp+(A/3))+"");
                    break;
                }
                else if(temp==0) bfw.write(-1+"");
            } 
        }
        else bfw.write((temp+(A/3))+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    // 3,5 봉지가 있을때, 입력된 값을 어떻게 봉지에 담아야 적게 봉지를 담아가는지 출력
    public static void P3() throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int A = Integer.parseInt(input)-1;
        int count = 1;
        while(A>0){
            A -= (count*6);
            count++;
        }
        bfw.write(count+"");
        bfw.flush();
        bfw.close();
        bfr.close();

    }
    //벌집 육각형 구조에서 이웃하는 방으로 이동하는 방의 개수 출력
    public static void P4() throws Exception { 
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        boolean even = false;
        int A = Integer.parseInt(input);
        int n = 1;
        while(n*(n+1)/2 < A) n++;
        if(n%2==0) even = true;
        n--;
        A -= (n*(n+1)/2)+1;
        if(even) bfw.write((1+A)+"/"+(n+1-A));
        else bfw.write((n+1-A)+"/"+(1+A));
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    //특정 규칙을 가진 표에서 원하는 위치에 있는 값을 찾기
    public static void P5() throws Exception { 
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        String[] inputToken = input.split(" ");
        int A = Integer.parseInt(inputToken[0]), B = Integer.parseInt(inputToken[1]), C = Integer.parseInt(inputToken[2]);
        bfw.write((int)(Math.ceil((double)(C-A)/(double)(A-B)))+1+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    //달팽이가 A미터 올라가고 B미터 미끄러지면 C미터까지 얼마나 걸리는지 출력
    public static void P6() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int a = Integer.parseInt(input);
        for(int i=0;i<a;i++){
            input = bfr.readLine();
            String[] inputToken = input.split(" ");
            int H = Integer.parseInt(inputToken[0]),  W = Integer.parseInt(inputToken[1]),  N = Integer.parseInt(inputToken[2]);
            W = (int)Math.ceil((double)N/(double)H);
            H = ((N-1)%H)+1;
            if(W>9) bfw.write(H+""+W);
            else bfw.write(H+"0"+W);
            bfw.newLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    //HxW호텔에서 N번째 손님이 들어가는 방번호
    public static void P7() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int a = Integer.parseInt(input);
        int[][] output = new int[15][14];
        for(int i=0;i<14;i++) output[0][i] = i+1;
        for(int i=0;i<a;i++){
            input = bfr.readLine();
            int k = Integer.parseInt(input);
            input = bfr.readLine();
            int n = Integer.parseInt(input);
            for(int flr=1;flr<=k;flr++){
                for(int rm=0;rm<n;rm++){
                    if(rm==0){ output[flr][rm] = output[flr-1][rm];
                    }
                    else output[flr][rm] = output[flr][rm-1] +  output[flr-1][rm];
                }
            }
            bfw.write(output[k][n-1]+"");
            bfw.newLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    // k층 n호에살고있는 사람수
    public static void P8() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int a = Integer.parseInt(input);
        for(int testCase=0;testCase<a;testCase++){
            input = bfr.readLine();
            String[] inputToken = input.split(" ");
            int x = Integer.parseInt(inputToken[0]), y = Integer.parseInt(inputToken[1]);
            int sum = y-x;
            long n=(long)Math.sqrt(sum/2);
            while((long)(n*(n+1)) < (long)sum) n++;
            if(n*(n+1)-((n*(n+1) - (n-1)*n)/2) < sum) bfw.write((2*n)+"");
            else bfw.write(((2*n)-1)+"");
            bfw.newLine();
            }
            bfw.flush();
            bfw.close();
            bfr.close();
    }
    // 우주선 이동회수 k-1, k, k+1
    public static void main(String[] args) throws Exception{
        P8();
    }
}