//Dominic Walters
//


import java.io.File;

public class Main 
{
    public static void main(String[] args) 
    {
        //initiallizing the 3 text files to be written and read
        File faculty = new File("faculty.txt");
        File basicInfo = new File("basic_info.txt");
        File additionalInfo = new File("additional_info.txt");


        

        //***Testing that the file exists***

        /*
        if (faculty.exists())
        {
            System.out.println("it exists");
            try
            {
                Scanner reader = new Scanner(faculty);
                while (reader.hasNextLine())
                {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("An error occured.");

            }
        }
        else
        {
            System.out.println("The file does not exist");
        }
        */
        
        //***********************************
        



    }
}
    
