package com.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient {
	
	public static void main(String args[]) {
		
	
	Client client=ClientBuilder.newClient();
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
	WebTarget target=client.target("http://localhost:2018/RestCURDApp/rest");
	//calling save operation
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
	target=target.path("/BookService/save");
	System.out.println("###########################");
	Book book =new Book(101,"oracle",800);
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
	String str=(String)target.request().put(Entity.json(book),String.class);
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
	//String str=(String)target.request().get(String.class);
	//Response response=target.request().get();
	//String str=(String)response.readEntity(String.class);
	System.out.println(str);
	System.out.println("=======================");
	
	//calling find operation
	WebTarget target1=client.target("http://localhost:2018/RestCURDApp/rest");
	target1=target1.path("/BookService/find{id}").resolveTemplate("id", 101);
	Book book1=(Book)target1.request().get(Book.class);
	if(book1!=null)
	{
		System.out.println("Details of book 101 .");
		System.out.println(book1.getBookName());
		System.out.println(book1.getPrice());
	}
	System.out.println("==========================");
	
	//calling delete operation
	
	WebTarget target2=client.target("http://localhost:2018/RestCURDApp/rest");
	target2=target2.path("/BookService/delete{id}").resolveTemplate("id", 103);
	String str2=(String)target2.request().delete(String.class);
	System.out.println(str2);
	}

}
