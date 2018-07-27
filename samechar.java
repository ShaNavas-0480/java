import java.util.*;

class samechar
{ 
public static void main(String [] args)
{
Scanner s = new Scanner (System.in);
System.out.println(" enter the no.of  string");
char c =' ';
int n = s.nextInt();
System.out.println(" enter the words");
String [] wrd = new String [n];
char [] nme = new char[n];
for (int i = 0; i < n;i ++)

{
wrd[i]= s.next();
}

/*
for (int  j=0 ; j< n;j++)

{
System.out.println("the output is=" + wrd[j]);
}
*/
	for (int i = 0; i<n;i++)
	{	
	 nme[i] = wrd[i].charAt(0); 
	}

		for (int i = 0; i<n;i++)
		{
		for(int j =i+1; j <n;j++)
		{
		if(nme[i]==nme[j])
		{
		c =nme[j];
		continue;
		}
			else
			{
			System.out.println("not in array");
			break;	 
			}

		} 
		}
System.out.println("the samw words =" + c);

}
}  