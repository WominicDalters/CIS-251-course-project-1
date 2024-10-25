import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Personnel_Manager 
{
    //attributes
    //Hashmap by id
    private HashMap<String /*employee_id*/, Personnel> personnel_hash = new HashMap<>();

    // Lists in these maps contain employee ids
    //hashmap by first_name
    private HashMap<String, List<String>> first_name_map = new HashMap<>();

    //hashmap by last name
    private HashMap<String, List<String>> last_name_map = new HashMap<>();

    //Hashmap by department
    private HashMap<String, List<String>> department_map = new HashMap<>();

    //hashmap by join year
    private HashMap<Integer, List<String>> join_year_map = new HashMap<>();

    private HashMap<Boolean, List<String>> status_map = new HashMap<>();

    private HashMap<Boolean, List<String>> sabbatical_map = new HashMap<>();
    
    private HashMap<Integer, List<String>> num_of_courses_map = new HashMap<>();










    //methods
    //adding
    public void add_personnel(String id, Personnel Person)
    {
        personnel_hash.put(id, Person);

        String first_name = Person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<String> first_name_list = first_name_map.get(first_name);
            first_name_list.add(id);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<String> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(id);
            first_name_map.put(first_name, new_first_name_list);
        }

        String last_name = Person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<String> last_name_list = last_name_map.get(last_name);
            last_name_list.add(id);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<String> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(id);
            last_name_map.put(last_name, new_last_name_list);
        }

        String department = Person.get_department();
        if (department_map.containsKey(department))
        {
            List<String> department_list = department_map.get(department);
            department_list.add(id);
            department_map.put(department, department_list);
        }
        else
        {
            List<String> new_department_list = new ArrayList<>();
            new_department_list.add(id);
            department_map.put(department, new_department_list);
        }

        Integer join_year = Person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<String> person_list = join_year_map.get(join_year);
            person_list.add(id);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<String> new_person_list = new ArrayList<>();
            new_person_list.add(id);
            join_year_map.put(join_year, new_person_list);
        }

        // // // // // //
        if (Person.get_faculty() != null) {
            Boolean status = Person.get_faculty().get_full_time();
            if (status_map.containsKey(status)) {
                List<String> person_list = status_map.get(status);
                person_list.add(id);
                status_map.put(status, person_list);
            }
            else {
                List<String> new_person_list = new ArrayList<>();
                new_person_list.add(id);
                status_map.put(status, new_person_list);
            }
    
            Boolean sabbatical = Person.get_faculty().get_sabbatical();
            if (sabbatical_map.containsKey(sabbatical)) {
                List<String> person_list = sabbatical_map.get(sabbatical);
                person_list.add(id);
                sabbatical_map.put(sabbatical, person_list);
            }
            else {
                List<String> new_person_list = new ArrayList<>();
                new_person_list.add(id);
                sabbatical_map.put(sabbatical, new_person_list);
            }
    
            Integer noCourses = Person.get_faculty().get_courses_teaching();
            if (num_of_courses_map.containsKey(noCourses)) {
                List<String> person_list = num_of_courses_map.get(noCourses);
                person_list.add(id);
                num_of_courses_map.put(noCourses, person_list);
            }
            else {
                List<String> new_person_list = new ArrayList<>();
                new_person_list.add(id);
                num_of_courses_map.put(noCourses, new_person_list);
            }
        }
    }

    public void add_faculty(String id, Faculty faculty) {
        Personnel Person = personnel_hash.get(id);
        Person.change_faculty(faculty);
        boolean status = faculty.get_full_time();
        if (status_map.containsKey(status))
        {
            List<String> status_list = status_map.get(status);
            status_list.add(id);
            status_map.put(status, status_list);
        }
        else
        {
            List<String> new_status_list = new ArrayList<>();
            new_status_list.add(id);
            status_map.put(status, new_status_list);
        }

        boolean sabbatical = faculty.get_sabbatical();
        if (sabbatical_map.containsKey(sabbatical)) {
            List<String> sabbatical_list = sabbatical_map.get(sabbatical);
            sabbatical_list.add(id);
            sabbatical_map.put(sabbatical, sabbatical_list);
        }
        else
        {
            List<String> new_sabbatical_list = new ArrayList<>();
            new_sabbatical_list.add(id);
            sabbatical_map.put(sabbatical, new_sabbatical_list);
        }

        Integer noCourses = faculty.get_courses_teaching();
        if (num_of_courses_map.containsKey(noCourses)) {
            List<String> courses_list = num_of_courses_map.get(noCourses);
            courses_list.add(id);
            num_of_courses_map.put(noCourses, courses_list);
        }
        else
        {
            List<String> new_courses_list = new ArrayList<>();
            new_courses_list.add(id);
            num_of_courses_map.put(noCourses, new_courses_list);
        }

    }

    public void poll_updates() {

        Scanner scanner = new Scanner(System.in);
        boolean scannerActive = true;

        while (scannerActive) {
            System.out.print("Would you like to view, add, remove, or edit an employee (n for exit)?> ");
            String res = scanner.nextLine().toLowerCase();
            // Add Person
            if (res.equals("add")) {
                System.out.print("Enter new employee id> ");
                res = scanner.nextLine();
                
                if (personnel_hash.containsKey(res)) {
                    System.out.println("Employee Id already used");
                    continue;
                }

                String nEmpId = res;

                System.out.print("Enter new first name> ");
                String nFirstName = scanner.nextLine();

                System.out.print("Enter new last name> ");
                String nLastName = scanner.nextLine();

                System.out.print("Enter new sex> ");
                String nSex = scanner.nextLine();

                System.out.print("Enter new email address> ");
                String nEmail = scanner.nextLine();

                System.out.print("Enter new department> ");
                String nDepartment = scanner.nextLine();

                System.out.print("Enter new role> ");
                String nRole = scanner.nextLine();

                System.out.print("Enter new join year> ");
                Integer nJoinYear = Integer.valueOf(scanner.nextLine());

                System.out.print("Enter new bio> ");
                String nBio = scanner.nextLine();

                System.out.print("Enter new school web link> ");
                String nWebLink = scanner.nextLine();

                System.out.print("Enter new volunteer activities> ");
                String nVolunteer = scanner.nextLine();

                System.out.print("Enter new leave status (no, vacation, sick, sabbatical, parental, maternity)");
                String nLeaveStatus = scanner.nextLine();

                System.out.print("Enter new full time status (1 for full-time, 0 for part-time)> ");
                boolean nStatus = false;
                res = scanner.nextLine();
                Integer iRes = Integer.valueOf(res);
                if (iRes == 1) {
                    nStatus = true;
                }

                System.out.print("Enter sabbatical status (1 for yes, 0 for no)> ");
                boolean nSabbatical = false;
                res = scanner.nextLine();
                iRes = Integer.valueOf(res);
                if (iRes == 1) {
                    nSabbatical = true;
                }

                System.out.println("Enter new # of courses teaching> ");
                Integer nCourses = Integer.valueOf(scanner.nextLine());

                Personnel newPerson = new Personnel(nEmpId, nFirstName, nLastName, nSex, nEmail, nDepartment, nRole, nJoinYear, nBio, nWebLink, nVolunteer, nLeaveStatus);

                // newPerson.change_faculty(new Faculty(nEmpId, nStatus, nSabbatical, nCourses));


                personnel_hash.put(nEmpId, newPerson);
                add_faculty(nEmpId, new Faculty(nEmpId, nStatus, nSabbatical, nCourses));
                printPersonnel(nEmpId);
            }
            // View Person
            else if (res.equals("view")) {
                System.out.print("Would you like to search employee by employee id, first name, last name, department, join year, status, sabbatical, # of courses, or show all (all)?> ");
                // System.out.print("Would you like to search employee by employee id, first name, last name, department, or join year> ");
                res = scanner.nextLine().toLowerCase();

                if (res.equals("employee id")) {
                    System.out.print("Enter employee id> ");
                    res = scanner.nextLine().toLowerCase();
                    if (personnel_hash.containsKey(res)) {
                        printPersonnel(res);
                    }
                    else {
                        System.out.println("Employee id " + res + " not found");
                    }
                }
                else if (res.equals("first name")) {
                    System.out.print("Enter first name> ");
                    res = scanner.nextLine();

                    lookup_by_first_name(res);
                }
                else if (res.equals("last name")) {
                    System.out.print("Enter last name> ");
                    res = scanner.nextLine();

                    lookup_by_last_name(res);
                }
                else if (res.equals("department")) {
                    System.out.print("Enter department name> ");
                    res = scanner.nextLine();

                    lookup_by_department(res);
                }
                else if (res.equals("join year")) {
                    System.out.print("Enter join year> ");
                    res = scanner.nextLine();

                    lookup_by_join_year(Integer.valueOf(res));
                }
                else if (res.equals("status")) {
                    System.out.print("Enter 1 for full-time, 0 for part-time> ");
                    res = scanner.nextLine();
                    Integer iRes = Integer.valueOf(res);
                    boolean s = iRes.equals(1);
                    lookup_by_status(s);
                }
                else if (res.equals("sabbatical")) {
                    System.out.print("Enter 1 for sabbatical, 0 for no sabbatical> ");
                    res = scanner.nextLine();
                    Integer iRes = Integer.valueOf(res);

                    lookup_by_sabbatical(iRes == 1);
                }
                else if (res.equals("# of courses")) {
                    System.out.print("Enter number of courses teaching> ");
                    res = scanner.nextLine();
                    Integer iRes = Integer.valueOf(res);

                    lookup_by_courses(iRes);
                }
                else if (res.equals("all")) {
                    viewMap();
                }


            }
            // Remove Person
            else if (res.equals("remove")) {
                System.out.print("Enter employee id to be remove> ");
                res = scanner.nextLine();
                if (personnel_hash.containsKey(res)) {
                    remove_person(res);
                    System.out.println("Employee " + res + " removed");
                }
                else {
                    System.out.println("Employee " + res + " does not exist");
                }
            }
            // Edit Person
            else if (res.equals("edit")) {
                System.out.print("Enter employee id to be edited> ");
                res = scanner.nextLine();
                
                if (personnel_hash.containsKey(res)) {
                    String empId = res;
                    if (personnel_hash.get(res).get_faculty() != null) {
                        System.out.print("Which attribute would you like to change? \nfirst name | last name | sex | email address | department | role | join year | bio | school web link | volunteer activities | leave status | full time status | sabbatical | # of courses teaching > ");
                    }
                    else {
                        System.out.print("Which attribute would you like to change? \nfirst name | last name | sex | email address | department | role | join year | bio | school web link | volunteer activities | leave status> ");
                    }

                    res = scanner.nextLine().toLowerCase();

                    if (res.equals("first name")) {
                        System.out.print("Enter new first name> ");

                        res = scanner.nextLine();

                        update_first_name(empId, res);
                        printPersonnel(empId);

                    }
                    else if (res.equals("last name")) {
                        System.out.print("Enter new last name> ");

                        res = scanner.nextLine();

                        update_last_name(empId, res);
                        printPersonnel(empId);

                    }
                    else if (res.equals("sex")) {
                        System.out.print("Enter new sex (m or f)> ");

                        res = scanner.nextLine().toLowerCase();
                        if (res.equals("f")) {
                            personnel_hash.get(empId).change_sex("f");
                        }
                        else {
                            personnel_hash.get(empId).change_sex("m");
                        }
                        printPersonnel(empId);
                    }
                    else if (res.equals("email address")) {
                        System.out.print("Enter new email address> ");

                        res = scanner.nextLine().toLowerCase();
                        personnel_hash.get(empId).change_email_address(res);

                        printPersonnel(empId);
                    }
                    else if (res.equals("department")) {
                        System.out.print("Enter new department> ");

                        res = scanner.nextLine();
                        update_department(empId, res);
                        
                        printPersonnel(empId);
                    }
                    else if (res.equals("role")) {
                        System.out.print("Enter new role> ");

                        res = scanner.nextLine();
                        personnel_hash.get(empId).change_role(res);

                        printPersonnel(empId);
                    }
                    else if (res.equals("join year")) {
                        System.out.print("Enter new join year> ");

                        res = scanner.nextLine();
                        update_join_year(empId, Integer.valueOf(res));

                        printPersonnel(empId);

                    }
                    else if (res.equals("bio")) {
                        System.out.print("Enter new bio> ");

                        res = scanner.nextLine();
                        personnel_hash.get(empId).change_bio(res);

                        printPersonnel(empId);
                    }
                    else if (res.equals("school web link")) {
                        System.out.print("Enter new school web link> ");

                        res = scanner.nextLine();
                        personnel_hash.get(empId).change_school_web_link(res);

                        printPersonnel(res);
                    }
                    else if (res.equals("volunteer activities")) {
                        System.out.print("Enter new volunteer activities message> ");

                        res = scanner.nextLine();
                        personnel_hash.get(empId).change_volunteer_activities(res);

                        printPersonnel(empId);
                    }
                    else if (res.equals("leave status")) {
                        System.out.print("Enter new leave status (no, vacation, sick, sabbatical, parental, maternity)> ");

                        res = scanner.nextLine();
                        personnel_hash.get(empId).change_on_leave(res);

                        printPersonnel(empId);
                    }
                    else if (res.equals("full time status")) {
                        System.out.print("Enter 1 for full-time and 0 for part-time> ");
                        
                        res = scanner.nextLine();
                        Integer iRes = Integer.valueOf(res);

                        if (iRes == 1) {
                            update_status(empId, true);
                        }
                        else {
                            update_status(empId, false);
                        }

                        printPersonnel(empId);
                    }
                    else if (res.equals("sabbatical")) {
                        System.out.print("Enter 1 for yes and 0 for no> ");
                        
                        res = scanner.nextLine();
                        Integer iRes = Integer.valueOf(res);

                        if (iRes == 1) {
                            update_sabbatical(empId, true);
                        }
                        else {
                            update_sabbatical(empId, false);
                        }

                        printPersonnel(empId);
                    }
                    else if (res.equals("# of courses teaching")) {
                        System.out.print("Enter new # of courses teaching> ");

                        res = scanner.nextLine();
                        Integer iRes = Integer.valueOf(res);

                        update_courses_teaching(empId, iRes);

                        printPersonnel(empId);
                    }

                }
                else {
                    System.out.println("Employee " + res + " does not exist");
                }

            }
            // Exit Program
            else if (res.equals("n")) {
                break;
            }
        }
        scanner.close();

    }

    //updating attributes
    // First 7 update methods essential for maintaining the array list maps
    public void update_first_name(String id, String new_first_name)
    {
        Personnel Person = personnel_hash.get(id);
        String first_name = Person.get_first_name();

        //changing the first name
        Person.change_first_name(new_first_name);
        personnel_hash.put(id, Person);

        //update hashmap by first_name
        if (first_name_map.containsKey(first_name)) //
        {
            //remove Person from the old key
            List<String> first_name_list = first_name_map.get(first_name);
            first_name_list.remove(id);
            first_name_map.put(first_name, first_name_list);

            //add person to the new key
            if (first_name_map.containsKey(new_first_name)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_first_name_list = first_name_map.get(new_first_name);
                new_first_name_list.add(id);
                first_name_map.put(new_first_name, new_first_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_first_name_list = new ArrayList<>();
                created_first_name_list.add(id);
                first_name_map.put(new_first_name, created_first_name_list);
            }

        }
        else
        {
            if (first_name_map.containsKey(new_first_name)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_first_name_list = first_name_map.get(new_first_name);
                new_first_name_list.add(id);
                first_name_map.put(new_first_name, new_first_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_first_name_list = new ArrayList<>();
                created_first_name_list.add(id);
                first_name_map.put(new_first_name, created_first_name_list);
            }
        }

    }

    public void update_last_name(String id, String new_last_name)
    {
        Personnel Person = personnel_hash.get(id);
        String last_name = Person.get_last_name();


        //changing the last name
        Person.change_last_name(new_last_name);
        personnel_hash.put(id, Person);

        //update hashmap by last_name
        if (last_name_map.containsKey(last_name)) //
        {
            //remove Person from the old key
            List<String> last_name_list = last_name_map.get(last_name);
            last_name_list.remove(id);
            last_name_map.put(last_name, last_name_list);

            //add person to the new key
            if (last_name_map.containsKey(new_last_name)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_last_name_list = last_name_map.get(new_last_name);
                new_last_name_list.add(id);
                last_name_map.put(new_last_name, new_last_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_last_name_list = new ArrayList<>();
                created_last_name_list.add(id);
                last_name_map.put(new_last_name, created_last_name_list);
            }

        }
        else
        {
            if (last_name_map.containsKey(new_last_name)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_last_name_list = last_name_map.get(new_last_name);
                new_last_name_list.add(id);
                last_name_map.put(new_last_name, new_last_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_last_name_list = new ArrayList<>();
                created_last_name_list.add(id);
                last_name_map.put(new_last_name, created_last_name_list);
            }
        }
    }

    public void update_department(String id, String new_department)
    {
        Personnel Person = personnel_hash.get(id);
        String department = Person.get_department();



        //changing the department
        Person.change_department(new_department);
        personnel_hash.put(id, Person);

        //update hashmap by department
        if (department_map.containsKey(department)) //
        {
            //remove Person from the old key
            List<String> department_list = department_map.get(department);
            department_list.remove(id);
            department_map.put(department, department_list);

            //add person to the new key
            if (department_map.containsKey(department)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_department_list = department_map.get(new_department);
                new_department_list.add(id);
                department_map.put(new_department, new_department_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_department_list = new ArrayList<>();
                created_department_list.add(id);
                department_map.put(new_department, created_department_list);
            }

        }
        else
        {
            if (department_map.containsKey(new_department)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_department_list = department_map.get(new_department);
                new_department_list.add(id);
                department_map.put(new_department, new_department_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_department_list = new ArrayList<>();
                created_department_list.add(id);
                department_map.put(new_department, created_department_list);
            }
        }
    }

    public void update_join_year(String id, int new_join_year)
    {
        Personnel Person = personnel_hash.get(id);
        Integer join_year = Person.get_join_year();



        //changing the join year
        Person.change_join_year(new_join_year);
        personnel_hash.put(id, Person);

        //update hashmap by join_year
        if (join_year_map.containsKey(join_year)) //
        {
            //remove Person from the old key
            List<String> join_year_list = join_year_map.get(join_year);
            join_year_list.remove(id);
            join_year_map.put(join_year, join_year_list);

            //add person to the new key
            if (join_year_map.containsKey(join_year)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_join_year_list = join_year_map.get(new_join_year);
                new_join_year_list.add(id);
                join_year_map.put(new_join_year, new_join_year_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_join_year_list = new ArrayList<>();
                created_join_year_list.add(id);
                join_year_map.put(new_join_year, created_join_year_list);
            }

        }
        else
        {
            if (join_year_map.containsKey(new_join_year)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_join_year_list = join_year_map.get(new_join_year);
                new_join_year_list.add(id);
                join_year_map.put(new_join_year, new_join_year_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_join_year_list = new ArrayList<>();
                created_join_year_list.add(id);
                join_year_map.put(new_join_year, created_join_year_list);
            }
        }
    }
    
    public void update_status(String id, boolean new_status)
    {
        Personnel Person = personnel_hash.get(id);
        boolean status = Person.get_faculty().get_full_time();

        //changing the first name
        Person.get_faculty().change_full_time(new_status);
        personnel_hash.put(id, Person);

        

        //update hashmap by first_name
        if (status_map.containsKey(status)) //
        {
            //remove Person from the old key
            List<String> status_list = status_map.get(status);
            status_list.remove(id);
            status_map.put(status, status_list);

            //add person to the new key
            if (status_map.containsKey(new_status)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_status_list = status_map.get(new_status);
                new_status_list.add(id);
                status_map.put(new_status, new_status_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_status_list = new ArrayList<>();
                created_status_list.add(id);
                status_map.put(new_status, created_status_list);
            }

        }
        else
        {
            if (status_map.containsKey(new_status)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_status_list = status_map.get(new_status);
                new_status_list.add(id);
                status_map.put(new_status, new_status_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_status_list = new ArrayList<>();
                created_status_list.add(id);
                status_map.put(new_status, created_status_list);
            }
        }

    }

    public void update_sabbatical(String id, boolean new_sabbatical)
    {
        Personnel Person = personnel_hash.get(id);
        boolean sabbatical = Person.get_faculty().get_sabbatical();

        //changing the first name
        Person.get_faculty().change_sabbatical(new_sabbatical);
        personnel_hash.put(id, Person);

        //update hashmap by first_name
        if (sabbatical_map.containsKey(sabbatical)) //
        {
            //remove Person from the old key
            List<String> sabbatical_list = sabbatical_map.get(sabbatical);
            sabbatical_list.remove(id);
            sabbatical_map.put(sabbatical, sabbatical_list);

            //add person to the new key
            if (sabbatical_map.containsKey(new_sabbatical)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_sabbatical_list = sabbatical_map.get(new_sabbatical);
                new_sabbatical_list.add(id);
                sabbatical_map.put(new_sabbatical, new_sabbatical_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_sabbatical_list = new ArrayList<>();
                created_sabbatical_list.add(id);
                sabbatical_map.put(new_sabbatical, created_sabbatical_list);
            }

        }
        else
        {
            if (sabbatical_map.containsKey(new_sabbatical)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_sabbatical_list = sabbatical_map.get(new_sabbatical);
                new_sabbatical_list.add(id);
                sabbatical_map.put(new_sabbatical, new_sabbatical_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_sabbatical_list = new ArrayList<>();
                created_sabbatical_list.add(id);
                sabbatical_map.put(new_sabbatical, created_sabbatical_list);
            }
        }

    }

    public void update_courses_teaching(String id, Integer new_courses)
    {
        Personnel Person = personnel_hash.get(id);
        Integer courses = Person.get_faculty().get_courses_teaching();



        //changing the first name
        Person.get_faculty().changes_courses_teaching(new_courses);
        personnel_hash.put(id, Person);

        //update hashmap by first_name
        if (num_of_courses_map.containsKey(courses)) //
        {
            //remove Person from the old key
            List<String> courses_list = num_of_courses_map.get(courses);
            courses_list.remove(id);
            num_of_courses_map.put(courses, courses_list);

            //add person to the new key
            if (num_of_courses_map.containsKey(new_courses)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_courses_list = num_of_courses_map.get(new_courses);
                new_courses_list.add(id);
                num_of_courses_map.put(new_courses, new_courses_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_courses_list = new ArrayList<>();
                created_courses_list.add(id);
                num_of_courses_map.put(new_courses, created_courses_list);
            }

        }
        else
        {
            if (num_of_courses_map.containsKey(new_courses)) //if there is already a key for the new_name in the hashmap
            {
                List<String> new_courses_list = num_of_courses_map.get(new_courses);
                new_courses_list.add(id);
                num_of_courses_map.put(new_courses, new_courses_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<String> created_courses_list = new ArrayList<>();
                created_courses_list.add(id);
                num_of_courses_map.put(new_courses, created_courses_list);
            }
        }

    }


    public void update_sex(String id, String new_sex)
    {
        Personnel Person = personnel_hash.get(id);
        //changing the sex
        Person.change_sex(new_sex);
        personnel_hash.put(id, Person);
    }

    // Update email_address
    public void update_email_address(String id, String new_email_address)
    {
        Personnel person = personnel_hash.get(id);

        // Changing the email_address
        person.change_email_address(new_email_address);
        personnel_hash.put(id, person);
    }

    // Update role
    public void update_role(String id, String new_role)
    {
        Personnel person = personnel_hash.get(id);

        // Changing the role
        person.change_role(new_role);
        personnel_hash.put(id, person);
    }

    // Update bio
    public void update_bio(String id, String new_bio)
    {
        Personnel person = personnel_hash.get(id);

        // Changing the bio
        person.change_bio(new_bio);
        personnel_hash.put(id, person);
    }

    // Update school_web_link
    public void update_school_web_link(String id, String new_school_web_link)
    {
        Personnel person = personnel_hash.get(id);

        // Changing the school_web_link
        person.change_school_web_link(new_school_web_link);
        personnel_hash.put(id, person);
    }

    // Update volunteer_activities
    public void update_volunteer_activities(String id, String new_volunteer_activities)
    {
        Personnel person = personnel_hash.get(id);

        // Changing the volunteer_activities
        person.change_volunteer_activities(new_volunteer_activities);
        personnel_hash.put(id, person);
    }

    // Update on_leave
    public void update_on_leave(String id, String new_on_leave)
    {
        Personnel person = personnel_hash.get(id);

        // Changing the on_leave status
        person.change_on_leave(new_on_leave);
        personnel_hash.put(id, person);
    }








    // Have to remove all of these attributes in order to also remove
    // from the other hashmaps
    public void remove_person(String id) {
        Personnel Person = personnel_hash.get(id);
        remove_first_name(id);
        remove_last_name(id);
        remove_department(id);
        remove_join_year(id);

        if (Person.get_faculty() != null) {
            remove_status(id);
            remove_sabbatical(id);
            remove_courses(id);
        }
        personnel_hash.remove(id);
    }

    //removing attributes
    //method for removing personnel
    public void remove_first_name(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        String old_first_name = Person.get_first_name(); //getting the first name that will be removed
        Person.remove_first_name(); //removed the first_name from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by first_name
        if (first_name_map.containsKey(old_first_name))
        {
            List<String> first_name_list = first_name_map.get(old_first_name);
            first_name_list.remove(id);
            first_name_map.put(old_first_name, first_name_list);
        }
    }

    public void remove_last_name(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        String old_last_name = Person.get_last_name(); //getting the last name that will be removed
        Person.remove_last_name(); //removed the last_name from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by last_name
        

        if (last_name_map.containsKey(old_last_name))
        {
            List<String> last_name_list = last_name_map.get(old_last_name);
            last_name_list.remove(id);
            last_name_map.put(old_last_name, last_name_list);
        }

    }

    public void remove_department(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        String old_department = Person.get_department(); //getting the department that will be removed
        Person.remove_department(); //removed the department from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap
        

        //remove by department
        if (department_map.containsKey(old_department))
        {
            List<String> department_list = department_map.get(old_department);
            department_list.remove(id);
            department_map.put(old_department, department_list);
        }
    }

    public void remove_join_year(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        Integer old_join_year = Person.get_join_year(); //getting the join_year that will be removed
        Person.remove_join_year(); //removed the join_year from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by join year
        if (join_year_map.containsKey(old_join_year))
        {
            List<String> join_year_list = join_year_map.get(old_join_year);
            join_year_list.remove(id);
            join_year_map.put(old_join_year, join_year_list);
        }
    }

    public void remove_status(String id) {
        Personnel Person = personnel_hash.get(id);
        boolean old_status = Person.get_faculty().get_full_time();

        if (status_map.containsKey(old_status)) {
            List<String> status_list = status_map.get(old_status);
            status_list.remove(id);
            status_map.put(old_status, status_list);
        }
    }

    public void remove_sabbatical(String id) {
        Personnel Person = personnel_hash.get(id);
        boolean old_sabbatical = Person.get_faculty().get_sabbatical();

        if (sabbatical_map.containsKey(old_sabbatical)) {
            List<String> sabbatical_list = sabbatical_map.get(old_sabbatical);
            sabbatical_list.remove(id);
            sabbatical_map.put(old_sabbatical, sabbatical_list);
        }
    }

    public void remove_courses(String id) {
        Personnel Person = personnel_hash.get(id);
        Integer old_courses = Person.get_faculty().get_courses_teaching();

        if (num_of_courses_map.containsKey(old_courses)) {
            List<String> courses_list = num_of_courses_map.get(old_courses);
            courses_list.remove(id);
            num_of_courses_map.put(old_courses, courses_list);
        }
    }

    public void remove_sex(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        Person.remove_sex(); //removed the join_year from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id 
    }

    public void remove_email_address(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_email_address(); 
        personnel_hash.put(id, person);
    }

    public void remove_role(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_role(); 
        personnel_hash.put(id, person); 
    }

    // Remove bio
    public void remove_bio(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_bio(); 
        personnel_hash.put(id, person); 

    }

    // Remove volunteer_activities
    public void remove_volunteer_activities(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_volunteer_activities(); 
        personnel_hash.put(id, person); 
    }

    // Remove on_leave
    public void remove_on_leave(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_on_leave(); 
        personnel_hash.put(id, person); 
    }











    //printing personnel
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

    // prints out entire hashmap
    public void viewMap() {
        for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
            printPersonnel(entry.getKey());
        }
    }

    // writes hashmap to summary.txt based on hierarchy
    public void aggregate() {

        try {
            FileWriter summaryWrite = new FileWriter("summary.txt");
            // used to store all departments found
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

                summaryWrite.write("\n---Department Head of " + department + "---\n");
                for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if(entry.getValue().get_role().equals("Department Head") && entry.getValue().get_department().equals(department)) {
                        summaryWrite.write(printPersonnel(entry.getKey()));
    
                        // break due to only one dep head
                        break;
                    }
                }
                // Profs
                summaryWrite.write("\n---" + department + " Professors---\n");
                for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if(entry.getValue().get_role().equals("Professor") && entry.getValue().get_department().equals(department)) {
                        summaryWrite.write(printPersonnel(entry.getKey()));
                    }
                }
    
                // Volunteers
                summaryWrite.write("\n---" + department + " Volunteers---\n");
                for(HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if(entry.getValue().get_role().equals("Volunteer") && entry.getValue().get_department().equals(department)) {
                        summaryWrite.write(printPersonnel(entry.getKey()));
                    }
                }
                
                // Other
                summaryWrite.write("\n---Others from " + department + "---\n");
                for (HashMap.Entry<String, Personnel> entry : personnel_hash.entrySet()) {
                    if (
                        !entry.getValue().get_role().equals("President") &&
                        !entry.getValue().get_role().equals("Department Head") &&
                        !entry.getValue().get_role().equals("Professor") && 
                        !entry.getValue().get_role().equals("Volunteer") &&
                        entry.getValue().get_department().equals(department)
                        ) 
                        {
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
        update_status(id, new_faculty.get_full_time());
        update_sabbatical(id, new_faculty.get_sabbatical());
        update_courses_teaching(id, new_faculty.get_courses_teaching());
    }

    //lookup
    public void lookup_by_id(String id)
    {
        if (personnel_hash.containsKey(id))
        {
            printPersonnel(id);
        }
        else
        {
            System.out.println("ID not found");
        }
    }

    public void lookup_by_first_name(String first_name)
    {
        if (first_name_map.containsKey(first_name))
        {
            List<String> person_list = first_name_map.get(first_name);
            for (int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("There is no such first name");
        }
    }

    public void lookup_by_last_name( String last_name)
    {
        if (last_name_map.containsKey(last_name))
        {
            List<String> person_list = last_name_map.get(last_name);
            for(int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("There is no such last name");
        }
    }

    public void lookup_by_department(String department)
    {
        if (department_map.containsKey(department))
        {
            List<String> person_list = department_map.get(department);
            for(int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("There is no such department");
        }
    }

    public void lookup_by_join_year(Integer join_year)
    {
        if (join_year_map.containsKey(join_year))
        {
            List<String> person_list = join_year_map.get(join_year);
            for(int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("Join year not found");
        }
    }

    public void lookup_by_status(boolean status)
    {
        if (status_map.containsKey(status))
        {
            List<String> person_list = status_map.get(status);
            for (int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("There is no such status");
        }
    }

    public void lookup_by_sabbatical(boolean  sabbatical)
    {
        if (sabbatical_map.containsKey(sabbatical))
        {
            List<String> person_list = sabbatical_map.get(sabbatical);
            for (int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("There is no such sabbatical");
        }
    }

    public void lookup_by_courses(Integer courses)
    {
        if (num_of_courses_map.containsKey(courses))
        {
            List<String> person_list = num_of_courses_map.get(courses);
            for (int counter = 0; counter < person_list.size(); counter++)
            {
                printPersonnel(person_list.get(counter));
            }
        }
        else
        {
            System.out.println("There is no such number of courses");
        }
    }
}
