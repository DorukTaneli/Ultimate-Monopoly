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
	transient ObjectInputStream ois=null;
	
	public LoadSave(int fileNum) {
		saveFile=fileNum+"";
		
	}
	
	public void setSaveFile(int i) {
		saveFile=i+"";
	}
	
	public DomainController load(int i) {
		DomainController apw = null;
		setSaveFile(i);
		try {
			ois= new ObjectInputStream(new FileInputStream("saveFiles/save"+saveFile));
			try {
				apw = (DomainController)ois.readObject();
				System.out.println("Read complete. apw is not null: "+apw);
				ois.close();
				return apw;
				
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
				//ois.reset();
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
