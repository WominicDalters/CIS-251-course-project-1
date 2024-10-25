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
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        //initiallizing the 3 text files to be written and read

        File faculty = new File("faculty.txt");
        File basicInfo = new File("basic_info.txt");
        File additionalInfo = new File("additional_info.txt");
        
        boolean TESTING = true;
        if (TESTING) {
            File_Generator fg = new File_Generator();

            // This takes in argument that states number of employees
            // Max 9999
            fg.generate_all(10);

            faculty = new File("test_faculty_info.txt");
            basicInfo = new File("test_basic_info.txt");
            additionalInfo = new File("test_additional_info.txt");
        }
        



        Personnel_Manager UFV_manager = new Personnel_Manager();

        
        

        // All files read and added to the hashmap
        // Personnel newPersonnel = null;
        if (basicInfo.exists())
        {
            try
            {
                Scanner reader = new Scanner(basicInfo);
                while (reader.hasNextLine())
                {
                    String data = reader.nextLine();
                    String[] attributes = data.split("\\|", -1);
                    Personnel newPersonnel = new Personnel(
                        attributes[0], //id
                        attributes[1], //first
                        attributes[2], //last
                        attributes[3], //sex
                        attributes[4], //email
                        attributes[5], //department
                        attributes[6], //role
                        Integer.parseInt(attributes[7]), //joinyear
                        attributes[8], //bio
                        attributes[9], //schoolweblink
                        "", //volunteer activities
                        "" // leave
                        );
                    UFV_manager.add_personnel(attributes[0], newPersonnel);
                    
                }
                reader.close();
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("An error occured: " + exception);

            }
        }
        else
        {
            System.out.println("BASICINFO: The file does not exist");
        }

        if (additionalInfo.exists())
        {
            try
            {
                Scanner reader = new Scanner(additionalInfo);
                while (reader.hasNextLine())
                {
                    String data = reader.nextLine();
                    String[] attributes = data.split("\\|", -1);
                    UFV_manager.update_volunteer_activities(attributes[0], attributes[1]);
                    UFV_manager.update_on_leave(attributes[0], attributes[2]);
                    // newPersonnel.change_volunteer_activities(attributes[1]);
                    // newPersonnel.change_on_leave(attributes[2]);
                    
                }
                reader.close();
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("An error occured: " + exception);

            }
        }
        else
        {
            System.out.println("ADDITIONALINFO: The file does not exist");
        }

        if (faculty.exists())
        {
            try
            {
                Scanner reader = new Scanner(faculty);
                while (reader.hasNextLine())
                {
                    String data = reader.nextLine();
                    String[] attributes = data.split("\\|", -1);
                    boolean fullTime = false;
                    if (attributes[1].equals("full-time")) {
                        fullTime = true;
                    }
                    boolean sabbatical = false;
                    if (attributes[2].equals("y")) {
                        sabbatical = true;
                    }
                    Faculty newFaculty = new Faculty(
                        attributes[0], // id
                        fullTime,
                        sabbatical,
                        Integer.parseInt(attributes[3]) // coures in semester
                    );
                    // UFV_manager.change_faculty(attributes[0], newFaculty);
                    // newPersonnel.change_faculty(newFaculty);
                    // UFV_manager.add_personnel(newPersonnel.get_employee_id(), newPersonnel);
                    UFV_manager.add_faculty(attributes[0], newFaculty);
                }
                reader.close();
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("An error occured: " + exception);

            }
        }
        else
        {
            System.out.println("FACULTY: The file does not exist");
        }

        

        // alows to edit hashmap from command line
        UFV_manager.poll_updates();
        // print out to summary.txt
        UFV_manager.aggregate();
        // UFV_manager.viewMap();
    }
}