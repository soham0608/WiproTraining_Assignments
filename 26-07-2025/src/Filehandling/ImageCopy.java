package Filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ImageCopy {

	public static void main(String[] args) throws Exception {
		
		FileInputStream in = null;
		FileOutputStream out = null ; 
		
		try 
		{
			in = new FileInputStream("D:\\CarImg.jpg");
			out = new FileOutputStream("D:\\copy.jpg");
			
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		byte[] buffer = new byte[1024]; 
        int bytesRead;

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        
        in.close();
        out.close();
        
        System.out.println("Image copied successfully.");
	}
}
