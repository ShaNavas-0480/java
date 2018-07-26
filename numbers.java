import java.util.*;
class numbers
{
public static void main(String args[])
{
Scanner s = new Scanner(System.in);

System.out.println("Enter the no.of elemnts for array");

int n = s.nextInt();

int num[] = new int [n];

for(int i =0;i<n;i++)

	{
	num[i] = s.nextInt();
	}

List<Integer> al = new ArrayList<Integer>();

for (int var: num)

{

al.add(var);	
System.out.print(var + " ");

}
System.out.println();

Collections.sort(al);


for( int dummy:al)
{
System.out.print(dummy +" ");
}

System.out.println("\n" +"Enter the desired position");

int nm =s.nextInt();

System.out.println("your desired value= "+ al.get(nm-1));
}

}