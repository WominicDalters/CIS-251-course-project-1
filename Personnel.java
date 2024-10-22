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
    private String on_leave;
    private Faculty faculty = null;

    //Contructor
    public Personnel(String id, String f_name, String l_name, String s, 
                     String email, String dep, String r, int join_y,
                     String biography, String s_w_link, String v_activities,
                     String leave)
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



        //Methods to remove individual attributes
    public void remove_first_name()
    {
        this.first_name = "";
    }

    public void remove_last_name()
    {
        this.last_name = "";
    }

    public void remove_sex()
    {
        this.sex = "";
    }

    public void remove_email_address()
    {
        this.email_address = "";
    }

    public void remove_department()
    {
        this.department = "";
    }

    public void remove_role()
    {
        this.role = "";
    }

    public void remove_join_year()
    {
        this.join_year = 0;
    }

    public void remove_bio()
    {
        this.bio = "";
    }

    public void remove_school_web_link()
    {
        this.school_web_link = "";
    }

    public void remove_volunteer_activities()
    {
        this.volunteer_activities = "";
    }

    public void remove_on_leave()
    {
        this.on_leave = "";
    }

    public void remove_faculty()
    {
        this.faculty = null;
    }



        //Methods to change individual attributes
    public String change_first_name(String new_first_name)
    {
        return this.first_name = new_first_name;
    }

    public String change_last_name(String new_last_name)
    {
        return this.last_name = new_last_name;
    }

    public String change_sex(String new_sex)
    {
        return this.sex = new_sex;
    }

    public String change_email_address(String new_email_address)
    {
        return this.email_address = new_email_address;
    }

    public String change_department(String new_department)
    {
        return this.department = new_department;
    }

    public String change_role(String new_role)
    {
        return this.role = new_role;
    }

    public int change_join_year(int new_join_year)
    {
        return this.join_year = new_join_year;
    }

    public String change_bio(String new_bio)
    {
        return this.bio = new_bio;
    }

    public String change_school_web_link(String new_school_web_link)
    {
        return this.school_web_link = new_school_web_link;
    }

    public String change_volunteer_activities(String new_volunteer_activities)
    {
        return this.volunteer_activities = new_volunteer_activities;
    }

    public String change_on_leave(String new_leave_status)
    {
        return this.on_leave = new_leave_status;
    }

    public Faculty change_faculty(Faculty new_faculty)
    {
        return this.faculty = new_faculty;
    }



        //Methods to get individual attributes
    public String get_employee_id()
    {
        return employee_id;
    }

    public String get_first_name()
    {
        return first_name;
    }
        
    public String get_last_name()
    {
        return last_name;
    }

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

    public String get_on_leave()
    {
        return on_leave;
    }

    public Faculty get_faculty() {
        return faculty;
    }


}