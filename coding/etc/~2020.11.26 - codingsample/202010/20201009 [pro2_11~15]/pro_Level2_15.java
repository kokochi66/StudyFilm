public class pro_Level2_15 {
    public static int Func(StringBuilder name, StringBuilder Target, int x){
        if(x == name.length()) return 0;
        int sum = 0, CurrSwit = x;
        sum += Math.min(('Z'-name.charAt(x)+1) , name.charAt(x) - 'A');
        Target.replace(x, x+1, Character.toString(name.charAt(x)));
        int y = 1;
        int len = name.length();
        int SwitY = (len)-1-((len-CurrSwit-1+y)%len);
        while(x<len && name.charAt(x) == Target.charAt(x)) x++;
        while(SwitY != CurrSwit && name.charAt(SwitY) == Target.charAt(SwitY)) {
            y++;
            SwitY = (len)-1-((len-CurrSwit-1+y)%len);
        }
        sum += Math.min(Math.min(x-CurrSwit , len-x+CurrSwit), Math.min(SwitY-CurrSwit , len-SwitY+CurrSwit));
        // System.out.println("CurrS = "+CurrSwit+"   SwitX = "+x+"  SwitY = "+SwitY);
        // System.out.println(Target +"   " + sum);
        x--;
        return sum+Func(name,Target,x+1);
    }
    public static int solution(String name) {
        StringBuilder Target = new StringBuilder();
        StringBuilder s = new StringBuilder(name);
        for(int i=0;i<name.length();i++) Target.append("A");
        return Func(s,Target,0);
    }
    public static void main(String[] args){
        System.out.println(solution("JEROEN"));
    }
    
}
