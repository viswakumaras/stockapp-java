package stock;

import java.util.ArrayList;

public class OrderItem {
   static String Name;
	static String itemName;
	static int price;
	static int quantity;
	static String category;
	static ArrayList<String> bookedOrders=new  ArrayList<String>();
	static int i=0;
	public  OrderItem(String item ,String cate ,int pr){
	
		OrderItem.itemName=item;
		OrderItem.price=pr;
		OrderItem.category=cate;
		
	} 
	
	public void display() {
		System.out.println("Item Name --"+itemName);
		System.out.println("Price --"+price);
		System.out.println("category---"+category);
		
	}
	


	
	
}
