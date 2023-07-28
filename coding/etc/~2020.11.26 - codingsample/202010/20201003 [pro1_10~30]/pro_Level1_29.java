public class pro_Level1_29 {
    public static String solution(int[] numbers, String hand) {
        String output = "";
        int Lx = 3, Ly = 0;
        int Rx = 3, Ry = 2;
        int CostL, CostR, Cost;
        for(int i : numbers){
            if(i==1 || i==4 || i==7){
                output += "L";
                Lx = i/3;
                Ly = 0;
            }
            else if(i==3 || i==6 || i==9){
                output += "R";
                Rx = (i-1)/3;
                Ry = 2;
            }
            else {
                if(i==0) Cost = 3;
                else Cost = i/3;
                CostL = Math.abs(Lx - Cost) + Math.abs(Ly - 1);
                CostR = Math.abs(Rx - Cost) + Math.abs(Ry - 1);
                if(CostL<CostR || (CostL==CostR && hand.equals("left"))) {
                    output += "L";
                    Lx = Cost;
                    Ly = 1;
                }
                else if(CostL>CostR || (CostL==CostR && hand.equals("right"))) {
                    output += "R";
                    Rx = Cost;
                    Ry = 1;
                }
            }
        }
        return output;
    }
}
