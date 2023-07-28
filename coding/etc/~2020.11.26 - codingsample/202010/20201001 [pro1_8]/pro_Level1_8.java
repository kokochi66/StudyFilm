public class pro_Level1_8 {
    public static String solution(String s) {
        // if(s.length()%2==0) return s.substring((s.length()/2)-1, (s.length()/2)+1);
        // else return s.substring(s.length()/2, (s.length()/2)+1);
        return s.substring((s.length()-1)/2, (s.length()/2)+1);
    }
    public static void main(String[] args){
        System.out.println(solution("asdfdafgsfdhsdhsfhfghfdgnhgggg"));

    }
    
}
