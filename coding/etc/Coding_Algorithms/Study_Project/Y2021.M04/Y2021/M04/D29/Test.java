package Y2021.M04.D29;

public class Test {
		static class Person {
			String name;
			int age;
			public Person(String s, int a) {
				this.name = s;
				this.age =a ;
			}
		}
		static class AppleSeller extends Person {

			public AppleSeller(String s, int a) {
				super(s,a);
			}
			
		}
}
