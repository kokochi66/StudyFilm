package Island_of_Knowledge;

public class Island_of_Knowledge_1_areEquallyStrong {
	static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
		return Math.max(yourLeft, yourRight)==Math.max(friendsLeft, friendsRight)&&Math.min(yourLeft, yourRight)==Math.min(friendsLeft, friendsRight);
	}
	public static void main(String[] args) { 
		int a1=15,a2=10,b1=10,b2=15;
		System.out.println(areEquallyStrong(a1,a2,b1,b2));
	}

}
