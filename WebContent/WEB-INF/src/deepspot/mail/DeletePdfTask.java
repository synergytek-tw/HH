package deepspot.mail;

import java.io.File;
import java.util.TimerTask;
import deepspot.util.Util;

public class DeletePdfTask extends TimerTask {

	public void run() {
		File f = new File(Util.getPdfPath());
		if(f.exists()){
			File[] fileList = f.listFiles();
			for(int i=0;i<fileList.length;i++){
				fileList[i].delete();
				System.out.println(fileList[i]+" is delete.");
			}
		}	
	}
	
}