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

        //methods for updating personnel
    public void change_first_name(String id, String new_first_name)
    {
        //changing the first name
        Personnel Person = personnel_hash.get(id);
        Person.change_first_name(new_first_name);
        personnel_hash.put(id, Person);

        //update hashmap by name


        //update hashmap by department


        //update hashmap by join year
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
