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