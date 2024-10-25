# CIS 251 course project 1
 Designing and implementing a simple UFV personnel (including faculty and staff) management system.

## How it works
When you run the program, it is in testing mode by default. This means it will run a file generator to create 3 file: 

test_basic_info.txt
test_additional_info.txt
test_faculty.txt

It will fill these with random attributes for each employee.
If testing is off it will read from the non test files.

The program will then parse the info in these files and add them to a hashmap. The program then allows you to add, view, remove, and update the hashmap using the command line. If you exit the command line, the program will write the hashmap into summary.txt based on hierarchy of employees.