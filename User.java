import java.util.*;
class User
{
public static void main(String [] args)
{
Scanner s=new Scanner(System.in);

String Username;
int password=0;


System.out.println("Enter your Username");
Username=s.next();

try
{
System.out.println("Enter your password");
password=s.nextInt();
System.out.println("Your Username and password has been generated Successfully");
}

catch(Exception e)
{
System.out.println("Enter the password in integer type");
}
int a=password;
while(a>10)
{
    a=a%10;
 
  
System.out.print("the last digit of the program is="+ a);
}




}
}