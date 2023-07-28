public class pro_Level1_31 {
    public static int solution(int num) {
        int count = 0;
        while(num!=1&&count++<400){
            if(num%2==0) num /= 2;
            else num = (num*3)+1;
        }
        if(count>=400) count = -1;
        return count;
    }
}
