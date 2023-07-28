public class pro_MonthChel1008_1 {
    public static  int solution(int n) {
        String temp = "";
        while(n!=0){
            temp += (n%3)+"";
            n /= 3;
        }
        int i = 0, sum =0;
        while(!temp.equals("")){
            int tempN = Integer.parseInt(temp.substring(temp.length()-1,temp.length()));
            sum += Math.pow(3, i++)*tempN;
            temp = temp.substring(0, temp.length()-1);
            // System.out.println("sum = " + sum +" "+temp);
        }
        // System.out.println(sum);
        return 0;
    }
    public static void main(String[] args){
        System.out.println(solution(45));
    }
}
