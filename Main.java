//Dominic Walters
//

/*  The Plan

        Mitchell will deal with:
            B. Create the files that contain the information as shown below
                1. basic_info.txt for all personnel
                employee_id | first_name | last_name | sex | email_address | department | role | 
                join_year | bio (a string-based introduction of the employee) | school_web_link, 
                if any
                2. faculty.txt for instructors / faculty members
                employee_id | status (full-time / part-time) | sabbatical (y/n) | # of courses 
                teaching in the current semester ([0-5])
                3. additional_infor.txt for all personnel
                employee_id | volunteer activities (String) | on_leave (no, vacation, sick, 
                sabbatical, parental, maternity)
            - Reading and writing to files


        Dom will deal with:
            C. allow efficiently adding, updating, removing personnel info by employee_id
            D. allow efficient retrieval of a school employee by employee_id, name (either 
            first_name or last_name), department, join_year, status, sabbatical, # of courses
            -HashMaps

        Together:
            E. allow aggregating and reporting the data on a hierarchical manner (e.g. president -> 
            department_head -> professor)
            F. handle edge cases and possible exceptions properly
            G. You should write a testing program to 
                • add sample data files
                • testing different operations against the sample data files
                • output the aggregating and reporting result to the console and a summary.txt file

    */

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
        
        //creating an instance of Personnel Manager
        Personnel_Manager UFV_manager = new Personnel_Manager();

        //creating some mock data to work with while waiting for file data
        Personnel Jim = new Personnel("0000", "Jim", "Halpert", "male", 
                                      "jim@gmail.com", "default", "employee",
                                      2004, "he is good", "none",
                                      "none", false);

        Personnel Chuck = new Personnel("1111", "Chuck", "Cheese", "male", 
                                      "chuck@gmail.com", "default", "employee",
                                      2015, "he likes ice cream", "none",
                                      "none", false);

        //Adding Jim and Chuck to the personnel hash map in UFV_manager
        UFV_manager.add_personnel("0000", Jim);
        UFV_manager.add_personnel("1111", Chuck);

        

    }


    
}
    
