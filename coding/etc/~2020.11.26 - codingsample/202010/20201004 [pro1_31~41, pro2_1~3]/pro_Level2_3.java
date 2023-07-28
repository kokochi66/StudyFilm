public class pro_Level2_3 {
    public static String solution(int n) {
        // String output = "";
        // int NumDigitThr = 1;
        // long tempDigit = 0;
        // while(tempDigit < n) tempDigit += (long) Math.pow(3,NumDigitThr++);
        // NumDigitThr--;
        // long tempVar = 0;
        // while(tempDigit>0){
        //     tempDigit -= (long) Math.pow(3,NumDigitThr--);
        //     tempVar = (long) Math.pow(3,NumDigitThr);
        //     if(n <= tempDigit+(tempVar*1)) {
        //         output += "1";
        //         n -= (tempVar*1);
        //     }
        //     else if(n <= tempDigit+(tempVar*2)) {
        //         output += "2";
        //         n -= (tempVar*2);
        //     }
        //     else if(n <= tempDigit+(tempVar*3)) {
        //         output += "4";
        //         n -= (tempVar*3);
        //     }
        // }
        // return output;
        String[] tempString = {"1","2","4"};
        String output = "";
        while(n>0){
            output = tempString[(n-1)%3] + output;
            n = (n-1)/3;
        }
        return output;
    }
}
