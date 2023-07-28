public class pro_Level1_7 {
    public static String solution(int a, int b) {
        String[] Week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        // +4%7
        int point=0;
        if(((a-1)%7)%2==1) point=1;
        int sum = b;
        sum += ((((a-1)%7)/2)+point)*31 + (((a-1)%7)/2)*30;
        if(a>7){
            sum += (31*4) + (30*3);
        }
        if(a>2) sum-=1;
        System.out.println("Sum = " + sum);
        return Week[(sum+4)%7];
    }
    public static void main(String[] args){
        System.out.println(solution(7, 31));
    }
}
