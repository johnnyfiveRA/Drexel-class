/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week04arrays;

/**
 *
 * @author John White
 */

public class Week04Arrays 
{

    public static void main(String[] args) 
    {
    
        Person p1 = new Person();
        
        p1.setName("Gregory Safko");
        p1.setAge(23);
        p1.setEmail("sparky42@aol.com");
        
        Person p2 = new Person();
        
        p2.setName("Abraham Bonaparte");
        p2.setAge(375);
        p2.setEmail("ImmortalOne@thelordsservice.net");
        
        Person p3 = new Person();
        p3.getPersonData();       // grabs input for name, age and emal
        
        Person p4 = new Person();
        p4.setName("Some Dude");
        p4.setAge(12);
        p4.setEmail("thing@stuff.com");
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        Contacts addrBook = new Contacts();
        addrBook.addContact(p1);
        addrBook.addContact(p2);
        addrBook.addContact(p3);
        
        System.out.println(addrBook.find(p4)); // this will use the objects toString overridden method to print this
        // it's not found because this object was not added to the array
        addrBook.printAll();
        
    }
    
    
}
