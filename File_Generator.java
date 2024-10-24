import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Random;
import java.util.ArrayList;

public class File_Generator {

    private String[] firstNameList = {
        "Abe",
        "Bob",
        "Chris",
        "Daisy",
        "Edward",
        "Fred",
        "Gwen",
        "Hailey",
        "Ian",
        "Jack",
        "Kate",
        "Liam",
        "Michelle",
        "Naomi",
        "Olivia",
        "Pat",
    };

    private String[] lastNameList = {
        "Ace",
        "Bonnell",
        "Chase",
        "Halpert",
        "Jones",
        "Scott",
        "Smith"
    };

    private String[] departmentList = {
        "English",
        "Math",
        "Physics",
        "History"
    };

    private String[] roleList = {
        "Professor"
    };

    public void generate_all(int n) {

        Random random = new Random();

        try 
        {
            FileWriter basicWrite = new FileWriter("test_basic_info.txt");
            FileWriter addWrite = new FileWriter("test_additional_info.txt");
            FileWriter facWrite = new FileWriter("test_faculty_info.txt");


            ArrayList<String> usedIds = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                String rEmpId = String.valueOf(random.nextInt(10)) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);

                while (usedIds.contains(rEmpId)) {
                    rEmpId = String.valueOf(random.nextInt(10)) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
                }

                usedIds.add(rEmpId);

                // for president and department heads hard coded
                if (i < departmentList.length + 1) {

                    if (i == 0) {
                        basicWrite.write(
                            rEmpId + 
                            "|John|Smith|m|johnsmith@email.com|admin|President|2000|They are good|ufv.ca/johnsmith\n"
                        );
                        addWrite.write(rEmpId +
                        "|Volunteerd 60 days|no\n"
                        );
                        facWrite.write(rEmpId +
                        "|full-time|n|0\n"
                        );
                    }
                    else if (i == 1) {
                        basicWrite.write(
                            rEmpId + 
                            "|Marie|Smith|f|mariesmith@email.com|English|Department Head|2000|They are good|ufv.ca/mariesmith\n"
                        );
                        addWrite.write(rEmpId +
                        "|Volunteerd 60 days|no\n"
                        );
                        facWrite.write(rEmpId +
                        "|full-time|n|0\n"
                        );
                    }
                    else if (i == 2) {
                        basicWrite.write(
                            rEmpId + 
                            "|Marla|Smith|f|marlasmith@email.com|Math|Department Head|2000|They are good|ufv.ca/marlasmith\n"
                        );
                        addWrite.write(rEmpId +
                        "|Volunteerd 60 days|no\n"
                        );
                        facWrite.write(rEmpId +
                        "|full-time|n|0\n"
                        );
                    }
                    else if (i == 3) {
                        basicWrite.write(
                            rEmpId + 
                            "|George|Smith|m|georgesmith@email.com|Physics|Department Head|2000|They are good|ufv.ca/georgesmith\n"
                        );
                        addWrite.write(rEmpId +
                        "|Volunteerd 60 days|no\n"
                        );
                        facWrite.write(rEmpId +
                        "|full-time|n|0\n"
                        );
                    }
                    else if (i == 4) {
                        basicWrite.write(
                            rEmpId + 
                            "|Dan|Smith|m|dansmith@email.com|History|Department Head|2000|They are good|ufv.ca/dansmith\n"
                        );
                        addWrite.write(rEmpId +
                        "|Volunteerd 60 days|no\n"
                        );
                        facWrite.write(rEmpId +
                        "|full-time|n|0\n"
                        );
                    }

                    continue;
                }

                boolean isFaculty = random.nextInt(2) == 0;

                String rFirstName = firstNameList[random.nextInt(firstNameList.length)];
                String rLastName = lastNameList[random.nextInt(lastNameList.length)];

                String rSex = "m";
                if (random.nextInt(2) == 0) {
                    rSex = "f";
                }

                String rEmail = rFirstName.toLowerCase() + "@email.com";

                String rDepartment = departmentList[random.nextInt(departmentList.length)];

                String rRole = "Volunteer";
                if(isFaculty) {
                    rRole = roleList[random.nextInt(roleList.length)];
                }

                String rJoinYear = String.valueOf(2000 + random.nextInt(25));

                String rBio = "They are good";
                if (random.nextInt(2) == 0) {
                    rBio = "They are bad";
                }

                String rWebLink = "none";
                if (random.nextInt(2) == 0) {
                    rWebLink = "ufv.ca/" + rFirstName + rLastName;
                }

                String rVolActivites = "Volunteered 0 days";
                if (random.nextInt(2) == 0) {
                    rVolActivites = "Volunteered 60 days";
                }

                String rLeaveStatus = "no";
                int tmpRand = random.nextInt(6);
                if (tmpRand == 0) {
                    rLeaveStatus = "vacation";
                }
                else if (tmpRand == 1) {
                    rLeaveStatus = "sick";
                }
                else if (tmpRand == 2) {
                    rLeaveStatus = "sabbatical";
                }
                else if (tmpRand == 3) {
                    rLeaveStatus = "parental";
                }
                else if (tmpRand == 4) {
                    rLeaveStatus = "maternity";
                }

                String rStatus = "";
                String rSab = "";
                String rNoCourses = "";
                if (isFaculty) {
                    rStatus = "full-time";
                    if (random.nextInt(2) == 0) {
                        rStatus = "part-time";
                    }

                    rSab = "n";
                    if (rLeaveStatus == "sabbatical") {
                        rSab = "y";
                    }

                    rNoCourses = String.valueOf(random.nextInt(6));
                }

                basicWrite.write(
                    rEmpId + "|" +
                    rFirstName + "|" +
                    rLastName + "|" +
                    rSex + "|" +
                    rEmail + "|" +
                    rDepartment + "|" +
                    rRole + "|" +
                    rJoinYear + "|" +
                    rBio + "|" +
                    rWebLink + "\n"
                );

                addWrite.write(
                    rEmpId + "|" +
                    rVolActivites + "|" +
                    rLeaveStatus + "\n"
                );

                if (isFaculty) {
                    facWrite.write(
                        rEmpId + "|" +
                        rStatus + "|" +
                        rSab + "|" +
                        rNoCourses + "\n"                    );
                }

            }



            basicWrite.close();
            addWrite.close();
            facWrite.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}