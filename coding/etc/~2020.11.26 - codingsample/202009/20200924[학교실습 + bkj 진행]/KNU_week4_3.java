import java.io.*;
public class KNU_week4_3 {
    public static boolean checkTeemo(int i, int j, String[] ArrSearch, String Target, int Direct){
        int CurrX=i, CurrY=j;
        int TargetNum=0;
        int errCount=0;
        Boolean CheckConti = false;
        for(int None=0;None<5;None++){
            if(ArrSearch[CurrX].charAt(CurrY) != Target.charAt(TargetNum)) {
                if(CheckConti) break;
                errCount++;
                CheckConti = true;
            }
            else CheckConti = false;
            if(errCount>2) break;
            if(None==4) return true;

            if(Direct<4) CurrX--;
            else if(Direct>5) CurrX++;
            if(Direct==1||Direct==4||Direct==6) CurrY--;
            else if(Direct==3||Direct==5||Direct==8) CurrY++;
            TargetNum++;
        }
        return false;
    }
    public static StringBuilder[] checkingSharp(StringBuilder[] output, int i, int j, int Direct){
        int CurrX = i, CurrY = j;
        for(int None=0;None<5;None++){
            output[CurrX].replace(CurrY, CurrY+1, "#");

            if(Direct<4) CurrX--;
            else if(Direct>5) CurrX++;
            if(Direct==1||Direct==4||Direct==6) CurrY--;
            else if(Direct==3||Direct==5||Direct==8) CurrY++;
        }
        return output;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String Target = "teemo";
        String input = bfr.readLine();
        String[] inputToken = input.split(" ");
        int m = Integer.parseInt(inputToken[0]), n = Integer.parseInt(inputToken[1]);
        String[] ArrSearch = new String[m];
        StringBuilder[] output = new StringBuilder[m];
        for(int i=0;i<m;i++) {
            ArrSearch[i] = bfr.readLine().substring(0, n);
            output[i] =  new StringBuilder(ArrSearch[i]);
            ArrSearch[i] = ArrSearch[i].toLowerCase();
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-4>=0) {
                    if(j+4<n) if(checkTeemo(i,j,ArrSearch,Target,3)) checkingSharp(output,i,j,3);
                    if(j-4>=0) if(checkTeemo(i,j,ArrSearch,Target,1)) checkingSharp(output,i,j,1);
                    if(checkTeemo(i,j,ArrSearch,Target,2)) checkingSharp(output,i,j,2);
                }
                if(i+4<m) {
                    if(j+4<n) if(checkTeemo(i,j,ArrSearch,Target,8)) checkingSharp(output,i,j,8);
                    if(j-4>=0) if(checkTeemo(i,j,ArrSearch,Target,6)) checkingSharp(output,i,j,6);
                    if(checkTeemo(i,j,ArrSearch,Target,7)) checkingSharp(output,i,j,7);
                }
                if(j+4<n) if(checkTeemo(i,j,ArrSearch,Target,5)) checkingSharp(output,i,j,5);
                if(j-4>=0) if(checkTeemo(i,j,ArrSearch,Target,4)) checkingSharp(output,i,j,4);
            }
        }
        for(int i=0;i<m;i++) {
            bfw.write(output[i]+"");
            bfw.newLine();
        }
        bfw.flush();
        bfw.close();
        bfr.close();

    }
    
}
