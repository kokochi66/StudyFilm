import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bkjcoing_L10 {

    public static void P1() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        input = bfr.readLine();
        StringTokenizer inputToken = new StringTokenizer(input," ");
        int CdecCount = 0;
        while(inputToken.hasMoreTokens()){
            int whatThis = Integer.parseInt(inputToken.nextToken());
            int CdecPoint = 1;
            while(CdecPoint <= (int) Math.sqrt(whatThis)){
                if(CdecPoint != 1 && whatThis%CdecPoint==0 || whatThis==1) break;
                if(CdecPoint == (int) Math.sqrt(whatThis)){
                    CdecCount++;
                }
                CdecPoint++;
            }

        }
        bfw.write(CdecCount+"");
        bfw.flush();
        bfw.close();
        bfr.close();

    }
    public static void P2() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int M = Integer.parseInt(input);
        input = bfr.readLine();
        int N = Integer.parseInt(input);
        int sum = 0, first = 0;
        while(M <= N){
            int CdecPoint = 1;
            while(CdecPoint <= (int) Math.sqrt(M)){
                if(CdecPoint!=1&&M%CdecPoint==0||M==1) break;
                if(CdecPoint == (int) Math.sqrt(M)){
                    if(sum==0) first = M;
                    sum += M;
                }
                CdecPoint++;
            }
            M++;
        }
        if(sum==0) bfw.write(-1+"");
        else {
            bfw.write(sum+"");
            bfw.newLine();
            bfw.write(first+"");
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P3() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        StringTokenizer inputToken = new StringTokenizer(input);
        int M = Integer.parseInt(inputToken.nextToken()), N = Integer.parseInt(inputToken.nextToken());
        int first = 0;
        while(M <= N){
            int CdecPoint = 1;
            while(CdecPoint <= (int) Math.sqrt(M)){
                if(CdecPoint!=1&&M%CdecPoint==0||M==1) break;
                if(CdecPoint == (int) Math.sqrt(M)){
                    first = M;
                    bfw.write(M+"");
                    bfw.newLine();
                }
                CdecPoint++;
            }
            M++;
        }
        if(first==0) bfw.write(-1+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P4() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        while(!input.equals("0")){
            int n = Integer.parseInt(input);
            int maxPoint = 2*n, CdecCount = 0;
            n++;
            while(n<=maxPoint){
                int CdecPoint = 1;
                while(CdecPoint <= (int)Math.sqrt(n)){
                    if(CdecPoint!=1&&n%CdecPoint==0||n==1) break;
                    if(CdecPoint == (int)Math.sqrt(n)) CdecCount++;
                    CdecPoint++;
                }
                n++;
            }
            bfw.write(CdecCount+"");
            bfw.newLine();
            input = bfr.readLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P5() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int forTest = Integer.parseInt(input);
        boolean AllVerClear = false;
        for(int TestCase=0;TestCase<forTest;TestCase++){
            AllVerClear = false;
            input = bfr.readLine();
            int inputInteger = Integer.parseInt(input);
            int Overplan =inputInteger/2;
            while(Overplan < inputInteger-1){
                int CdecPoint = 1;
                while(CdecPoint <= (int)Math.sqrt(Overplan)){
                    if(CdecPoint!=1&&Overplan%CdecPoint==0 || Overplan==1) break;
                    if(CdecPoint == (int)Math.sqrt(Overplan)) {
                        int ForVerify = inputInteger - Overplan;
                        int SecCdecPoint = 1;
                        while(SecCdecPoint <= (int)Math.sqrt(ForVerify)){
                            if(SecCdecPoint!=1&&ForVerify%SecCdecPoint==0 || ForVerify==1) break;
                            if(SecCdecPoint == (int)Math.sqrt(ForVerify)) {
                                bfw.write(ForVerify + " " + Overplan);
                                bfw.newLine();
                                AllVerClear = true;
                                break;
                            }
                            SecCdecPoint++;
                        }
                        if(AllVerClear) break;
                    }
                    CdecPoint++;
                }
                if(AllVerClear) break;
                Overplan++;
            }
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P6() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        StringTokenizer inputToken = new StringTokenizer(input);
        int MyXPoint = Integer.parseInt(inputToken.nextToken()), MyYPoint = Integer.parseInt(inputToken.nextToken());
        int SquareX = Integer.parseInt(inputToken.nextToken()), SquareY = Integer.parseInt(inputToken.nextToken());
        bfw.write(Math.min(Math.min(MyXPoint-0,SquareX-MyXPoint),Math.min(MyYPoint-0,SquareY-MyYPoint))+"");
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P7() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        StringTokenizer inputToken = new StringTokenizer(input," ");
        String CurrX = inputToken.nextToken(), CurrY = inputToken.nextToken();
        boolean nextOneX = false, nextOneY = false;
        input = bfr.readLine();
        inputToken = new StringTokenizer(input," ");
        String tempX = inputToken.nextToken(), tempY = inputToken.nextToken();
        if(CurrX.equals(tempX)) nextOneX=true;
        if(CurrY.equals(tempY)) nextOneY=true;
        input = bfr.readLine();
        String[] inputTokenZ = input.split(" ");
        String outputX, outputY;
        if(nextOneX) bfw.write(inputTokenZ[0]+" ");
        else if(CurrX.equals(inputTokenZ[0])) bfw.write(tempX+" ");
        else bfw.write(CurrX+" ");
        if(nextOneY) bfw.write(inputTokenZ[1]);
        else if(CurrY.equals(inputTokenZ[1])) bfw.write(tempY);
        else bfw.write(CurrY);
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P8() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        while(!input.equals("0 0 0")){
            StringTokenizer inputToken = new StringTokenizer(input);
            int[] ThrPoint = new int[3];
            ThrPoint[0] = Integer.parseInt(inputToken.nextToken());
            ThrPoint[1] = Integer.parseInt(inputToken.nextToken());
            ThrPoint[2] = Integer.parseInt(inputToken.nextToken());
            Arrays.sort(ThrPoint);
            if(((int)Math.pow(ThrPoint[2],2) - (int)Math.pow(ThrPoint[1],2) - (int)Math.pow(ThrPoint[0],2)) == 0) bfw.write("right");
            else bfw.write("wrong");
            bfw.newLine();
            input = bfr.readLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void P9() throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int r = Integer.parseInt(input);
        System.out.printf("%.6f\n",Math.PI*r*r);
        System.out.printf("%.6f\n",(double)(2*r*r));
    }
    public static void P10() throws Exception { 
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        String output = "";
        int TestCount = Integer.parseInt(input);
        for(int TestCase=0;TestCase<TestCount;TestCase++){
            input = bfr.readLine();
            output = "";
            StringTokenizer inputToken = new StringTokenizer(input);
            int x1 = Integer.parseInt(inputToken.nextToken()), y1= Integer.parseInt(inputToken.nextToken()), r1=Integer.parseInt(inputToken.nextToken());
            int x2 = Integer.parseInt(inputToken.nextToken()), y2= Integer.parseInt(inputToken.nextToken()), r2= Integer.parseInt(inputToken.nextToken());
            if(x1==x2 && y1==y2){
                if(r1!=r2) output = 0+"";
                else if(r1>0) output = -1+"";
                else if(r1==0) output = 1+"";
            }
            else {
                double distance = Math.sqrt(Math.pow(Math.abs(x2-x1),2) + Math.pow(Math.abs(y2-y1),2));
                double var = (double)(r1+r2);
                if(var<distance) output = 0+"";
                else if(var==distance) output = 1+"";
                else {
                    var = (double)Math.max(r1, r2) - distance;
                    distance = (double)Math.min(r1,r2);
                    if(var>distance) output = 0+"";
                    else if(var==distance ) output = 1+"";
                    else output = 2+"";
                }
            }
            bfw.write(output);
            bfw.newLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
    public static void main(String[] args) throws Exception {
        P10();
    }
}
