import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Personnel_Manager 
{
    //attributes
        //Hashmap by id
    private HashMap<String /*employee_id*/, Personnel> personnel_hash = new HashMap<>();

        //Hashmap by name


        //Hashmap by department


        //hashmap<join year, list containing anyone with that join year>
            //when we need to add a personnel instance to this year,
            //we just put them in the list of people

    //methods
        //method for adding personnel
    public void add_personnel(String id, Personnel personnel)
    {
        personnel_hash.put(id, personnel);


    }

    public String printPersonnel(String empId) {
            String info = "ID: " + empId 
            + " -> First: " + personnel_hash.get(empId).get_first_name()
            + " Last: " + personnel_hash.get(empId).get_last_name() 
            + " Sex: " + personnel_hash.get(empId).get_sex() 
            + " Email: " + personnel_hash.get(empId).get_email_address() 
            + " Department: " + personnel_hash.get(empId).get_department() 
            + " Role: " + personnel_hash.get(empId).get_role() 
            + " JoinYear: " + personnel_hash.get(empId).get_join_year() 
            + " Bio: " + personnel_hash.get(empId).get_bio() 
            + " WebLink: " + personnel_hash.get(empId).get_school_web_link()
            + " Volunteer: " + personnel_hash.get(empId).get_volunteer_activities() 
            + " Leave: " + personnel_hash.get(empId).get_on_leave();

            if (personnel_hash.get(empId).get_faculty() != null) {
                info = info + " FullTime: " + personnel_hash.get(empId).get_faculty().get_full_time()
                + " Sabbatical: " + personnel_hash.get(empId).get_faculty().get_sabbatical()
                + " NumOfCourses: " + personnel_hash.get(empId).get_faculty().get_courses_teaching();
            }

            info += "\n";
            System.out.println(info);
            return info;
    }

    public void viewMap() {
        for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
            printPersonnel(entry.getKey());
        }
    }

    public void aggregate() {

        try {
            FileWriter summaryWrite = new FileWriter("summary.txt");
            ArrayList<String> department_list = new ArrayList<>();

            summaryWrite.write("---President---\n");
            // Find President and deps
            for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                if(entry.getValue().get_role().equals("President")) {
                    summaryWrite.write(printPersonnel(entry.getKey()));
                }
                if (!department_list.contains(entry.getValue().get_department()) && !entry.getValue().get_role().equals("President")) {
                    department_list.add(entry.getValue().get_department());
                }
            }
    
            for (String department : department_list) {
                // Dep head

                summaryWrite.write("---Department Head of " + department + "---\n");
                for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if(entry.getValue().get_role().equals("Department Head") && entry.getValue().get_department().equals(department)) {
                        summaryWrite.write(printPersonnel(entry.getKey()));
    
                        // break due to only one dep head
                        break;
                    }
                }
                // Profs
                summaryWrite.write("---" + department + " Professors---\n");
                for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if(entry.getValue().get_role().equals("Professor") && entry.getValue().get_department().equals(department)) {
                        summaryWrite.write(printPersonnel(entry.getKey()));
                    }
                }
    
                // Volunteers
                summaryWrite.write("---" + department + " Volunteers---\n");
                for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if(entry.getValue().get_role().equals("Volunteer") && entry.getValue().get_department().equals(department)) {
                        summaryWrite.write(printPersonnel(entry.getKey()));
                    }
                }   
            }
            summaryWrite.close();
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        
    }

    //methods for updating personnel
    public void change_faculty(String id, Faculty new_faculty) {
        personnel_hash.get(id).change_faculty(new_faculty);
    }

    public void change_volunteer_activities(String id, String new_volunteer_activities) {
        personnel_hash.get(id).change_volunteer_activities(new_volunteer_activities);
    }

    public void change_on_leave(String id, String new_on_leave) {
        personnel_hash.get(id).change_on_leave(new_on_leave);
    }

}
