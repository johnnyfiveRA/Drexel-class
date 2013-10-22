/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week04arrays;

/**
 * Instructor provided class for interaction
 * @author Gregory Safko 
 */
import java.util.Scanner;

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
	
	public void getPersonData() {
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter the person's name: ");
		name = reader.nextLine();
		
		System.out.print("Enter the person's age: ");
		age = reader.nextInt();
		reader.nextLine();
		
		System.out.print("Enter the person's email: ");
		email = reader.nextLine();
	}
	
        @Override // the toString method is overwritten notation added to make this clear by JTW
	public String toString() {
		return "Name: " + name + "\nAge: " + age + "\nemail: " + email;
	}
}
