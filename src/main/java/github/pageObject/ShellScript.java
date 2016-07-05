package github.pageObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.crypto.CipherInputStream;

import org.testng.Assert;

public class ShellScript {
	String conflictCheck="";
	String pushCheck="";
	public void scripting(String url, String repoName) {
		
		try {
			String filename1=null;
			String filename2=null;
			if(System.getProperty("os.name").contains("Linux")){	
				filename1="myscript1.sh";
				filename2="myscript2.sh";

			}
			
else if (System.getProperty("os.name").contains("Windows")) {
	filename1="myscript1.bat";
	filename2="myscript2.bat";

			}
			BufferedReader br=new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+filename1));
			BufferedWriter bw=new BufferedWriter( new FileWriter(System.getProperty("user.dir")+File.separator+filename2));

			String i;
		 	while((i=br.readLine())!=null){

		 		if(i.contains("$cloneURL"))
		 		{
		 			bw.write(i.toString().replace("$cloneURL", url+"\n"));
		 		}
		 			else if (i.contains("$repoName"))
		 			{
					bw.write(i.toString().replace("$repoName",repoName+"\n"));	
					}
		 			else
		 			{
		 				bw.write(i+"\n");
		 			}
				
		 	}
		 	bw.close();
		 	
			BufferedReader bw1=new BufferedReader( new FileReader(System.getProperty("user.dir")+File.separator+filename2));
			while((i=bw1.readLine())!=null){
		 		System.out.println(i);
		 		
		 	}
			
		
			
			Process process = Runtime.getRuntime().exec("chmod +x "+System.getProperty("user.dir")+File.separator+filename2);
			ProcessBuilder pb = new ProcessBuilder(System.getProperty("user.dir")+File.separator+filename2);
		 	Process p = pb.start();
		 	
//		 	pb.environment().put("cloneURL", url);
//		 	pb.environment().put("repoName", repoName);
		 	BufferedReader stdInput = new BufferedReader(new 
		 		     InputStreamReader(p.getInputStream()));

		 		BufferedReader stdError = new BufferedReader(new 
		 		     InputStreamReader(p.getErrorStream()));

		 		// read the output from the command
		 		System.out.println("Here is the standard output of the command:\n");
		 		String s = null;
		 		
		 		while ((s = stdInput.readLine()) != null) {
		 		    conflictCheck+=s;		 
		 		    pushCheck+=s;
		 			System.out.println(s);
		 		}
		 		
		 		// read any errors from the attempted command
		 	
		 		while ((s = stdError.readLine()) != null) {
		 		    System.out.println(s);
		 		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void conflictChecking()
	{
		if((conflictCheck.contains("conflict"))||(conflictCheck.contains("Conflict")))
		{
			Assert.assertEquals(false, true);
		}
		else {
			Assert.assertEquals(true, true);

		}
	}
	void verifyPushPerformed()
	{
		if(pushCheck.contains("Everything up-to-date"))
		{
			Assert.assertEquals(false, true);
		}
		else {
			Assert.assertEquals(true, true);

		}
	}
}
