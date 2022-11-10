/**
 *
 * @author kharileigh
 * 
 */

package com.teamsix.book.client;

import com.teamsix.book.presentation.BookPresentation;
import com.teamsix.book.presentation.BookPresentationImpl;

import java.util.Scanner;

public class BookSpringFramework {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        BookPresentation bookPresentation = new BookPresentationImpl();
        
        while(true) {
            
            bookPresentation.showMenu();
            System.out.println("Enter Your Selection : ");
            
            int userChoice = sc.nextInt();
            bookPresentation.performMenu(userChoice);
        }
    }
}

