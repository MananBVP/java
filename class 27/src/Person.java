		public class Person implements Comparable<Person> {
			String name;
			int age;
			
			public void saysHi(){
				System.out.println(this.name + " [" + this.age + "] says hi");
			}

			public int compareTo(Person o) {
				// TODO Auto-generated method stub
				return this.age - o.age;
			}
	}

