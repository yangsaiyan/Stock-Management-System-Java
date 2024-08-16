import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class StockManagement {
	static UserInfo userInfo = new UserInfo();
	static String userName;
	
	//main method
	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to UTAR Best Electrical Store");
		System.out.print(getTime() + "\n");
		System.out.println("Members of Group 21 are: ");
		System.out.println("1. Lim Zi Yang");
		System.out.println("2. Yong Wei Bang\n");
		System.out.print("Enter your fullname: ");
		userName = scanner.nextLine(); //Request user to key in their name
		userInfo.setName(userName);
		System.out.println("\nWelcome " + userName);
		
		//Make a selection whether they want to add product or exit the program
		int select = -1;
		while(select != 0 || select != 1) {
			System.out.println("\n1. Add Product ");
			System.out.println("0. Exit ");
			System.out.print("Please select: ");
			select = scanner.nextInt();
			System.out.println();
		if(select == 1){
			select = -1;
			addProduct(products, scanner); //here
		}
		else if(select == 0) {
			System.out.println(userInfo.getUserId(userName));
			break;
		}
		}
		scanner.close();
	}
	
	//Enter number of product user want to enter
	public static int maximumNumber(Scanner scanner) {
		int maximumNumber = -1123;
		System.out.print("Please enter maximum number of products you wish to store: ");
		maximumNumber = scanner.nextInt();
		while(maximumNumber < 0) {
			System.out.println("Please enter positive number 0 or above");
			System.out.println("Please enter maximum number of products you wish to store: ");
			maximumNumber = scanner.nextInt();
		}
		return maximumNumber;
	}
	
	//Display the list of product and request input from user
	public static int displayProduct(ArrayList<Product> products, Scanner scanner){
		int index = 1;
		int choice;
		
		for(Product product : products) {
			System.out.println(index + ". " + product.getNameOfProduct());
			index++;
		}	
		System.out.print("Please select a product: ");
		choice = scanner.nextInt();
		return choice;
	}
	
	//Display the menu and request user to make a selection
	public static int displayMenu(Scanner scanner) {
		int choice;
		System.out.println("1. View products");
		System.out.println("2. Add stock");
		System.out.println("3. Deduct stock");
		System.out.println("4. Discontinue product");
		System.out.println("0. Exit");
		System.out.print("Please enter a menu option: ");
		choice = scanner.nextInt();
		System.out.println();
		return choice;
	}
	
	//Show list of product and request user to enter the quantity they want to add stock
	public static void addStock(ArrayList<Product> products, Scanner scanner) {
		int selectProduct;
		int addQuantity;
		int index = 1;
		
		for(Product product : products) {
			System.out.println(index + ". " + product.getNameOfProduct());
			index++;
		}
		
		System.out.print("Select a product you want add stock: ");
		selectProduct = scanner.nextInt();
		if(products.get(selectProduct - 1).getProductStatus() == true) {
		System.out.print("Add Quantity: ");
		addQuantity = scanner.nextInt();
		if(addQuantity < 0) {
			System.out.println("Please enter positive value greater than 0");
			while(addQuantity < 0) {
			System.out.print("Add Quantity: ");
			addQuantity = scanner.nextInt();
		}}
		products.get(selectProduct - 1).setAvailableStockQuantity(products.get(selectProduct - 1).getAvailableStockQuantity() + addQuantity);
		System.out.println("Current quantity: " + products.get(selectProduct - 1).getAvailableStockQuantity() + "\n");
		}else {
			System.out.println("The product you want to add has discontinued.\n");
		}
		doMenu(products, scanner);
	}
	
	//Show list of product and request user to enter the quantity they want to deduct stock
	public static void deductStock(ArrayList<Product> products, Scanner scanner) {	
		int selectProduct;
		int deductQuantity;
		int index = 1;	
		for(Product product : products) {
			System.out.println(index + ". " + product.getNameOfProduct());
			index++;
		}
		System.out.print("Select a product you want deduct stock: ");
		selectProduct = scanner.nextInt();
		System.out.println("Quantity: " + products.get(selectProduct - 1).getAvailableStockQuantity());
		System.out.print("Deduct Quantity: ");
		deductQuantity = scanner.nextInt();
		while(deductQuantity < 0 || deductQuantity > products.get(selectProduct - 1).getAvailableStockQuantity()) {
		if(deductQuantity < 0) {
			System.out.println("Please enter positive value greater than 0");
			System.out.print("Deduct Quantity: ");
			deductQuantity = scanner.nextInt();
		}else if(deductQuantity > products.get(selectProduct - 1).getAvailableStockQuantity()) {
			System.out.print("Please enter a value less than current quantity: ");
			deductQuantity = scanner.nextInt();
			System.out.println("Quantity: " + products.get(selectProduct - 1).getAvailableStockQuantity());
			}}
		products.get(selectProduct - 1).setAvailableStockQuantity(products.get(selectProduct - 1).getAvailableStockQuantity() - deductQuantity);
		System.out.println("Current quantity: " + products.get(selectProduct - 1).getAvailableStockQuantity() + "\n");
		doMenu(products, scanner);
	}
	
	//User select a product from selection and set it to discontinued which boolean = false
	public static void statusOfProduct(ArrayList<Product> products, Scanner scanner) {

		int selectProduct;
		int index = 1;
		for(Product product : products) {
			System.out.println(index + ". " + product.getNameOfProduct());
			index++;
		}
		
		System.out.print("Select a product you want to discontinue: ");
		selectProduct = scanner.nextInt();
		System.out.println();
		products.get(selectProduct - 1).setProductStatus(false);
		doMenu(products, scanner);
	}
	
	//Receive return from displayMenu and put it in Switch case and do different tasks
	public static void doMenu(ArrayList<Product> products, Scanner scanner) {
		switch(displayMenu(scanner)){
        case 1: 
        displayContent(products);
        break;
		case 2: 
		addStock(products, scanner);
		break;
		case 3: 
		deductStock(products, scanner);
		break;
		case 4: 
		statusOfProduct(products,scanner);
		break;
		case 0:
			System.out.print(userInfo.getUserId(userName));
			System.exit(0);
		default:
			System.out.println("Invalid Input");
		break;	
		}
		doMenu(products, scanner);
	}
	
	//To request user to select whether add TV or refrigerator
	public static void addProduct(ArrayList<Product> products, Scanner scanner) {
		int select = 0;
		while(select < 1 || select > 2) {	
			System.out.println("1. Refrigerator");
			System.out.println("2. TV");
			System.out.print("Please select a product: ");
			select = scanner.nextInt();
			if(select != 1 && select != 2) {System.out.println("\nOnly number 1 or 2 allowed!");}
		}
		if(select == 1) {
			int maxNum = maximumNumber(scanner);
			for(int i = 0; i < maxNum; i++) {
			addRefrigerator(products);
			}
		}
		else if(select == 2) {
			int maxNum = maximumNumber(scanner);
			for(int i = 0; i < maxNum; i++) {
			addTV(products);
			}
		}
		doMenu(products, scanner);
	}
	
	//Request user to key in information of refrigerator they want to add
	public static void addRefrigerator(ArrayList<Product> products) {	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the name of Refrigerator: ");
		String name = scanner.next();
		System.out.print("Please enter the door design of Refrigerator: ");
		String dDesign = scanner.next();
		System.out.print("Please enter the color of Refrigerator: ");
		String color = scanner.next();
		System.out.print("Please enter the capacity of Refrigerator (in Litres): ");
		int capacity  = scanner.nextInt();
		System.out.print("Please enter the quantity available in stock of Refrigerator: ");
		int quantity = scanner.nextInt();
		System.out.print("Please enter the price of Refrigerator (RM): ");
		double price = scanner.nextDouble();
		System.out.print("Please enter the item number of Refrigerator: ");
		int number = scanner.nextInt();		
		products.add(new Refrigerator(dDesign, color, capacity, name, price, quantity, number, true));	
		System.out.println();
	}
	
	//Request user to key in information of TV they want to add
	public static void addTV(ArrayList<Product> products) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the name of TV: ");
		String name = scanner.next();
		System.out.print("Please enter the screen type  of TV: ");
		String sType = scanner.next();
		System.out.print("Please enter the resolution  of TV: ");
		String resolution = scanner.next();
		System.out.print("Please enter the display size  of TV: ");
		String displaySize = scanner.next();
		System.out.print("Please enter the quantity  of TV: ");
		int quantity = scanner.nextInt();
		System.out.print("Please enter the price of TV (RM): ");
		double price = scanner.nextDouble();
		System.out.print("Please enter the item number of TV: ");
		int number = scanner.nextInt();
		products.add(new TV(sType, resolution, displaySize, name, price, quantity, number, true));
		System.out.println();
	}
	
	//Display the information of all existing products using toString
	public static void displayContent(ArrayList<Product> products) {
		for(Product product : products) {
			if (product instanceof Refrigerator) {
		        Refrigerator refrigerator = (Refrigerator) product;
		        System.out.println(refrigerator.toString()); 
		        System.out.println();
		    }
			if(product instanceof TV) {
				TV tv = (TV) product;
				System.out.println(tv.toString());
				System.out.println();
			}
		}
		Scanner scanner = new Scanner(System.in);
		doMenu(products, scanner);
	}
	
	//Get current date and time
	public static String getTime() {
        Calendar currentDateTime = Calendar.getInstance();
        return "Current date and time: " + currentDateTime.getTime();
	}
	
}
