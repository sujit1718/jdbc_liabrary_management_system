package jdbc_liabrary_management_system;

import java.util.Scanner;

public class UserBookMain {

	public static void main(String[] args) throws Exception {
		
          Scanner scanner = new Scanner(System.in);
		
        while(true) {
		System.out.println("Welcome!!! \n1.SignUp \n2.LogIn \n3.Exit");
		int choise = scanner.nextInt();
		if(choise == 3) {
			System.out.println("Thank for Visit!");
			return;
		}
		UserCRUD crud = new UserCRUD();
		User user = new User();
		switch (choise) {
		case 1: {
			System.out.println("Enter the Id : ");
			int id = scanner.nextInt();
			System.out.println("Enter the Name : ");
			String name = scanner.next();
			System.out.println("Enter the Phone Number : ");
			long phone = scanner.nextLong();
			System.out.println("Enter the Email : ");
			String email = scanner.next();
			System.out.println("Enter the Password : ");
			String password = scanner.next();
			
			
			user.setId(id);
			user.setEmail(email);
			user.setName(name);
			user.setPhone(phone);
			user.setPassword(password);
			int result = crud.signUpUser(user);
			
			if (result!=0) {
				System.out.println("SignUp SuccessFul");
			} else {
                 System.out.println("SignUp not SuccessFul");
			}
			break;
	    }
		case 2: {
			System.out.println("Enter the email : ");
			String email = scanner.next();
			System.out.println("Enter the password : ");
			String password = scanner.next();
			String dbpassword = crud.loginUser(email);
			if(dbpassword!=null) {
				if(dbpassword.equals(password)) {
					System.out.println("Login success! \n");
					
					System.out.println("1. Add Book \n2. Find Book by Id \n3. Find book by author \n4. Find book by name \n5. Delete book by id \n6. Delete book by name \n7. Update book by Id \n8. LogOut");
					System.out.println("Enter your choise");
					int num = scanner.nextInt();
					Book book = new Book();
					switch (num) {
					case 1:{
						System.out.println("Enter the Id : ");
						int id = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter the Name : ");
						String name = scanner.nextLine();
						System.out.println("Enter the Author : ");
						String author = scanner.nextLine();
						System.out.println("Enter the Genre : ");
						String genre = scanner.nextLine();
						
						book.setId(id);
						book.setName(name);
						book.setAuthor(author);
						book.setGenre(genre);
						
						int result = crud.addBook(book);
						if(result!=0) {
							System.out.println("Book Added Successfully!");
						}
						else {
							System.out.println("Book Not Added!");
						}
						break;
					}
                    case 2:{
						
						break;
					}
                    case 3:{
						
						break;
					}
                    case 4:{
						
						break;
					}
                    case 5:{
						
						break;
					}
                    case 6:{
						
						break;
					}
                    case 7:{
						
						break;
					}
                    case 8:{
						
						break;
					}
                    
					default:{
						System.out.println("Invalid Choise");
						break;
					}
				  }
		         }
				else {
					System.out.println("Login not successful");
				}
             }
			break;
         }
   }
  }
	}
}      
