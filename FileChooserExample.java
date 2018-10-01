/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kartik
 */
import javax.swing.*;    
import java.awt.event.*;   
import java.io.FileWriter; 
import java.io.BufferedReader;    
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.io.File;
public class FileChooserExample {    
 public static char p[] ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
							'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
							'0','1','2','3','4','5','6','7','8','9',':','$','!','@','\n',' '};
    public static char ch[]={'A','M','f','S','u','R','w','b','X','o','T','n','t','x','g','z','K','F','m','d','e','p','l','a','r','h',
							'B','L','9','8','k','C','H','I','7','4','$','J','s','!','O','y','@','1','6','c','i','W','N','q','G','j','v','D','V','Y','E','Q',':','U','Z','P','3','2','5','0','\n',' '};

							
							
    public static String encryption(String s)
    {
        char c[]=new char[(s.length())];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<66;j++)
            {
                if(p[j]==s.charAt(i))
                {
                    c[i]=ch[j];
                    break;
                }
            }
        }
        return(new String(c));
    }
    


							
							//Encryption method to encrypt the text of file 
 public static void encryptTextFile(String filePath, String encFilePath)
    {	
	BufferedReader reader;
  		try{
	        //FileInputStream fin=new FileInputStream(filePath);    
			reader = new BufferedReader( new FileReader(filePath));
			FileWriter fwriter = new FileWriter(encFilePath);
			//writer = new BufferedWriter(fwriter);//
		    String line=reader.readLine();    
	        while((line!=null)){  
			fwriter.write(encryption(line));
			line=reader.readLine();
            }
			fwriter.close();
			reader.close();	
			File file1= new File(filePath);
			File file=file1;
			File file2=new File(encFilePath);
			file1.delete();
			file2.renameTo(file);
		}
		catch(Exception e){
			System.out.print(e);
		}
    }
//encryptTextFile() method end
  public static void main(String s[]) {
    JFileChooser chooser1 = new JFileChooser();
	JFileChooser chooser2 = new JFileChooser();
    chooser1.setCurrentDirectory(new java.io.File("."));
    chooser1.setDialogTitle("Select file to encrypt:");
	chooser2.setDialogTitle("Set Destination");
		System.out.println("Enter the path of the file to be encrypted: ");
		String path="";
		StringBuilder encFileName = new StringBuilder("Encrypted_");
		StringBuilder encFilePath = new StringBuilder();		
		File f;
    chooser1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    chooser1.setAcceptAllFileFilterUsed(false);
	chooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser2.setAcceptAllFileFilterUsed(false);
	
	
    if (chooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      System.out.println("Path : " + chooser1.getSelectedFile());
      path=chooser1.getSelectedFile().toString();
      encFileName.append(chooser1.getSelectedFile().getName().toString());
    }
	else {
      System.out.println("No Selection ");
    }	
    f= new File(path);
	if(f.exists()){
		chooser2.setCurrentDirectory(new java.io.File(path));
		if (chooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        System.out.println("Path : " + chooser2.getSelectedFile());
		encFilePath.append(chooser2.getSelectedFile().toString());
		encFilePath.append("/");
		encFilePath.append(encFileName.toString());
		encryptTextFile(path,encFilePath.toString());
		}
		else {
		  System.out.println("No Selection ");
		}
	}
	else{
		System.out.println("Invalid path");
	}    
  }
}
 
 