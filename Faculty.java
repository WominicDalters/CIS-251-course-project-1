//Dominic Walters
//

public class Faculty extends Personnel {
    //Attributes
    private boolean status;
    private boolean sabbatical;
    private int courses_teaching;

    //constructor
    public Faculty(String id, String f_name, String l_name, String s, 
                   String email, String dep, String r, int join_y,
                   String biography, String s_w_link, String v_activities,
                   boolean leave, boolean stat, boolean sabbat, int courses)
    {
        super(id, f_name, l_name, s, email, dep, r, join_y, biography, 
              s_w_link, v_activities, leave);

        this.status = stat;
        this.sabbatical = sabbat;
        this.courses_teaching = courses;

    }
    
    //Method to get status
    public boolean get_status()
    {
        return status;
    }

    //mMethod to get sabbatical
    public boolean get_sabbatical()
    {
        return sabbatical;
    }

    //Method to get courses
    public int get_courses_teaching()
    {
        return courses_teaching;
    }

}
