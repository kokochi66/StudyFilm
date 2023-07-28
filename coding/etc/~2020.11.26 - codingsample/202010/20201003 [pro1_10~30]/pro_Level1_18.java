public class pro_Level1_18 {
    public static String solution(int n) {
        String output = "";
        for(int i=0;i<n;i++){
            if(i%2==0) output += "수";
            else output += "박";
        }
        return output;
    }
}
