package pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class p15
   {
   public static void main(String []args)
	{
	int temp;
	String str= " ";

	InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

	try
        {
	System.out.print("enter the string : ");
	str=br.readLine();
	}

	catch(IOException e)
        {
        System.out.println("Cannot read :"+e);
        }

	int a[]=new int[str.length()];

	System.out.println("You enter the string : "+ str);

	for(int i=0; i<a.length; i++)
	  {
	  a[i]=str.charAt(i);
	  }
	for(int i=0; i<a.length; i++)
	  {
	  for(int j=0; j<=i; j++)
	    {
	    if(a[i]<a[j])
	      {
	      temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
	      }
	    }
	  }
	System.out.print("The alphabetical string is : ");

	for (int element : a) {
	System.out.print((char)element);
	  }
	}
   }