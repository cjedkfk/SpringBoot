package com.example.demo;

import org.springframework.data.annotation.Id;


public class MyDataMongo {
	@Id
	
	private String id;
 	
	private String area;
	private String name;
	private String address;
	private String tel;
	
	public MyDataMongo(String area, String name, String address, String tel) 
	{
        super();
        this.area = area;
        this.name = name;
        this.address = address;
        this.tel = tel;
	}
   
    public String getId() 
    {
        return id;
    }
    public String getArea() 
    {
        return area;
    }
    public String getName() 
    {
        return name;
    }

    public String getAddress() 
    {
        return address;
    }

    public String getTel() 
    {
        return tel;
    }

    
}