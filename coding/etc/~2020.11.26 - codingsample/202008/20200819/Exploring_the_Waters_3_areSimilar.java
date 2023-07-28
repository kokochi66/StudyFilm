package Exploring_the_Waters;

public class Exploring_the_Waters_3_areSimilar {
	static boolean areSimilar(int[] a, int[] b) {
		if(a.length!=b.length) return false;
		int errpoint=-1,len=a.length;
		for(int i=0;i<len;i++) {
			if(a[i]!=b[i]) {
				if(errpoint!=-1) {
					if(errpoint==-2) return false;
					else if(a[i]==b[errpoint]&&a[errpoint]==b[i]) errpoint=-2;
					else return false;
				}
				else errpoint=i;
			}
		}
		if(errpoint>-1) return false;
		return true;
	}

	public static void main(String[] args) {
		int a[] = {1,2,3};
		int b[] = {3,2,3};
		System.out.println(areSimilar(a,b));
	}

}
