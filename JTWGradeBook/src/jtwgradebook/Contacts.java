/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtwgradebook;

/**
 *
 * @author Instructor provided library
 */
import java.util.ArrayList;

public class Contacts {
	
	// Collects can hold any type of object, but its best to tell
	// Java what type of object it will be.  To do that put the
	// class name in angle brackets right after the collection type.
	// In this case we will have an ArrayList that holds objects of type
	// Person (same as the Person class used in week 3).
    
	private ArrayList<Person> contacts = new ArrayList<Person>();
	
	public void addContact( Person newPerson ){
		// To add an element to an ArrayList simply call the add method.
		// With array list, you don't have to worry about the size.
		contacts.add(newPerson);
	}
	
	public int find( Person person ){
		// Find the index of a given object.
		// indexOf returns -1 if not found
		return contacts.indexOf(person);
	}
	
	public void delete( Person person ){
		// simply use remove to delete an element from the list
		// There is also a remove method that removes based on index
		contacts.remove(person);
	}
	
	public void deleteAll(){
		// ArrayList's clear method removes all elements from the list.
		contacts.clear();
	}
	
	public void printAll(){
		// Use size() to get the number of elements in the list.
		for( int i=0; i<contacts.size(); i++){
			Person contact = contacts.get(i);
			System.out.println("\n" + contact.toString() );
		}
	}
}
