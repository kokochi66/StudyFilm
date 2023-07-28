package Island_of_Knowledge;

public class Island_of_Knowledge_3_isIPv4Address {
	
	
	static boolean isIPv4Address(String inputString) {
		String[] output = inputString.split("[.]");
		int temp=0;
		if(output.length!=4) return false;
		for(int i=0;i<output.length;i++) {
			temp=0;
			if(output[i].isEmpty()) return false;
			for(int j=0;j<output[i].length();j++) {
				if(output[i].charAt(j)-48<0||output[i].charAt(j)-48>9) return false;
				else if(output[i].charAt(j)-48==0&&output[i].length()!=1) return false;
				else {
					temp*=10;
					temp+=output[i].charAt(j)-48;
					if(temp>255) return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "172.316.254.1";
		System.out.println(isIPv4Address(input));

	}

}
