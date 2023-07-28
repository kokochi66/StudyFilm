import java.util.Scanner;
public class KNU_week4_2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String SecretOver = sc.nextLine();
        String SecretArr = sc.nextLine();
        while(sc.hasNext()){
            boolean ErrState = false;
            StringBuilder input = new StringBuilder(sc.nextLine().toUpperCase());
            StringBuilder output = new StringBuilder("");
            StringBuilder temp = new StringBuilder("");
            int TempSwitchX=-1, TempSwitchY=-1;
            while(input.length()>0){
                temp.delete(0,temp.length());
                while(temp.length()<2){
                    if(input.charAt(0)==' ') output.append(" ");
                    else temp.append(input.charAt(0));
                    input.delete(0, 1);
                    if(temp.length()<2&&input.length()==0) {
                        ErrState = true;
                        break;
                    }
                }
                if(ErrState) break;
                TempSwitchX=-1;
                TempSwitchY=-1;
                for(int i=0;i<SecretOver.length();i++){
                    if(temp.charAt(0)==SecretOver.charAt(i)) TempSwitchX=i;
                    if(temp.charAt(1)==SecretOver.charAt(i)) TempSwitchY=i;
                }
                if(TempSwitchX==-1||TempSwitchY==-1) ErrState=true;
                else output.append(SecretArr.charAt((TempSwitchX*SecretOver.length())+TempSwitchY));
                if(ErrState) break;
            }

            if(ErrState) {
                System.out.println("-ERROR-");
            }
            else System.out.println(output);
        }
    }
    
}
