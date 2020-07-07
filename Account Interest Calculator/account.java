import java.util.Scanner;
import java.io.IOException;
class calculateInterest
{
    Scanner hold = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    
    double calculateInterest1(double amount, double rate, double principal)
    {
        return (principal*rate*amount)/100;
    }

    void display(double value)
    {
        if (value==0)
        {
            System.out.println("Some incorrect value was entered");
            hold.nextLine();
            return;
        }
        System.out.println("Interest gained: Rs."+value);
        hold.nextLine();
    }

    double checker(double val)  
    {
        while(val<=0)
        {
            System.out.print("Enter a valid value: ");
            val = scanner.nextDouble();
        }
        return val;
    }
}
class SB_calculator extends calculateInterest
{
    double interestRate, amount, gain;
    char account_type ='p';

    void input()
    {
        System.out.print("Enter the Average amount in your account: ");
        amount = scanner.nextDouble();
        amount = checker(amount);
        while(account_type != 'n' || account_type != 'N' || account_type != 'y' || account_type != 'Y')
        {
            System.out.print("Is account type NRI (y/n): ");
            account_type = scanner.next().charAt(0);
            if(account_type == 'y' || account_type == 'Y')
            {
                interestRate = 6;
                break;
            }
            else if(account_type == 'n' || account_type == 'N')
            {
                interestRate = 4;
                break;
            }
            else
            {
                System.out.println("Enter a valid choice!!");
            }
        }
        gain = calculateInterest1(amount, interestRate, 1.0);
        display(gain);
    }
    
}
class FD_calculator extends SB_calculator
{
    double interestRate, amount, gain, noOfDays, ageOfACHolder;
    Boolean IsSenoirCitizen=false;

    void input()
    {
        System.out.print("Enter the FD amount: ");
        amount = scanner.nextDouble();
        amount = checker(amount);
        System.out.print("Enter the number of days: ");
        noOfDays = scanner.nextDouble();
        noOfDays = checker(noOfDays);
        System.out.print("Enter your age: ");
        ageOfACHolder = scanner.nextInt();
        ageOfACHolder = checker(ageOfACHolder);

        if(ageOfACHolder>=60)
        {
            IsSenoirCitizen = true;
        }

        if(amount>=10000000)
        {
            if(noOfDays>=7 && noOfDays<=14)
            {
                interestRate = 6.5;
            }
            else if((noOfDays>=15 && noOfDays<=29) || (noOfDays>=30 && noOfDays<=45))
            {
                interestRate = 6.75;
            }
            else if(noOfDays>=45 && noOfDays<=60)
            {
                interestRate = 8;
            }
            else if(noOfDays>=61 && noOfDays<=184)
            {
                interestRate = 8.5;
            }
            else if(noOfDays>=185 && noOfDays<=365)
            {
                interestRate = 10.00;
            }
            else
            {
                interestRate = 10.0;
            }
        }

        else
        {
            if(noOfDays>=7 && noOfDays<=14)
            {
                if(IsSenoirCitizen)
                {
                    interestRate = 5.00;
                }
                else
                {
                    interestRate = 4.5;
                }
            }
            else if((noOfDays>=15 && noOfDays<=29))
            {
                if(IsSenoirCitizen)
                {
                    interestRate = 5.25;
                }
                else
                {
                    interestRate = 4.75;
                }
            }
            else if(noOfDays>=30 && noOfDays<=45)
            {
                if(IsSenoirCitizen)
                {
                    interestRate = 6.00;
                }
                else
                {
                    interestRate = 5.50;
                }
            }
            else if(noOfDays>=45 && noOfDays<=60)
            {
                if(IsSenoirCitizen)
                {
                    interestRate = 7.50;
                }
                else
                {
                    interestRate = 7;
                }
            }
            else if(noOfDays>=61 && noOfDays<=184)
            {
                if(IsSenoirCitizen)
                {
                    interestRate = 8.00;
                }
                else
                {
                    interestRate = 7.50;
                }
            }
            else if(noOfDays>=185 && noOfDays<=365)
            {
                if(IsSenoirCitizen)
                {
                    interestRate = 8.50;
                }
                else
                {
                    interestRate = 8.00;
                }
            }
            else
            {
                interestRate = 10.0;
            }
        }

        gain = calculateInterest1(amount, interestRate, 1.0);
        display(gain);
    }
}
class RD_calculator extends FD_calculator
{
    double interestRate, amount,noOfMonths, ageOfACHolder;
    boolean IsSenoirCitizen = false;

    void input()
    {
        double gain;
        System.out.print("Enter the amount: ");
        amount = scanner.nextDouble();
        amount = checker(amount);
        System.out.print("Enter the numbner of months: ");
        noOfMonths = scanner.nextInt();
        noOfMonths = checker(noOfMonths);
        System.out.print("Enter your age: ");
        ageOfACHolder = scanner.nextInt();
        ageOfACHolder = checker(ageOfACHolder);
        if(ageOfACHolder>=60)
        {
            IsSenoirCitizen = true;
        }
        if(noOfMonths<=6)
        {
            if(IsSenoirCitizen)
            {
                interestRate=8.0;
            }
            else
            {
                interestRate=7.50;
            }
        }
        else if(noOfMonths<=9)
        {
            if(IsSenoirCitizen)
            {
                interestRate=8.25;
            }
            else
            {
                interestRate=7.75;
            }
        }
        else if(noOfMonths<=12)
        {
            if(IsSenoirCitizen)
            {
                interestRate=8.50;
            }
            else
            {
                interestRate=8.00;
            }
        }
        else if(noOfMonths<=15)
        {
            if(IsSenoirCitizen)
            {
                interestRate=8.75;
            }
            else
            {
                interestRate=8.25;
            }
        }
        else if(noOfMonths<=18)
        {
            if(IsSenoirCitizen)
            {
                interestRate=9.00;
            }
            else
            {
                interestRate=8.50;
            }
        }
        else if(noOfMonths<=21)
        {
            if(IsSenoirCitizen)
            {
                interestRate=9.25;
            }
            else
            {
                interestRate=8.75;
            }
        }
        else
        {
            interestRate=10.0;
        }
        gain = calculateInterest1(amount, interestRate, noOfMonths);
        display(gain);
    }
}
class Account
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Scanner hold = new Scanner(System.in);
        int choice;
        while(true)
        {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {}

            System.out.println("1. Interest Calculator SB");
            System.out.println("2. Interest Calculator FD");
            System.out.println("3. Interest Calculator RD");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice)
            {
                default:
                    System.out.println("Enter a valid choice !!");
                    hold.nextLine();
                    break;
                
                case 1:
                    SB_calculator SB_obj = new SB_calculator();
                    SB_obj.input();
                    break;
                
                case 2:
                    FD_calculator FD_obj = new FD_calculator();
                    FD_obj.input();
                    break;
                
                case 3:
                    RD_calculator RD_obj = new RD_calculator();
                    RD_obj.input();
                    break;
                
                case 4:
                    System.exit(0);
            }
        }
        
    }
}
