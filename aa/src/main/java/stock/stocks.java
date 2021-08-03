package stock;

import java.util.ArrayList;
import java.util.Scanner;

public class stocks { 
	 String itemName;
	 String category;
	 int price;
	 int available;
	 int si;
	static Scanner sc=new Scanner(System.in);
	ArrayList<String> orders=new ArrayList<String>();
	public stocks(int si,String itemName,String category,int price,int available){
		this.si=si;
		this.available=available;
		this.category=category;
		this.itemName=itemName;
		this.price=price;
	}
	
	public  void display() {
		System.out.println("");
		System.out.println("Product ID :"+si);
		System.out.println("Name  -"+itemName);
		System.out.println("category  -"+category);
		System.out.println("price  --"+price);
		System.out.println("Quantity available --"+available);
	}
	public static void adminDisplay() {
		
	}
}
