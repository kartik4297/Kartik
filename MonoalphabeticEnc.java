import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.io.File;
public class MonoalphabeticEnc
{
    public static char p[] ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
							'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
							'0','1','2','3','4','5','6','7','8','9',':','$','!','@'};
    public static char ch[]={'A','M','f','S','u','R','w','b','X','o','T','n','t','x','g','z','K','F','m','d','e','p','l','a','r','h',
							'B','L','9','8','k','C','H','I','7','4','$','J','s','!','O','y','@','1','6','c','i','W','N','q','G','j','v','D','V','Y','E','Q',':','U','Z','P','3','2','5','0'};
    
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
	return(str);
		
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
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the file to be encrypted: ");
		String path= sc.next();
		File f=new File(path);
		    if(f.exists())
			{
				
		
		String pt=""; 
		System.out.println("palinntext: "+textoffile(path));
		pt =textoffile(path);
        String en=encryption(pt);
        System.out.println("Encrypted message: "+en);
		writeintofile(en,"D:\\testoutenc.txt");
		
	
			}
			else
			{
				System.out.println("Invalid path");
			}
		

	  
			  
    }
}

