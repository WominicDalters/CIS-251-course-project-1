//Dominic Walters
//


import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;

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


    // ***Brainstorm***
    /*  
        Thinking we should use hashmaps with the employee_id as a key,
        and the Personnel/Faculty class as the object

        Example:
            HashMap<employee_id, Personnel>();

        Then, we can just write the whole set of information in Personnel
        to the appropriate .txt files

        Only problem I see with this is it will become redundant to put
        the same Object in multiple .txt files(The Personnel class contains
        the information for both basic_info.txt and additional_info.txt).
     */
}
    
