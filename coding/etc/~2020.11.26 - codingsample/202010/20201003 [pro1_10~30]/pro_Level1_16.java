public class pro_Level1_16 {
    public static String solution(String[] seoul) {
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].indexOf("Kim")!=-1) return "김서방은 "+i+"에 있다";
        }
        return "";
    }
}
