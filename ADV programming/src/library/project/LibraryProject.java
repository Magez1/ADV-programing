/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.project;

 import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
        
public class LibraryProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter library capacity: ");
        int capacity = scanner.nextInt();
        Library library = new Library(capacity);
        library.run();
    }
}
