public class TheCore4_Loop_Tunnel {
    private static int Factorial(int n){
        if(n==1) return 1;
        return n*Factorial(n-1);
    }
    private static int leastFactorial(int n) {
        int i = 1;
        while(Factorial(i)<n) i++;
        return Factorial(i);
    }
    // n보다 큰 가장 작은 팩토리알을 출력

    private static int countSumOfTwoRepresentations2(int n, int l, int r) {
        int output;
        if(n%2==1){
            output = Math.min((n/2)-l,r-(n/2)-1)+1;
            if(output<0) return 0;
            else return output;
        }
        else {
            output = Math.min((n/2)-l,r-(n/2))+1;
            if(output<0) return 0;
            else return output;
        }
    }
    // l<=A<=B<=r 이고, A+B=n인 수의 개수를 출력

    private static int magicalWell(int a, int b, int n) {
        if(n==0) return 0;
        return a*b+magicalWell(a+1,b+1,n-1);
    }
    //n번의 마법을 부렸을때 1씩 늘어나는 a*b 보상의 합을 출력

    private static int lineUp(String commands) {
        int direction = 0;
        boolean LRcount = false;
        for(int i=0;i<commands.length();i++){
            if(commands.charAt(i)=='L'||commands.charAt(i)=='R'){
                if(LRcount) {
                    LRcount = false;
                    direction++;
                }
                else LRcount = true;
            }
            else if(!LRcount) direction++;
        }
        return direction;
    }
    //L,R,A 호령을 하며, 한명은 무조건 반대로 돌때, 모두 같은 방향을 보는 회수를 출력

    private static int additionWithoutCarrying(int param1, int param2) {
        if(param1==0&&param2==0) return 0;
        return (param1+param2)%10 + additionWithoutCarrying(param1/10,param2/10)*10;
    }
    // 올림을 넣지 않는 덧셈결과를 출력

    private static int appleBoxes(int k) {
        if(k==1) return -1;
        int n = k*k;
        if(k%2!=0) n = -n;
        return n + appleBoxes(k-1);
    }
    // k까지의 사과박스에 각각 짝수제곱은 +, 홀수제곱은 -로 했을때, 합을 구하시오.
    
    private static boolean increaseNumberRoundness(int n) {
        String output = n+"";
        boolean check = false;
        for(int i=output.length()-1;i>=0;i--){
            if(output.charAt(i)!='0') {
                check=true;
            }
            else if(check) return true;
        }
        return false;
    }
    //정수 끝자리에 붙은 0을 제외하고 또 0이 있는지 출력
    private static int rounders(int n) {
        int temp = 0, count = 0;
        while(n/10!=0){
            if(n%10>=5) temp = 10;
            else temp = 0;
            n += temp;
            n/=10;
            count++;
        }
        return n*(int)Math.pow(10,count);
    }
    //끝자리부터 반올림하여 최종값을 출력

    private static int candles(int candlesNumber, int makeNew) {
        int countLeft = 0;
        int output = 0;
        while(candlesNumber>0){
            candlesNumber--;
            output++;
            countLeft++;
            if(countLeft==makeNew) {
                countLeft -=makeNew;
                candlesNumber++;
            }
        }
        return output;
    }
    //양초가 꺼지고, 남은 양초 makeNew개로 새 양초를 만들 수 있을때, 총 돌릴 수 있는 양초를 출력
    private static int countBlackCells(int n, int m) {
        int count = 0;
        double inc = (double)n/(double)m;
        for(int i=1;i<m;i++){
            if((inc*(double)i)==Math.round((inc*(double)i))) {
                count++;
            }
        }
        return n+m-1+count;
    }
    //대각선을 그었을때, 대각선에 닿은 부분을 제외한 너비를 출력
    
    public static void main(String[] args){
        System.out.println(leastFactorial(17));
        System.out.println(countSumOfTwoRepresentations2(6,2,4));
        System.out.println(magicalWell(1,2,2));
        System.out.println(lineUp("LLALR"));
        System.out.println(additionWithoutCarrying(496,1734));
        System.out.println(appleBoxes(5));
        System.out.println(increaseNumberRoundness(902200100));
        System.out.println(rounders(15));
        System.out.println(candles(5,2));
        System.out.println(countBlackCells(3,4));
    }
}
