import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Personnel_Manager 
{
    //attributes
        //Hashmap by id
    private HashMap<String /*employee_id*/, Personnel> personnel_hash = new HashMap<>();

        //hashmap by first_name
    private HashMap<String, List<Personnel>> first_name_map = new HashMap<>();

        //hashmap by last name
    private HashMap<String, List<Personnel>> last_name_map = new HashMap<>();

        //Hashmap by department
    private HashMap<String, List<Personnel>> department_map = new HashMap<>();

        //hashmap by join year
    private HashMap<Integer, List<Personnel>> join_year_map = new HashMap<>();

    //methods





        //method for adding personnel
    public void add_personnel(String id, Personnel Person)
    {
        personnel_hash.put(id, Person);

        String first_name = Person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(Person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(Person);
            first_name_map.put(first_name, new_first_name_list);
        }

        String last_name = Person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(Person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(Person);
            last_name_map.put(last_name, new_last_name_list);
        }

        String department = Person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(Person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(Person);
            department_map.put(department, new_department_list);
        }

        Integer join_year = Person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(Person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(Person);
            join_year_map.put(join_year, new_person_list);
        }
    }









        //methods for updating personnel
    public void update_first_name(String id, String new_first_name)
    {
        Personnel Person = personnel_hash.get(id);
        String first_name = Person.get_first_name();
        String last_name = Person.get_last_name();
        String department = Person.get_department();
        Integer join_year = Person.get_join_year();



            //changing the first name
        Person.change_first_name(new_first_name);
        personnel_hash.put(id, Person);

            //update hashmap by first_name
        if (first_name_map.containsKey(first_name)) //
        {
            //remove Person from the old key
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.remove(Person);
            first_name_map.put(first_name, first_name_list);

            //add person to the new key
            if (first_name_map.containsKey(new_first_name)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_first_name_list = first_name_map.get(new_first_name);
                new_first_name_list.add(Person);
                first_name_map.put(new_first_name, new_first_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_first_name_list = new ArrayList<>();
                created_first_name_list.add(Person);
                first_name_map.put(new_first_name, created_first_name_list);
            }

        }
        else
        {
            if (first_name_map.containsKey(new_first_name)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_first_name_list = first_name_map.get(new_first_name);
                new_first_name_list.add(Person);
                first_name_map.put(new_first_name, new_first_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_first_name_list = new ArrayList<>();
                created_first_name_list.add(Person);
                first_name_map.put(new_first_name, created_first_name_list);
            }
        }

            //update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(Person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(Person);
            last_name_map.put(last_name, new_last_name_list);
        }

            //update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(Person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(Person);
            department_map.put(department, new_department_list);
        }


            //update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(Person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(Person);
            join_year_map.put(join_year, new_person_list);
        }


    }

    







        //method for removing personnel
    public void remove_first_name(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        Person.remove_first_name();
        personnel_hash.put(id, Person);

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
