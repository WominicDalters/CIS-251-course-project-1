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
}
