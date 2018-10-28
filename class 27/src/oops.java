import java.util.Arrays;
public class oops {

	public static void main(String[] args) {

//				Person p1 = new Person();
//				p1.name = "A";
//				p1.age = 10;
//				p1.saysHi();
//				
//				Person p2 = p1;
//				p2.age = 20;
//				p2.name = "B";
//				
//				p2.saysHi();
//				p1.saysHi();
				
//				Person p1 = new Person();
//				p1.age = 10;
//				p1.name = "A";
//				Person p2 = new Person();
//				p2.age = 20;
//				p2.name = "B";
//				
//				p1.saysHi();
//				p2.saysHi();
//				swap1(p1, p2);
//				swap2(p1, p2);
//				p1.saysHi();
//				p2.saysHi();
				
				Person[] persons = new Person[5];
				persons[0] = new Person();
				persons[0].age = 10;
				persons[0].name = "A";
				
				persons[1] = new Person();
				persons[1].age = 30;
				persons[1].name = "C";
				
				persons[2] = new Person();
				persons[2].age = 20;
				persons[2].name = "B";
				
				persons[3] = new Person();
				persons[3].age = 50;
				persons[3].name = "E";
				
				persons[4] = new Person();
				persons[4].age = 40;
				persons[4].name = "D";
				
				for(Person p: persons){
					p.saysHi();
				}
				
				Arrays.sort(persons);
				
				System.out.println("--------------------------------");
				for(Person p: persons){
					p.saysHi();
				}
				
			}
			
			public static void swap2(Person p1, Person p2){
				int tage = p1.age;
				p1.age = p2.age;
				p2.age = tage;
				
				String tname = p1.name;
				p1.name = p2.name;
				p2.name = tname;
			}
			
			public static void swap1(Person p1, Person p2){
				Person temp = p1;
				p1 = p2;
				p2 = temp;
			}

}
