/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloNameJTW;

/**
 *
 * @author John White
 */

import java.util.Scanner;

public class HelloNameJTW {

    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String name;
        int age;
        
        System.out.println("Hello again world");
        
        System.out.println("So what's your name buddy");
        name= input.nextLine();
        
        System.out.println("Awesome job " + name + ", how old are you");
        age = input.nextInt();
        
        System.out.println("Great so your name is, " + name + " and you are " + age + " year(s) old");
    }
}
