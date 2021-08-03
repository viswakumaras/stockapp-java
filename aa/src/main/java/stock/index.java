package stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class index {

	static	 ArrayList<stocks> stock=new ArrayList<stocks>();
	 static boolean au=false;
	 
	 static ArrayList<booked> orderPlaced=new ArrayList<booked>();
  static ArrayList<OrderItem> order=new ArrayList<OrderItem>();
  static ArrayList<users> user=new ArrayList<users>();

  static Scanner sc= new Scanner(System.in);

  static users u1=new users("admin","admin123","Admin");
  static users u2=new users("Kumar","kumar93","Customer");
  static users u3=new users("Praveen","prince","Customer");
  static String logInUser="";
  static String roleOf="";
  
  public static void loginValidation() {
	   System.out.println("Enter your name");
	   String userName=sc.next();
	   System.out.println("Enter you password");
	   String password=sc.next();
	   user.add(u1);
	   user.add(u2);
	   user.add(u3);
	  
	   for(users x:user) {
			  
		     
		   if(x.name.equalsIgnoreCase(userName) && x.password.equalsIgnoreCase(password)) {
			   au=true;
			   roleOf =x.role;
			   logInUser=x.name;
		   }
	   }
	   
	   try {
		   if(au) {
			   
			   if(roleOf.equalsIgnoreCase("customer"))
			   {
				   
			   System.out.println("welcome  "+logInUser);
			       getChoice();
			   }
			   else {
				   System.out.println("welcome admin");
				   stocks.adminDisplay();
				   
			   }
		   }
		   else {
			   throw new Exception();
		   }
	   }
	   catch(Exception e) {
		   System.out.println("invalid ");
		   loginValidation();
	   }
		
  }

  
  public static void getChoice() {
	 
	   System.out.println("1.To Place Order ");
	   System.out.println("2.View order history ");
	   System.out.println("3. logout");
	   int ch=sc.nextInt();
	   switch(ch) {
	   
	   case 1:{
		   sc.nextLine();
		  
		   System.out.println("The orders");
		   for(stocks x:stock) {
			  x.display();
		   }
		   
		   System.out.println("Enter stock ID  ");
		   int si=sc.nextInt();
		   System.out.println("enter quantity");
		   int quantity=sc.nextInt();
		   
		   for(stocks x:stock) {
			   
			   if(x.si == si) {
				 
				   x.available= x.available-quantity;  
				
				   OrderItem t=new OrderItem(x.itemName,x.category,x.price);
				  
				   booked t1=new booked(logInUser,x.itemName,x.category,x.price);
				   
				   //just to show picked items
				   order.add(t);
   
				   
				   //this is for loggedin user's cart
				   orderPlaced.add(t1);
				   
				   
				   System.out.println("items");
				   
				   
				   for(OrderItem x1:order) {
					   
					   x1.display();
					   
				   }
				   
				   System.out.println(" ");
				   
				   System.out.println( logInUser+"'s Cart");
				
				   
				   for(booked x2:orderPlaced) {
					   System.out.println(" ");
					  x2.display();
				   }
				  
			   }
		   }
		   System.out.println(" ");
		   getChoice();
		   break;
	   }
	   case 2:{
		   sc.nextLine();

		   System.out.println(" ");
		   System.out.println("The placed orders");
		   
		   for(booked x:orderPlaced) {
			   x.display();
		   }
		   getChoice();
		   break;
	   }
	   case 3:{
		   logInUser="";
		  loginValidation();
		   break;
	   }
	   case 4:{
		   System.out.println("Enter to update stocks");
		   System.out.println("Enter item ID");
		   int si=sc.nextInt();
		   System.out.println("Enter item Name");
		   String item=sc.next();
		   System.out.println("Enter item category");
		   String cate=sc.next();
		   System.out.println("Enter item price");
		   int price=sc.nextInt();
		   System.out.println("Enter item availability");
		   int availabe=sc.nextInt();
		  
		   stocks s5=new stocks(si,item,cate,price,availabe);
		   
		   stock.add(s5);
		   
		   System.out.println("successfully added to stocks");
		   getChoice();
		   break;
	   }
	   default:{
		   System.out.println("wrong choice");
		   getChoice();
	   }
  }
  
  }
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
	
		
		
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("C:\\Users\\viswa\\eclipse-workspace\\aa\\src\\main\\java\\stock\\data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray stocklist = (JSONArray) obj;
            
         
            //Iterate over employee array
            stocklist.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
         
            
           
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        loginValidation();
    }
	
	
 
    @SuppressWarnings("unchecked")
	public static void parseEmployeeObject(JSONObject employee) 
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("stocks");
        employeeObject.put("quantity","15");
         
        //Get employee first name
        String name = (String) employeeObject.get("name");    
      
         
      //  Get employee last name
        String type = (String) employeeObject.get("type");  
     
        
        String q = (String) employeeObject.get("quantity"); 
        
        String price = (String) employeeObject.get("price"); 
        
        String id = (String) employeeObject.get("id"); 
       
        
        int i=Integer.parseInt(id);
    //   System.out.println(i);
        int qu=Integer.parseInt(q);
   
        int p=Integer.parseInt(price);
   
        stocks s1= new stocks(i,name,type,p,qu);
        
        
         stock.add(s1);
     
    }
}

	
