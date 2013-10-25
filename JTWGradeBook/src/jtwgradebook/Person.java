
package jtwgradebook;

import java.util.Scanner;

/*
 * Instructor provided library
 */

public class Person {

	private String name;
	private int age;
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void getPersonData(){
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter the person's name: ");
		name = reader.nextLine();
		
		System.out.print("Enter the person's age: ");
		age = reader.nextInt();
		reader.nextLine();
		
		System.out.print("Enter the person's email: ");
		email = reader.nextLine();
	}

        @Override // @override added by JTW for the following overidden method
	public String toString(){
		return "Name: " + name + "\nAge: " + age + "\nemail: " + email;
	}
}