package video;
import java.util.Scanner;
import java.io.IOException;
class all_videos_in_store
{
    public String id, name, price, genere, rating, yol;
    public int flag=0;
    public void creat_new_data(String mid, String mname, String mprice, String mgerene, String mrating, String myol)
    {
        id = mid;
        name = mname;
        price = mprice;
        genere = mgerene;
        rating = mrating;
        yol = myol;
    }
    public void display()
    {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Price (per week): "+price);
        System.out.println("Genre: "+genere);
        System.out.println("IMDB Rating: "+rating);
        System.out.println("Year of release: "+yol);
        System.out.println(" ");
    }
    public int search_for_del(String mid)
    {
        if(mid.equals(id))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
class videos_avaliable extends all_videos_in_store
{
    public void display_not_on_rent()
    {
        if(flag==0)
        {
            System.out.println("ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Price (per week): "+price);
            System.out.println("Genre: "+genere);
            System.out.println("IMDB Rating: "+rating);
            System.out.println("Year of release: "+yol);
            System.out.println(" ");
        }
    }
}
class videos_on_rent extends videos_avaliable
{
    public int search(String mid)
    {
        if(mid.equals(id))
        {
            if(flag!=0)
            {
                return 2;
            }
            flag = 1;
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public int display_on_rent()
    {
        if(flag!=0)
        {
            System.out.println("ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Price (per week): "+price);
            System.out.println("Genre: "+genere);
            System.out.println("IMDB Rating: "+rating);
            System.out.println("Year of release: "+yol);
            System.out.println(" ");   
            return 1;
        }
        return 0;
    }

    public int return_video(String mid)
    {
        if(mid.equals(id))
        {
            if(flag!=0)
            {
                flag=0;
                return 1;
            }
            else if(flag==0)
            {
                return 2;
            }
        }
        return 0;
    }

}
class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Scanner hold = new Scanner(System.in);
        int choice, n=256, index=0, id_index=11;
        String rent_id, mid, mname, mprice, mgenere, mrating, myol;
        videos_on_rent objList[] = new videos_on_rent[n];
        
        String[] name = {"3 Idiots","Swades","Kahaani","Sanju","Lagaan","A Wednesday","Dangal","Gangster","Sultan","PK"};
        String[] id = {"1","2","3","4","5","6","7","8","9","10"};
        String[] price = {"$ 20","$ 15","$ 16","$ 25","$ 30","$ 10","$ 5","$ 24","$ 10.5","$ 11"};
        String[] genere = {"Drama","Dram, Music","Mystery","Drama, Comedy","MeloDrama","Mystery","Sport","Bollywood","Sport","Fantasy"};
        String[] rating = {"8.4","8.2","8.1","7.8","8.1","8.1","8.4","7.1","7","8.1"};
        String[] yol = {"2009","2004","2012","2018","2001","2008","2016","2006","2016","2014"};

        for(int i=0;i<10;i++)
        {
            videos_on_rent temp_obj = new videos_on_rent();
            temp_obj.creat_new_data(id[i], name[i], price[i], genere[i], rating[i], yol[i]);
            objList[index] = temp_obj;
            index++;
        }

        while(true)
        {
            int flag_found =0;
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {}

            System.out.println("1. Display all videos");
            System.out.println("2. Display all avaliable videos to rent");
            System.out.println("3. Display rented videos");
            System.out.println("4. Add a new video to the store");
            System.out.println("5. Delete a video from the store");
            System.out.println("6. Rent a video");
            System.out.println("7. Return a video");
            System.out.println("8. Exit");
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Below is the amzing collection: ");
                    for(int i=0;i<index;i++)
                    {
                        objList[i].display();
                    }
                    hold.nextLine();
                    break;
                
                case 2:
                    for(int i=0;i<index;i++)
                    {
                        objList[i].display_not_on_rent();
                    }
                    hold.nextLine();
                    break;

                case 3:
                    System.out.println("Below are the movies that have been rented: ");
                    for(int i=0;i<index;i++)
                    {
                        if(objList[i].display_on_rent()==1)
                        {
                            flag_found++;
                        }
                    }
                    if(flag_found==0)
                    {
                        System.out.println("No Movie has been rented yet ._.");
                    }
                    hold.nextLine();
                    break;
                
                case 4:
                    mid = Integer.toString(id_index);
                    id_index++;

                    System.out.println("Enter the below details: ");

                    System.out.print("Enter the name of "+mid+" : ");
                    mname = scanner.next();

                    System.out.print("Enter the genre of "+mid+" : ");
                    mgenere = scanner.next();

                    System.out.print("Enter the price of "+mid+" ($ price): ");
                    mprice = scanner.next();

                    System.out.print("Enter Year of release of "+mid+" : ");
                    myol = scanner.next();

                    System.out.println("Enter rating of "+mid+" : ");
                    mrating = scanner.next();

                    videos_on_rent temp_obj = new videos_on_rent();
                    temp_obj.creat_new_data(mid, mname, mprice, mgenere, mrating, myol);
                    objList[index] = temp_obj;
                    index++;
                    break;

                case 5:
                    System.out.println("Enter the id of the movie to delete: ");
                    mid = scanner.next();
                    for(int i=0;i<index;i++)
                    {
                        if(objList[i].search_for_del(mid)==1)
                        {
                            if(objList[i].flag!=0)
                            {
                                System.out.println("Movie has been rented for now. It can not be deleted from the recod");
                                break;
                            }
                            for(int j=i;j<index-1;j++)
                            {
                                objList[i].id = objList[i+1].id;
                                objList[i]=objList[i+1];
                            }

                            System.out.println("The video with ID "+mid+" has been deleted successfully");
                            flag_found = 1;
                            index--;
                            break;
                        }
                    }
                    if(flag_found==0)
                    {
                        System.out.println("No such record found !!! ");
                    }
                    hold.nextLine();
                    break;
                
                case 6:
                    System.out.println("Below is the amzing collection: ");
                    for(int i=0;i<index;i++)
                    {
                        objList[i].display();
                    }
                    System.out.println("Enter the id of the movie to rent:");
                    rent_id = scanner.next();

                    for(int i=0;i<index;i++)
                    {
                        if(objList[i].search(rent_id)==1)
                        {
                            System.out.println("Movie successfully rented for a week");
                            flag_found =1;
                            break;
                        }
                        else if(objList[i].search(rent_id)==2)
                        {
                            System.out.println("The move has been alrady rented");
                            flag_found = 1;
                            break;
                        }
                    }
                    if(flag_found==0)
                    {
                        System.out.println("No such record found !!");
                    }
                    hold.nextLine();
                    break;

                case 7:
                    System.out.println("Enter the id of the movie to be returned: ");
                    mid = scanner.next();
                    for(int i=0;i<index;i++)
                    {
                        if(objList[i].return_video(mid)==1)
                        {
                            System.out.println("Thank you for returning the Movie. Happy watching!");
                            flag_found = 1;
                            break;
                        }
                        else if(objList[i].return_video(mid)==2)
                        {
                            System.out.println("Movie is already present in the store");
                            flag_found = 1;
                            break;
                        }
                    }
                    if(flag_found == 0)
                    {
                        System.out.println("No such record found");
                    }
                    hold.nextLine();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}