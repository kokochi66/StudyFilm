package N6_Rains_of_Reason;

public class Rains_of_Reason_5_chessBoardCellColor {
	static boolean chessBoardCellColor(String cell1, String cell2) {
	    return (((cell1.charAt(0)%2)==(cell1.charAt(1)%2))==((cell2.charAt(0)%2)==(cell2.charAt(1)%2)));
	}
	public static void main(String[] args) {
		System.out.println(chessBoardCellColor("A3","C1"));
	}
}
