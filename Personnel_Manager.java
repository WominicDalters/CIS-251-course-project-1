import java.util.HashMap;

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

    public void viewMap() {
        for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
            System.out.println("ID: " + entry.getKey() 
            + " -> First: " + entry.getValue().get_first_name() 
            + " Last: " + entry.getValue().get_last_name() 
            + " Sex: " + entry.getValue().get_sex() 
            + " Email: " + entry.getValue().get_email_address() 
            + " Department: " + entry.getValue().get_department() 
            + " Role: " + entry.getValue().get_role() 
            + " JoinYear: " + entry.getValue().get_join_year() 
            + " Bio: " + entry.getValue().get_bio() 
            + " WebLink: " + entry.getValue().get_school_web_link()
            + " Volunteer: " + entry.getValue().get_volunteer_activities() 
            + " Leave: " + entry.getValue().get_on_leave() 
            + " FullTime: " + entry.getValue().get_faculty().get_full_time()
            + " Sabbatical: " + entry.getValue().get_faculty().get_sabbatical()
            + " NumOfCourses: " + entry.getValue().get_faculty().get_courses_teaching()
            );
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
