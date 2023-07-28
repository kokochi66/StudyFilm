import java.util.*;
public class KNU_week5_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = "";
        String a = sc.nextLine();
        String b = sc.nextLine();
        boolean Clear = true;
        boolean Good = false;
        while(!input.equals("e")){
            input = sc.nextLine();
            if(input.equals("u")){
                a=a.substring(1,a.length());
                b=b.substring(0,b.length()-1);
            }
            else if(input.equals("d")){
                a=a.substring(0,a.length()-1);
                b=b.substring(1,b.length());
            }
            // System.out.println(a + "        " + b);
        }
        HashSet<Character> alphaSet = new HashSet<Character>();
        for(int i=0;i<b.length();i++){
            if((b.charAt(i)>='a'&&b.charAt(i)<='z') || (b.charAt(i)>='A'&&b.charAt(i)<='Z')) {
                // System.out.println(b.charAt(i));
                alphaSet.add(b.charAt(i));
            }
        }
        for(int i=0;i<a.length();i++){
            if((a.charAt(i)>='a'&&a.charAt(i)<='z') || (a.charAt(i)>='A'&&a.charAt(i)<='Z')) {
                if(!alphaSet.contains(a.charAt(i))) {
                    if(alphaSet.contains(Character.toUpperCase(a.charAt(i))) || alphaSet.contains(Character.toLowerCase(a.charAt(i)))) Good = true;
                    else Clear = false;
                }
            }
        }
        if(a.length()==0) Clear=false;
        if(Good) System.out.println("Good");
        else if(Clear) System.out.println("Perfect");
        else System.out.println("Miss");
    }
}
