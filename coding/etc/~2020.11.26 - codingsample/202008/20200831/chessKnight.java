package javaSpeedcoding;

public class chessKnight {
	int chessKnight(String cell) {
	    Boolean checkup = false, checkup2 = false;
	    Boolean checkside = false, checkside2 = false;
	    if(cell.charAt(0)=='b' || cell.charAt(0)=='g') checkside = true;
	    else if(cell.charAt(0)=='a' || cell.charAt(0)=='h') checkside2 = true;
	    if(cell.charAt(1)=='2' || cell.charAt(1)=='7') checkup = true;
	    else if(cell.charAt(1)=='1' || cell.charAt(1)=='8') checkup2 = true;
	    if(checkside2&&checkup2) return 2;
	    else if(checkside2&&checkup||checkside&&checkup2) return 3;
	    else if(checkside2||checkup2||checkside&&checkup) return 4;
	    else if(checkside||checkup) return 6;
	    return 8;
	}
}
