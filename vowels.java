import java.util.*;
class vowels
{
public static void main(String args[])
{
Scanner s = new Scanner(System.in);

System.out.println("Enter the Sentence");

String lttr = s.nextLine();

String sent[] = lttr.split(" ");

for(int i=0;i<sent.length;i++)
	{

		if (sent[i].charAt(0)=='a' || sent[i].charAt(0)=='e' || sent[i].charAt(0)=='i' ||sent[i].charAt(0)=='o' ||sent[i].charAt(0)=='u' )
		{
		System.out.println("The vowels are = " + sent[i].charAt(0));
		}
		else
		{
		System.out.println("The consonents are = " + sent[i].charAt(0));
		}
	}


}
}