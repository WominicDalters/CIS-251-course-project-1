//Dominic Walters
//

public class Personnel 
{
    //Attributes
    private String employee_id;
    private String first_name;
    private String last_name;
    private String sex;
    private String email_address;
    private String department;
    private String role;
    private int join_year;
    private String bio;
    private String school_web_link;
    private String volunteer_activities;
    private boolean on_leave;

    //Contructor
    public Personnel(String id, String f_name, String l_name, String s, 
                     String email, String dep, String r, int join_y,
                     String biography, String s_w_link, String v_activities,
                     boolean leave)
    {
        this.employee_id = id;
        this.first_name = f_name;
        this.last_name = l_name;
        this.sex = s;
        this.email_address = email;
        this.department = dep;
        this.role = r;
        this.join_year = join_y;
        this.bio = biography;
        this.school_web_link = s_w_link;
        this.volunteer_activities = v_activities;
        this.on_leave = leave;
    }

    //Methods
        //Method to get employee id
    public String get_employee_id()
    {
        return employee_id;
    }

        //Method to get first name
    public String get_first_name()
    {
        return first_name;
    }
        
        //Method to get last name
    public String get_last_name()
    {
        return last_name;
    }


        //so on, so forth...
    public String get_sex()
    {
        return sex;
    }

    public String get_email_address()
    {
        return email_address;
    }

    public String get_department()
    {
        return department;
    }

    public String get_role()
    {
        return role;
    }

    public int get_join_year()
    {
        return join_year;
    }

    public String get_bio()
    {
        return bio;
    }

    public String get_school_web_link()
    {
        return school_web_link;
    }

    public String get_volunteer_activities()
    {
        return volunteer_activities;
    }

    public boolean get_on_leave()
    {
        return on_leave;
    }


}
