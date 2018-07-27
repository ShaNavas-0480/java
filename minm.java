import java.util.*;
class minm
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.println("Enter the no.of elements in array");

int elmnt = sc.nextInt();

int num [] = new int [elmnt];
long min = 100000;
for (int i=0;i<num.length;i++)

{

num[i] = sc.nextInt();

}

for (int i =0; i<num.length;i++)
{

if (min  > num[i])
{
min = num[i];
}
}
System.out.println("the output is " + min);
}
}
