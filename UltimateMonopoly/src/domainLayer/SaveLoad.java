package domainLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uiLayer.AppWindow;

public class SaveLoad  implements Serializable{
	String saveFile="1";
	transient ObjectOutputStream oos;
	
	public SaveLoad(int fileNum) {
		saveFile=fileNum+"";
		
	}
	
	public void setSaveFile(int i) {
		saveFile=i+"";
	}
	
	public void save(AppWindow apw) {
		oos=null;
		try {
			oos= new ObjectOutputStream(new FileOutputStream("saveFiles/save"+saveFile));
			oos.writeObject(apw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				System.out.println("Save complete of file no: "+ saveFile +". OOS closed.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

}
