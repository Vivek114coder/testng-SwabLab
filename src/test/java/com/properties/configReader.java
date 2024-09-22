

package com.properties;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

   public class configReader {
	  Properties prop;
	  String propname;
	 
	public  Properties init_Element() {
		try {
			FileInputStream inputstream = new FileInputStream("C:\\Users\\vivek\\eclipse-workspace\\Swag_Lab2\\src\\main\\java\\config.properties");
			try {
				prop=new Properties();
				prop.load(inputstream);
				propname=prop.getProperty("browser");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return prop;
		
	}

	}

