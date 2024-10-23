import java.util.HashMap;
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

    public void printPersonnel(String empId) {
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

            System.out.println(info + "\n");
    }

    public void viewMap() {
        for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
            String info = "ID: " + entry.getKey() 
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
            + " Leave: " + entry.getValue().get_on_leave();


            if (entry.getValue().get_faculty() != null) {
                info = info + " FullTime: " + entry.getValue().get_faculty().get_full_time()
                + " Sabbatical: " + entry.getValue().get_faculty().get_sabbatical()
                + " NumOfCourses: " + entry.getValue().get_faculty().get_courses_teaching();
            }

            System.out.println(info + "\n");
        }
    }

    public void aggregate() {

        ArrayList<String> department_list = new ArrayList<>();

        System.out.println("---President---");
        // Find President and deps
        for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
            if(entry.getValue().get_role().equals("President")) {
                printPersonnel(entry.getKey());
            }
            if (!department_list.contains(entry.getValue().get_department()) && !entry.getValue().get_role().equals("President")) {
                department_list.add(entry.getValue().get_department());
            }
        }

        for (String department : department_list) {
            // Dep head
            System.out.println("---Department Head of " + department + "---");
            for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                if(entry.getValue().get_role().equals("Department Head") && entry.getValue().get_department().equals(department)) {
                    printPersonnel(entry.getKey());

                    // break due to only one dep head
                    break;
                }
            }
            // Profs
            System.out.println("---" + department + " Professors---");
            for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                if(entry.getValue().get_role().equals("Professor") && entry.getValue().get_department().equals(department)) {
                    printPersonnel(entry.getKey());
                }
            }

            // Volunteers
            System.out.println("---" + department + " Volunteers---");
            for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                if(entry.getValue().get_role().equals("Volunteer") && entry.getValue().get_department().equals(department)) {
                    printPersonnel(entry.getKey());
                }
            }   
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
