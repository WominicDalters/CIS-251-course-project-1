import java.io.FileWriter;
import java.io.IOException;
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
    //adding
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










    //updating attributes
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

    public void update_last_name(String id, String new_last_name)
    {
        Personnel Person = personnel_hash.get(id);
        String first_name = Person.get_first_name();
        String last_name = Person.get_last_name();
        String department = Person.get_department();
        Integer join_year = Person.get_join_year();



        //changing the last name
        Person.change_last_name(new_last_name);
        personnel_hash.put(id, Person);

        //update hashmap by last_name
        if (last_name_map.containsKey(last_name)) //
        {
            //remove Person from the old key
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.remove(Person);
            last_name_map.put(last_name, last_name_list);

            //add person to the new key
            if (last_name_map.containsKey(new_last_name)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_last_name_list = last_name_map.get(new_last_name);
                new_last_name_list.add(Person);
                last_name_map.put(new_last_name, new_last_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_last_name_list = new ArrayList<>();
                created_last_name_list.add(Person);
                last_name_map.put(new_last_name, created_last_name_list);
            }

        }
        else
        {
            if (last_name_map.containsKey(new_last_name)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_last_name_list = last_name_map.get(new_last_name);
                new_last_name_list.add(Person);
                last_name_map.put(new_last_name, new_last_name_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_last_name_list = new ArrayList<>();
                created_last_name_list.add(Person);
                last_name_map.put(new_last_name, created_last_name_list);
            }
        }

        //update hashmap by first name
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

    public void update_department(String id, String new_department)
    {
        Personnel Person = personnel_hash.get(id);
        String first_name = Person.get_first_name();
        String last_name = Person.get_last_name();
        String department = Person.get_department();
        Integer join_year = Person.get_join_year();



        //changing the department
        Person.change_department(new_department);
        personnel_hash.put(id, Person);

        //update hashmap by department
        if (department_map.containsKey(department)) //
        {
            //remove Person from the old key
            List<Personnel> department_list = department_map.get(department);
            department_list.remove(Person);
            department_map.put(department, department_list);

            //add person to the new key
            if (department_map.containsKey(department)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_department_list = department_map.get(new_department);
                new_department_list.add(Person);
                department_map.put(new_department, new_department_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_department_list = new ArrayList<>();
                created_department_list.add(Person);
                department_map.put(new_department, created_department_list);
            }

        }
        else
        {
            if (department_map.containsKey(new_department)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_department_list = department_map.get(new_department);
                new_department_list.add(Person);
                department_map.put(new_department, new_department_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_department_list = new ArrayList<>();
                created_department_list.add(Person);
                department_map.put(new_department, created_department_list);
            }
        }

        //update hashmap by first name
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

        //update hashmap by last_name
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

    public void update_join_year(String id, int new_join_year)
    {
        Personnel Person = personnel_hash.get(id);
        String first_name = Person.get_first_name();
        String last_name = Person.get_last_name();
        String department = Person.get_department();
        Integer join_year = Person.get_join_year();



        //changing the join year
        Person.change_join_year(new_join_year);
        personnel_hash.put(id, Person);

        //update hashmap by join_year
        if (join_year_map.containsKey(join_year)) //
        {
            //remove Person from the old key
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.remove(Person);
            join_year_map.put(join_year, join_year_list);

            //add person to the new key
            if (join_year_map.containsKey(join_year)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_join_year_list = join_year_map.get(new_join_year);
                new_join_year_list.add(Person);
                join_year_map.put(new_join_year, new_join_year_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_join_year_list = new ArrayList<>();
                created_join_year_list.add(Person);
                join_year_map.put(new_join_year, created_join_year_list);
            }

        }
        else
        {
            if (join_year_map.containsKey(new_join_year)) //if there is already a key for the new_name in the hashmap
            {
                List<Personnel> new_join_year_list = join_year_map.get(new_join_year);
                new_join_year_list.add(Person);
                join_year_map.put(new_join_year, new_join_year_list);
            }
            else //if there is no key for the name in teh hashmap
            {
                List<Personnel> created_join_year_list = new ArrayList<>();
                created_join_year_list.add(Person);
                join_year_map.put(new_join_year, created_join_year_list);
            }
        }

        //update hashmap by first name
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

        //update hashmap by last_name
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
            List<Personnel> person_list = department_map.get(department);
            person_list.add(Person);
            department_map.put(department, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(Person);
            department_map.put(department, new_person_list);
        }
    }
    
    public void update_sex(String id, String new_sex)
    {
        Personnel Person = personnel_hash.get(id);
        String first_name = Person.get_first_name();
        String last_name = Person.get_last_name();
        String department = Person.get_department();
        Integer join_year = Person.get_join_year();



        //changing the sex
        Person.change_sex(new_sex);
        personnel_hash.put(id, Person);

        //update hashmap by first_name
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

    // Update email_address
    public void update_email_address(String id, String new_email_address)
    {
        Personnel person = personnel_hash.get(id);
        String first_name = person.get_first_name();
        String last_name = person.get_last_name();
        String department = person.get_department();
        Integer join_year = person.get_join_year();

        // Changing the email_address
        person.change_email_address(new_email_address);
        personnel_hash.put(id, person);

        // Update hashmap by first_name
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(person);
            join_year_map.put(join_year, new_person_list);
        }
    }

    // Update role
    public void update_role(String id, String new_role)
    {
        Personnel person = personnel_hash.get(id);
        String first_name = person.get_first_name();
        String last_name = person.get_last_name();
        String department = person.get_department();
        Integer join_year = person.get_join_year();

        // Changing the role
        person.change_role(new_role);
        personnel_hash.put(id, person);

        // Update hashmap by first_name
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(person);
            join_year_map.put(join_year, new_person_list);
        }
    }

    // Update bio
    public void update_bio(String id, String new_bio)
    {
        Personnel person = personnel_hash.get(id);
        String first_name = person.get_first_name();
        String last_name = person.get_last_name();
        String department = person.get_department();
        Integer join_year = person.get_join_year();

        // Changing the bio
        person.change_bio(new_bio);
        personnel_hash.put(id, person);

        // Update hashmap by first_name
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(person);
            join_year_map.put(join_year, new_person_list);
        }
    }

    // Update school_web_link
    public void update_school_web_link(String id, String new_school_web_link)
    {
        Personnel person = personnel_hash.get(id);
        String first_name = person.get_first_name();
        String last_name = person.get_last_name();
        String department = person.get_department();
        Integer join_year = person.get_join_year();

        // Changing the school_web_link
        person.change_school_web_link(new_school_web_link);
        personnel_hash.put(id, person);

        // Update hashmap by first_name
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(person);
            join_year_map.put(join_year, new_person_list);
        }
    }

    // Update volunteer_activities
    public void update_volunteer_activities(String id, String new_volunteer_activities)
    {
        Personnel person = personnel_hash.get(id);
        String first_name = person.get_first_name();
        String last_name = person.get_last_name();
        String department = person.get_department();
        Integer join_year = person.get_join_year();

        // Changing the volunteer_activities
        person.change_volunteer_activities(new_volunteer_activities);
        personnel_hash.put(id, person);

        // Update hashmap by first_name
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(person);
            join_year_map.put(join_year, new_person_list);
        }
    }

    // Update on_leave
    public void update_on_leave(String id, String new_on_leave)
    {
        Personnel person = personnel_hash.get(id);
        String first_name = person.get_first_name();
        String last_name = person.get_last_name();
        String department = person.get_department();
        Integer join_year = person.get_join_year();

        // Changing the on_leave status
        person.change_on_leave(new_on_leave);
        personnel_hash.put(id, person);

        // Update hashmap by first_name
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Update hashmap by last name
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Update hashmap by department
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Update hashmap by join year
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> person_list = join_year_map.get(join_year);
            person_list.add(person);
            join_year_map.put(join_year, person_list);
        }
        else
        {
            List<Personnel> new_person_list = new ArrayList<>();
            new_person_list.add(person);
            join_year_map.put(join_year, new_person_list);
        }
    }










    //removing attributes
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
            List<Personnel> first_name_list = first_name_map.get(old_first_name);
            first_name_list.remove(Person);
            first_name_map.put(old_first_name, first_name_list);
        }


        //remove by last_name
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

        //remove by department
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


        //remove by join year
        int join_year = Person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }


    }

    public void remove_last_name(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        String old_last_name = Person.get_last_name(); //getting the last name that will be removed
        Person.remove_last_name(); //removed the last_name from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by first_name
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


        //remove by last_name
        

        if (last_name_map.containsKey(old_last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(old_last_name);
            last_name_list.remove(Person);
            last_name_map.put(old_last_name, last_name_list);
        }

        //remove by department
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


        //remove by join year
        int join_year = Person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    public void remove_department(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        String old_department = Person.get_department(); //getting the department that will be removed
        Person.remove_department(); //removed the department from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by first_name
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


        //remove by last_name
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
        

        //remove by department
        if (department_map.containsKey(old_department))
        {
            List<Personnel> department_list = department_map.get(old_department);
            department_list.remove(Person);
            department_map.put(old_department, department_list);
        }


        //remove by join year
        int join_year = Person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }


    }

    public void remove_join_year(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        Integer old_join_year = Person.get_join_year(); //getting the join_year that will be removed
        Person.remove_join_year(); //removed the join_year from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by first_name
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


        //remove by last_name
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
        

        //remove by department
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

        


        //remove by join year
        if (join_year_map.containsKey(old_join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(old_join_year);
            join_year_list.remove(Person);
            join_year_map.put(old_join_year, join_year_list);
        }
    }

    public void remove_sex(String id)
    {
        //remove by id
        Personnel Person = personnel_hash.get(id);
        Person.remove_sex(); //removed the join_year from the Personnel
        personnel_hash.put(id, Person); //putting the Person into the id hashmap

        //remove by first_name
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

        //remove by last_name
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

        //remove by department
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

        //remove by join year
        int join_year = Person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(Person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    public void remove_email_address(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_email_address(); 
        personnel_hash.put(id, person);

        // Remove by first_name
        String first_name = person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Remove by last_name
        String last_name = person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Remove by department
        String department = person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Remove by join year
        int join_year = person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    public void remove_role(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_role(); 
        personnel_hash.put(id, person); 

        // Remove by first_name
        String first_name = person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Remove by last_name
        String last_name = person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Remove by department
        String department = person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Remove by join year
        int join_year = person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    // Remove bio
    public void remove_bio(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_bio(); 
        personnel_hash.put(id, person); 

        // Remove by first_name
        String first_name = person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Remove by last_name
        String last_name = person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Remove by department
        String department = person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Remove by join year
        int join_year = person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    // Remove school_web_link
    public void remove_school_web_link(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_school_web_link();
        personnel_hash.put(id, person);

        // Remove by first_name
        String first_name = person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Remove by last_name
        String last_name = person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Remove by department
        String department = person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Remove by join year
        int join_year = person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    // Remove volunteer_activities
    public void remove_volunteer_activities(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_volunteer_activities(); 
        personnel_hash.put(id, person); 

        // Remove by first_name
        String first_name = person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Remove by last_name
        String last_name = person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Remove by department
        String department = person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Remove by join year
        int join_year = person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
    }

    // Remove on_leave
    public void remove_on_leave(String id)
    {
        // Remove by id
        Personnel person = personnel_hash.get(id);
        person.remove_on_leave(); 
        personnel_hash.put(id, person); 
        // Remove by first_name
        String first_name = person.get_first_name();
        if (first_name_map.containsKey(first_name))
        {
            List<Personnel> first_name_list = first_name_map.get(first_name);
            first_name_list.add(person);
            first_name_map.put(first_name, first_name_list);
        }
        else
        {
            List<Personnel> new_first_name_list = new ArrayList<>();
            new_first_name_list.add(person);
            first_name_map.put(first_name, new_first_name_list);
        }

        // Remove by last_name
        String last_name = person.get_last_name();
        if (last_name_map.containsKey(last_name))
        {
            List<Personnel> last_name_list = last_name_map.get(last_name);
            last_name_list.add(person);
            last_name_map.put(last_name, last_name_list);
        }
        else
        {
            List<Personnel> new_last_name_list = new ArrayList<>();
            new_last_name_list.add(person);
            last_name_map.put(last_name, new_last_name_list);
        }

        // Remove by department
        String department = person.get_department();
        if (department_map.containsKey(department))
        {
            List<Personnel> department_list = department_map.get(department);
            department_list.add(person);
            department_map.put(department, department_list);
        }
        else
        {
            List<Personnel> new_department_list = new ArrayList<>();
            new_department_list.add(person);
            department_map.put(department, new_department_list);
        }

        // Remove by join year
        int join_year = person.get_join_year();
        if (join_year_map.containsKey(join_year))
        {
            List<Personnel> join_year_list = join_year_map.get(join_year);
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
        else
        {
            List<Personnel> join_year_list = new ArrayList<>();
            join_year_list.add(person);
            join_year_map.put(join_year, join_year_list);
        }
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
    /*
    public void change_volunteer_activities(String id, String new_volunteer_activities) {
        personnel_hash.get(id).change_volunteer_activities(new_volunteer_activities);
    }

    public void change_on_leave(String id, String new_on_leave) {
        personnel_hash.get(id).change_on_leave(new_on_leave);
    }
    */

    //lookup
    static void lookup_by_id()
    {

    }

    static void lookup_by_first_name()
    {

    }

    static void lookup_by_last_name()
    {

    }

    static void lookup_by_department()
    {

    }

    static void lookup_by_join_year()
    {

    }
}
