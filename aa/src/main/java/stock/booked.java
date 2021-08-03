package stock;

import java.util.ArrayList;

public class booked {
	
	ArrayList<String> orders=new ArrayList<String>();
	
	 String name;
	 int size=orders.size();
	 
	public booked(String logInUser, String item,String cate,int price) {
		
		
		orders.add(item);
	
		
	}

   


	public  void display() {
		
		for(String order:orders) {
			System.out.println(order);
		}
		
		
	}


}
