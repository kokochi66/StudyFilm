public class pro_Level1_22 {
    public static String solution(String a) {
        boolean alpha = false;
        String output = "";
        int swit = 0;
        a = a.toLowerCase();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != ' ' && !alpha) {
            alpha = true;
            swit = i;
            } else if(a.charAt(i) == ' ') {
            alpha = false;
            output += " ";
            }
            
            if(alpha){
                if((i-swit)%2==0) output += Character.toString(a.charAt(i)).toUpperCase();
                else output += Character.toString(a.charAt(i)).toLowerCase();
            }
        }
            return output;
        }
}
