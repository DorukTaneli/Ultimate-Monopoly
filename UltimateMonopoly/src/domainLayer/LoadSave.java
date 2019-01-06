package domainLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uiLayer.AppWindow;

public class LoadSave  implements Serializable{
	String saveFile="1";
	transient ObjectInputStream ois;
	
	public LoadSave(int fileNum) {
		saveFile=fileNum+"";
		
	}
	
	public void setSaveFile(int i) {
		saveFile=i+"";
	}
	
	public AppWindow load(int i) {
		AppWindow apw=null;
		setSaveFile(i);
		ois=null;
		try {
			ois= new ObjectInputStream(new FileInputStream("saveFiles/save"+saveFile));
			try {
				apw = (AppWindow)ois.readObject();
				
			} catch (ClassNotFoundException e) {
				System.out.println("Error with load.");
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
				System.out.println("Load complete of file no: "+saveFile+". OIS closed.");
				return apw;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return apw;
	}
	

}
