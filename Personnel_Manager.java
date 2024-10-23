
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

        //update name hashmap


        //update 
    }
}
