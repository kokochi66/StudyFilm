public class pro_Level1_11 {
    public static long solution(int a, int b) {
        long max = Math.max(a,b), min = Math.min(a,b), temp = 1;
        if(max<0) {
            temp = Math.abs(max);
            max = Math.abs(min);
            min = temp;
            temp = -1;
        }
        return temp*((max*(max+1))/2 - ((min-1)*(min))/2);
    }
    
}
