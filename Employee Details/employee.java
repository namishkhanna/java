package employ;
import java.util.Scanner; 
import java.util.*; 

class EmployData
{
	public String name;
	public int eid;
	public String city;
	public String salary;
    Scanner scanner = new Scanner(System.in);
  
    public void get_input()
    {
          System.out.print("Enter the Name of the Employee : ");
          name = scanner.nextLine();
          System.out.print("Enter Employee id of "+name+" : ");
          eid = scanner.nextInt();
          System.out.print("Enter City of "+name+" : ");
          city = scanner.next();
          System.out.print("Enter Salary of "+name+" : ");
          salary = scanner.next();
          System.out.println();
    }
  
    public void display()
    {
    	  System.out.println("Employee Name : "+name+"			"+"Id : "+eid+"			"+"City : "+city+"			"+"Salary : "+salary);
    	  System.out.println();
	  System.out.println();
    }
}
class employ
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int num,val=0;
		ArrayList<EmployData> objList = new ArrayList<EmployData>();

		while(true)
		{
			System.out.print("");  
			System.out.flush(); 
			System.out.println("1. Enter Employee Details : ");
			System.out.println("2. Display Employee Details : ");
			System.out.println("3. Search Employee Details : ");
			System.out.println("4. Exit");
			num = scanner.nextInt();

			switch(num)
			{      
              	case 1:
              		System.out.println("Enter below Employee Details : ");
              		EmployData temp_obj = new EmployData();
              		temp_obj.get_input();
              		objList.add(temp_obj);
              		break;

              	case 2:
              		System.out.println("Below are the Details of the Employee's : ");
              		for(int i=0; i<objList.size(); i++)
              		{
              			(objList.get(i)).display();
              		}
              		scanner.nextLine();
              		scanner.nextLine();
              		break;
              		
              	case 3:
              		System.out.println("Enter Employee Id whose Data you want to Search : ");
              		int empsea=scanner.nextInt();
              		for(int i=0; i<objList.size(); i++)
              		{
              			EmployData obj=objList.get(i);
              			if(empsea==obj.eid)
              			{
              				System.out.println("Employee Name : "+obj.name+"			"+"Id : "+obj.eid+"			"+"City : "+obj.city+"			"+"Salary : "+obj.salary);
              				System.out.println("");
              			}
              			else
              			{
              				System.out.println("No Employee Id Found !!!");
              				System.out.println("");
              			}
              		}
              		break;
                    
              	case 4:
              		val=1;
              		break;
              		
              	default:
              		System.out.println("Enter a valid choice !!");
              		scanner.nextLine();
              		scanner.nextLine();
              		break;
			}
			if (val==1)
			{
				break;
			}
		}
		scanner.close();
	}
}
