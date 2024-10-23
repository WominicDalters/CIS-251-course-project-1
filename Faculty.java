// //Dominic Walters
// //

public class Faculty {
    private String employee_id;
    private boolean full_time;
    private boolean sabbatical;
    private int courses_teaching;

    public Faculty(String employee_id, boolean full_time, boolean sabbatical, int courses_teaching) {
        this.employee_id = employee_id;
        this.full_time = full_time;
        this.sabbatical = sabbatical;
        this.courses_teaching = courses_teaching;
    }

    public String get_employee_id() {
        return employee_id;
    }

    public boolean get_full_time()
    {
        return full_time;
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

    public boolean change_full_time(boolean new_full_time)
    {
        return full_time = new_full_time;
    }

    //mMethod to get sabbatical
    public boolean change_sabbatical(boolean new_sabbatical)
    {
        return sabbatical = new_sabbatical;
    }

    //Method to get courses
    public int changes_courses_teaching(int new_courses_teaching)
    {
        return courses_teaching = new_courses_teaching;
    }

}

// public class Faculty extends Personnel {
//     //Attributes
//     private boolean status;
//     private boolean sabbatical;
//     private int courses_teaching;

//     //constructor
//     public Faculty(String id, String f_name, String l_name, String s, 
//                    String email, String dep, String r, int join_y,
//                    String biography, String s_w_link, String v_activities,
//                    boolean leave, boolean stat, boolean sabbat, int courses)
//     {
//         super(id, f_name, l_name, s, email, dep, r, join_y, biography, 
//               s_w_link, v_activities, leave);

//         this.status = stat;
//         this.sabbatical = sabbat;
//         this.courses_teaching = courses;

//     }
    
//     //Method to get status
//     public boolean get_status()
//     {
//         return status;
//     }

//     //mMethod to get sabbatical
//     public boolean get_sabbatical()
//     {
//         return sabbatical;
//     }

//     //Method to get courses
//     public int get_courses_teaching()
//     {
//         return courses_teaching;
//     }

// }
