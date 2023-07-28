public class pro_Level2_2 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                if(prices[i]>prices[j] || j==prices.length-1){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
}
