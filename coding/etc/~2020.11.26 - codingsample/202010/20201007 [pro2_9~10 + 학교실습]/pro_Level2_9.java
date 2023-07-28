public class pro_Level2_9 {
    public static int solution(String s) {
        int min = s.length(), k=0, TempK, tempCount;
        String outTemp = "";
        String CurrString;
        for(int i=1;i<=s.length()/2;i++){
            outTemp = "";
            // System.out.println(":: 현재 "+i+"개의 문자열을 돌고 있습니다. ::");
            for(int j=0;j<s.length();j+=i){
                tempCount=1;
                k = i;
                if(j+i<=s.length()){
                    CurrString = s.substring(j, j+i);
                    while(j+k+i <= s.length() && (CurrString.equals(s.substring(j+k,j+k+i)))){
                        tempCount++;
                        k += i;
                    }
                }
                else CurrString = s.substring(j, s.length());
                if(tempCount>1) {
                    j+=(k-i);
                    outTemp += tempCount+CurrString;
                    // System.out.println(tempCount+CurrString+" "+j);
                }
                else {
                    outTemp += CurrString;
                    // System.out.println(CurrString);
                }
            }
            // System.out.println(outTemp);
            if(min>outTemp.length()) min = outTemp.length();
        }
        return min;
    }
    public static void main(String[] args){
        System.out.println(solution("abcabcabcabcdededededede"));
    }
    
}
