package LibraryManagement;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Manager{
    
    private static List<Books> book = new ArrayList<Books>();

    public static void addBook(String name, String author, int ISBN){
        for(Books b : book){
            if(b.getISBN()==ISBN){
                System.out.println("Book already exists!");
                return;
            }
        }
        book.add(new Books(name, author, ISBN, false));
        System.out.println("Book added successfully!");
    }

    public static void viewBooks(){
        if(book.isEmpty()){
            System.out.println("No books available.");
        }
        else{
            System.out.println("Srl.\t\tTitle\t\tAuthor\t\tISBN\t\tIs Borrowed?");
            int srl=1;
            for(Books b : book){
                System.out.println(srl+b.toString());
                srl++;
            }
        }
    }

    public static void searchBook(String titleOrAuthor){
        boolean bookFound=false;
        for(Books b : book){
            if(b.getTitle().contains(titleOrAuthor) || b.getAuthor().contains(titleOrAuthor)){
                bookFound=true;
                System.out.println("Book is available.");
                System.out.println(b.toString());
            }
        }
        if(!bookFound)
        {
            System.out.println("No match found.");
        }
    }

    public static void borrowBook(int ISBN){
        boolean bookFound=false;
        for(Books b : book){
            if(b.getISBN()==ISBN){
                bookFound=true;
                if(b.getIsBorrowed()==false){
                    System.out.println("Book name : " + b.getTitle() + " has been successfully borrowed");
                    b.setIsBorrowed(true);
                }
                else{
                    System.out.println("Book has already been borrowed.");
                }
                break;
            }
        }
        if(!bookFound){
            System.out.println("Book isn't available yet in the store.");
        }
    }

    public static void returnBook(int ISBN){
        boolean bookFound=false;
        for(Books b : book){
            if(b.getISBN()==ISBN){
                bookFound=true;
                if(b.getIsBorrowed()==true){
                    System.out.println("Book name : " + b.getTitle() + " has been returned.");
                    b.setIsBorrowed(false);
                }
                else{
                    System.out.println("Book has not been borrowed.");
                }

                break;
            }
        }
        if(!bookFound){
            System.out.println("Book wasn't found.");
        }
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean exit=false;
        
        do{
            try{
                System.out.println();
                System.out.println();
                System.out.println("-".repeat(65));
                System.out.println("\t\tLIBRARY MANAGEMENT SYSTEM");
                System.out.println("-".repeat(65));
                System.out.println("Enter your choice:");
                System.out.println("1. View Books");
                System.out.println("2. Add Books");
                System.out.println("3. Search Books");
                System.out.println("4. Borrow Books");
                System.out.println("5. Return Books");
                System.out.println("6. Exit");
                System.err.print("Choice: ");

                choice=sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1 -> viewBooks();
                    case 2 -> {
                        System.out.println("Enter book title:");
                        String title = sc.nextLine();
                        System.out.println("Enter author name:");
                        String author = sc.nextLine();
                        System.out.println("Enter ISBN");
                        int ISBN = sc.nextInt();
                        addBook(title, author, ISBN);
                    }
                    case 3 -> {
                        if(book.isEmpty()){
                            System.out.println("List is empty.");
                        }
                        else{
                        System.out.println("Enter book title or author name:");
                        String titleOrAuthor=sc.nextLine();
                        searchBook(titleOrAuthor);
                        }
                    }
                    case 4 -> {
                        if(book.isEmpty()){
                            System.out.println("List is empty.");
                        }
                        else{
                        System.out.println("Enter ISBN number for borrow:");
                        int ISBN = sc.nextInt();
                        borrowBook(ISBN);
                        }
                    }
                    case 5 -> {
                        if(book.isEmpty()){
                            System.out.println("List is empty.");
                        }
                        else{
                        System.out.println("Enter ISBN number for return:");
                        int ISBN = sc.nextInt();
                        returnBook(ISBN);
                        }
                    }
                    case 6 -> {
                        System.out.println("Exiting Library Management System...");
                        Thread.sleep(2000);
                        System.out.println("Goodbye!!");
                        exit=true;
                    }
                    default -> System.out.println("Please enter a valid choice");
                }
            }
            catch(Exception e){
                System.out.println("Please enter a numeric choice.");
                sc.nextLine();
            }
        }
        while(exit==false);

        sc.close();
    }

}