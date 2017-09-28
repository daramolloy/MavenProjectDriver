package com.mycompany.mavenproject;
import java.util.*;

/**
 *
 * @author daram
 */
public class MainRunner {
    public static void main(String[] args) {

        //Creating first Student array list and adding 6 students
        List<Student> StudentListA= new ArrayList<Student>();
        StudentListA.add(new Student("Michael","1/12/1990",1));
        StudentListA.add(new Student("John","2/12/1991",2));
        StudentListA.add(new Student("Louise","3/12/1992",3));
        StudentListA.add(new Student("Fearghal","4/12/1993",4));
        StudentListA.add(new Student("Martin","5/12/1994",5));
        StudentListA.add(new Student("Liam","6/12/1995",6));

        //Creating second Student array list and adding 6 more students
        List<Student> StudentListB= new ArrayList<Student>();
        StudentListB.add(new Student("Aidan","7/12/1990",7));
        StudentListB.add(new Student("Conor","8/12/1991",8));
        StudentListB.add(new Student("Linda","9/12/1992",9));
        StudentListB.add(new Student("Patrick","10/12/1993",10));
        StudentListB.add(new Student("Sarah","12/12/1994",11));
        StudentListB.add(new Student("Oisin","13/12/1995",12));

        //Creating Module array list and adding 4 Student lists, the first two with StudentListA and
        //the second two with StudentListB
        List<Module> ModuleList= new ArrayList<Module>();
        ModuleList.add(new Module("Digital Signal Processing","EE445",StudentListA));
        ModuleList.add(new Module("Telecommunications","EE453",StudentListA));
        ModuleList.add(new Module("System on Chip","EE451",StudentListB));
        ModuleList.add(new Module("Machine Learning & Data Mining","CT475",StudentListB));

        //Creating the course and adding the module list
        CourseProgramme ECE = new CourseProgramme("ECE", ModuleList, "25/08/2017","05/05/2018");

        //Creating a new arraylist of student to get all the student objects into 1 arraylist
        List<Student> allStud = new ArrayList<Student>();
        //Creating a hashmap to allow students to be linked to their modules
        HashMap<Student, ArrayList<String>> hmap = new HashMap<Student, ArrayList<String>>();

        //For all students, if student not present in the list, add to the list and initialise hmap
        for (Module mods : ECE.getModuleList()){
            for(Student studs : mods.getStudentList()){
                if (!allStud.contains(studs)){
                    allStud.add(studs);
                   hmap.put(studs, new ArrayList<String>());
                }
            }
        }

        //For all modules and every student, if student is present in any student list,
        //add the corresponding module name to the hmap
        for (Module mods : ECE.getModuleList()){
            for(Student a : allStud){
                if (mods.getStudentList().contains(a)){
                    hmap.get(a).add(mods.getModuleName());
                }
            }
        }

        //Printing section of the code, prints username, each string in the hmap arraylist and
        //the only course that we have created
        for(Student b : allStud){
            System.out.println("Username: " + b.getUsername());
            System.out.println("Modules:");
            for (int c = 0; c < hmap.get(b).size(); c++){
                System.out.println("       " + hmap.get(b).get(c));
            }
            System.out.println("Course: " + ECE.getCourseName());
            System.out.println("\n");
        }

    }

}
