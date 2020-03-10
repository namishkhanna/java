package hashmap;

import java.util.*;
public class hashmap
{ 
	public static void main(String[] args) 
	{
		HashMap<String,String> map = new HashMap<String,String>();
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.flush();
			System.out.println("1. Enter Data");
			System.out.println("2. Display Data");
			System.out.println("3. Compare Data");
			System.out.println("4. Exit");
			System.out.println("");
			System.out.println("Enter your Choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter No. of Values you want to Enter: ");
					int input = sc.nextInt();
					for(int i=0;i<input;i++)
					{
						System.out.println("Enter ID and Details for Input "+(i+1)+": ");
						System.out.println("Enter ID: ");
						String key = sc.next();
						if (map.containsKey(key))
						{
							System.out.println("ID Already Assigned !!!");
							i=i-1;
						}
						else
						{
							System.out.println("Enter Name: ");
						 	String name = sc.next();
							System.out.println("Enter Subject: ");
							String sub = sc.next();
						 	System.out.println("Enter Subject Code: ");
							String subcode = sc.next();
							System.out.println("");
						 	String value=name + "		" + sub + "		" + subcode;
						 	map.put(key, value);
						}
					}
					break;
				case 2:
					System.out.println("Name"+"		"+"Subject"+"		"+"Subject Code");
					for (String key : map.keySet())
					{
					    System.out.println(map.get(key));
					}
					break;
				case 3:
					System.out.println("Enter ID you want to Compare: ");
					String compare = sc.next();
					if (map.containsKey(compare))
					{
						String a = map.get(compare);
						System.out.println("Name"+"		"+"Subject"+"		"+"Subject Code");
					 	System.out.println(a);
					 	System.out.println("");
					}
					else
					{
					 	System.out.println("No ID Found !!!");
					 	System.out.println("");
					}
					break;
			 	case 4:
			 		System.out.println("Thankyou !!!");
			 		System.exit(0);
			 		break;
			 	default:
			 		System.out.println("Wrong Input !!!");
			 		System.out.println("");
			}
		}
	}
}
