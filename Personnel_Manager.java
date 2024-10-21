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

        //method for updating personnel


        //method for removing personnel
}
