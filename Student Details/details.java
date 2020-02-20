package details;
import java.util.*;
import java.io.*; 
class student_details
{
    Scanner scanner = new Scanner(System.in);
    Scanner hold = new Scanner(System.in);
    String name,uid,course;
    float math,eng,sci;

    String input()
    {   
        String id;
        if(scanner.hasNextLine())
        {
            id = scanner.next();
        }
        else
        {
            id = scanner.nextLine();
        }
        return id;

    }

    float input_flaot()
    {   
        float value;
        value = scanner.nextFloat();
        return value;

    }

    void input_data()
    {
        System.out.print("Enter the name of the student: ");
        this.name = scanner.nextLine();

        System.out.print("Enter the UID of the student: ");
        this.uid = scanner.nextLine();

        System.out.print("Enter course of "+this.name+": ");
        this.course = scanner.nextLine();

        System.out.print("Enter marks of "+this.name+" in Maths: ");
        this.math = scanner.nextFloat();

        System.out.print("Enter marks of "+this.name+" in English: ");
        this.eng = scanner.nextFloat();

        System.out.print("Enter marks of "+this.name+" in Science: ");
        this.sci = scanner.nextFloat();
    }

    void display()
    {
        System.out.println("\n Name: "+this.name);
        System.out.println("UID: "+this.uid);
        System.out.println("Course: "+this.course);
        System.out.println("------------ Marks ------------");
        System.out.println("Maths: "+this.math);
        System.out.println("English: "+this.eng);
        System.out.println("Science: "+this.sci);
    }
}

class search {
    Scanner scanner = new Scanner(System.in);
    Scanner hold = new Scanner(System.in);
    student_details temp_obj = new student_details();

    int[] search_element(LinkedList<student_details> list, String id)
    {
        int[] index_and_bool = new int[]{-1,-1};
        for(int i=0;i<list.size();i++)
        {
            if(id.equals(list.get(i).uid))
            {
                index_and_bool[0] = i;
                index_and_bool[1] = 1;
                return index_and_bool;
            }
        }
        return index_and_bool;
    }

    void search_display(LinkedList<student_details> list, String id)
    {
        int[] answer = new int[]{-1,-1};
        answer=search_element(list, id);
        if(answer[1]==1)
        {
            list.get(answer[0]).display();
        }
        else
        {
            System.out.println("No such record found!!");
        }
        temp_obj.hold.nextLine();
    }

    void delete(LinkedList<student_details> list, String id)
    {
        int[] answer = search_element(list, id);
        if(answer[1]==1)
        {
            list.remove(answer[0]);
            System.out.println("The record has been successfully deleted");
            temp_obj.hold.nextLine();
        }
        else
        {
            System.out.println("No such record found");
            temp_obj.hold.nextLine();
        }
    }

    void update(LinkedList<student_details> list, String id)
    {
        int choice=-1,index=0;
        int[] answer = search_element(list,id);
        if((answer[1])==1)
        {
            while (true)
            {
                try {
                    if (System.getProperty("os.name").contains("Windows"))
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    else
                        Runtime.getRuntime().exec("clear");
                } catch (IOException | InterruptedException ex) {}

                System.out.println("\n Select the option you want to edit: ");
                System.out.println("1. Name");
                System.out.println("2. UID");
                System.out.println("3. Course");
                System.out.println("4. Maths Marks");
                System.out.println("5. English Marks");
                System.out.println("6. Science Marks");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch(choice)
                {
                    default:
                        System.out.print("Enter a vaild choice!!");
                        hold.nextLine();
                        break;
                    case 1:
                        System.out.print("Enter the name of the student: ");
                        list.get(answer[index]).name = temp_obj.input();
                        break;
                    
                    case 2:
                        System.out.print("Enter the UID of the student: ");
                        list.get(answer[index]).uid = temp_obj.input();
                        break;

                    case 3:
                        System.out.print("Enter course of the student: ");
                        list.get(answer[index]).course = temp_obj.input();
                        break;

                    case 4:
                        System.out.print("Enter marks of the student in Maths");
                        list.get(answer[index]).math = temp_obj.input_flaot();
                        break;
                    
                    case 5:
                        System.out.print("Enter marks of the student in English: ");
                        list.get(answer[index]).eng = temp_obj.input_flaot();
                        break;

                    case 6:
                        System.out.print("Enter marks of student in Science: ");
                        break;
                    
                    case 7:
                        return;
                }

            }
        }
        else
        {
            System.out.println("No record found!!");
            temp_obj.hold.nextLine();
        }
    }
}

class details{

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Scanner hold = new Scanner(System.in);
        student_details temp_obj = new student_details();
        search search_obj = new search();
        LinkedList<student_details> list = new LinkedList<>();
        int choice=-1;
        String id;
        
        while(true)
        {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {}

            System.out.println("1. Enter Details of student");
            System.out.println("2. Update the previous record");
            System.out.println("3. Search a record");
            System.out.println("4. Delete a record");
            System.out.println("5. Display records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice)
            {
                default:
                    System.out.println("Enter a vaild choice!!");
                    hold.nextLine();
                    break;
                
                    case 1:
                        student_details obj = new student_details();
                        obj.input_data();
                        list.add(obj);
                        System.out.println("\n Following record has been created: - \n");
                        break;

                    case 2:
                        System.out.print("Enter the UID of the student: ");
                        id = temp_obj.input();
                        search_obj.update(list, id);
                        break;
                    
                    case 3:
                        System.out.print("Enter the UID of the student: ");
                        id = temp_obj.input();;
                        search_obj.search_display(list, id);
                        break;

                    case 4:
                        System.out.print("Enter the UID of the student: ");
                        id = temp_obj.input();
                        search_obj.delete(list, id);
                        break;

                    case 5:
                        for(int i=0;i<list.size();i++)
                        {
                            list.get(i).display();
                        }
                        hold.nextLine();
                        break;

                    case 6:
                        System.exit(0);
            }   
        }
    }   
}