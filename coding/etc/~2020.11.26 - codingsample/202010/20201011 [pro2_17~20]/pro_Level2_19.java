public class pro_Level2_19 {
    public static int DepSearch(int[] num, int swit, int sum, int target, int sign){
        sum += (sign*num[swit]);
        if(swit == num.length-1) return target == sum ? 1 : 0;
        return DepSearch(num,swit+1,sum,target,-1) + DepSearch(num,swit+1,sum,target,1);
    }
        public int solution(int[] numbers, int target) {
            
            return DepSearch(numbers, 0, 0, target, 1) + DepSearch(numbers, 0, 0, target, -1);
        }
}
