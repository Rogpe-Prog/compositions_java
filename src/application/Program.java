package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDay = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDay); //client
		
		System.out.println();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		
		OrderStatus status = OrderStatus.valueOf(sc.next()); //OrderStatus
		
		Order order = new Order(new Date(), status, client); //order
		
		
		System.out.print("How many items to this order? ");
		int manyOrders = sc.nextInt();
		
		for (int i = 0; i < manyOrders; i++) {
			System.out.println("Enter #" + (1 + i) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);	//product		
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product); //OrderItem
			
			order.addItem(orderItem);// add Order
		}
		
		
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		

		sc.close();
	}

}
