package lombok;

import java.util.Date;

@Getter
@Setter
public class Person {

	private String name;
	private int age;
	private char gender;
	private double Salary;
	private boolean isVote;
	private boolean isMarried;
	private Date dob;
	
	public static void main(String[] args) {
		Person p=new Person();
	}

}
