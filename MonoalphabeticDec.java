import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.File;
public class MonoalphabeticDec
{
 public static char p[] ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
							'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
							'0','1','2','3','4','5','6','7','8','9',':','$','!','@','\n',' '};
    public static char ch[]={'A','M','f','S','u','R','w','b','X','o','T','n','t','x','g','z','K','F','m','d','e','p','l','a','r','h',
							'B','L','9','8','k','C','H','I','7','4','$','J','s','!','O','y','@','1','6','c','i','W','N','q','G','j','v','D','V','Y','E','Q',':','U','Z','P','3','2','5','0','\n',' '};
    
   
    public static String decryption(String s)
    {
		System.out.println(s);
        char p1[]=new char[(s.length())];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<68;j++)
            {
                if(ch[j]==s.charAt(i))
                {
                    p1[i]=p[j];
                    break;
                }
            }
        }
        return(new String(p1));
    }
	
	
	
	public static String textoffile(String path)
	
	{
		String str="";
		try{
		
            FileInputStream fin=new FileInputStream(path);    
            int i=0;    
            while((i=fin.read())!=-1){    
            str+=(char)i;  			  
            }    
			fin.close();   
			
		}
		catch(Exception e){
			System.out.print(e);
		}
		return str;
		
	}
	
	
	public static void writeintofile(String en, String path)
	{
		try{
		FileOutputStream fout = new FileOutputStream(path);
		byte[] bytes = en.getBytes();
		fout.write(bytes);
		fout.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
	}
    
    public static void main(String []args)
    {
     Scanner sc = new Scanner(System.in)   	;
	 int b=0;
		while(b!=1)
		{
		System.out.println("Enter the path of the file to be decrypted: ");
		String path= sc.next();
		File f=new File(path);
		    if(f.exists())
			{
		
		String en=textoffile(path);
		String dcr=decryption(en);
		writeintofile(dcr,"D:\\testoutdec.txt");
		
		System.out.println("Decrypted message: "+dcr);
		System.out.println("There will be a file created with the name testoutdec.txt");
		
		b=1;

			}
			else
			{
			System.out.println("Invalid path");	
			}
	}

	  
			  
    }
}

