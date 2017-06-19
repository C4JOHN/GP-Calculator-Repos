
package DataWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class School {
    private String nameOfSchool;
    private  Integer numberOfFaculty;
    private   ObservableList<Faculties> faculties;
    private HashMap<String,Faculties> facultyMap;
   
    public School(String nameOfSchool){
         numberOfFaculty=0;
        faculties =FXCollections.observableArrayList();
        this.nameOfSchool=nameOfSchool;
        facultyMap=new HashMap();
        engineeringData();
        physicalScienceData();
        lifeScienceData();
        educationingData();
        agricData();
//        agricData();
    }

    public HashMap<String, Faculties> getFacultyMap() {
        return this.facultyMap;
    }
    public  String getNameOfSchool() {
        return this.nameOfSchool;
    }

    public  void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    public  Integer getNumberOfFaculty() {
        return this.numberOfFaculty;
    }

    public  ObservableList<Faculties> getFaculties() {
        return this.faculties;
    }
    public final void engineeringData(){
        
        // initializing faculties
         Faculties Engineering=new Faculties("Engineering");
         faculties.add(Engineering);
        
            //initializing departments for engineering
            Department Electrical=new Department(5,"Electrical/Electronics Engineering");
                    Levels electfirst=new Levels("100");
                    Levels electsecond=new Levels("200");
                    Levels electthird=new Levels("300");
                    Levels electfourth=new Levels("400");
                    Levels electfifth=new Levels("500");
                    Electrical.setLevels(electfirst,electsecond,electthird,electfourth,electfifth);
 
            Department Computer=new Department(5,"Computer Engineering");
            Department Mechanical=new Department(5,"Mechanical Engineering");
            Department Production=new Department(5,"Production Engineering");
            Department Civil=new Department(5,"Civil Engineering");
            Department Structural=new Department(5,"Structural Engineering");
            Department Chemical =new Department(5,"Chemical Engineering");
            Department Petroleum=new Department(5,"Petroleum Engineering");
            Engineering.setDepartments(Civil,Electrical,Computer,Mechanical,Production,Structural,Chemical,Petroleum);
           

            // settting general courses for 100 level
                //forFirstSemester
                Courses GST111=new Courses("Philosophy and Logic","GST 111",2);
                Courses GST112=new Courses("Use of Library","GST 121",2);
                Courses MTH110=new Courses("Algebra,Trigonometry and Statistic","MTH110",3);
                Courses MTH112=new Courses("Calculus","MTH112",3);
                Courses PHY111=new Courses("Vector","PHY111",3);
                Courses PHY113=new Courses("Wave and Properties","PHY113",3);
                Courses CHM111=new Courses("Inorganic Chemistry 1","CHM111",3);
                Courses CHM112=new Courses("Organic Chemistry 1","CHM112",3);
                Electrical.getLevelMaps().get("100")
                        .setFirstSemCourse(GST111,GST112,MTH110,MTH112,PHY111,PHY113,CHM111,CHM112);
            //forSecondSemester
            Courses GST121=new Courses("Peace and Conflict","GST 121",2);
            Courses GST122=new Courses("Nigeria; People and Culture","GST 122",2);
            Courses GST123=new Courses("History of Science and Technology","GST 123",2);
            Courses MTH125=new Courses("Differential Equations","MTH125",3);
            Courses MTH123=new Courses("Vector and Statistics","MTH123",3);
            Courses PHY124=new Courses("Electromagnetism","PHY124",3);
            Courses CHM121=new Courses("Inorganic Chemistry 2","CHM111",3);
            Courses CHM122=new Courses("Organic Chemistry 2","CHM112",3);
            Electrical.getLevelMaps().get("100")
                    .setSecSemCourse(GST121,GST122,GST123,MTH123,MTH125,PHY124,CHM121,CHM122);
                    Electrical.getLevelMaps().get("100").setAllCourses();

        facultyMap.put(Engineering.getNameOfFaculty(), Engineering);
     
    }
    
    public final void physicalScienceData(){
        
        // initializing faculties
         Faculties physicalScience=new Faculties("Physical Science");
         faculties.add(physicalScience);
        
            //initializing departments for engineering
            Department mathematics=new Department(4,"Mathematics");
                    Levels mathfirst=new Levels("100");
                    Levels mathsecond=new Levels("200");
                    Levels maththird=new Levels("300");
                    Levels mathfourth=new Levels("400");
                    mathematics.setLevels(mathfirst,mathsecond,maththird,mathfourth);
 
            Department geology=new Department(4,"Geology");
            Department chemistry=new Department(4,"Chemistry");
            Department computerScience=new Department(4,"Computer Science");
            Department physics=new Department(4,"Physics");
            physicalScience.setDepartments(geology,mathematics,computerScience,physics);
           

            // settting general courses for 100 level
                //forFirstSemester
                Courses GST111=new Courses("Philosophy and Logic","GST 111",3);
                Courses GST112=new Courses("Use of Library","GST 121",2);
                Courses MTH110=new Courses("Algebra,Trigonometry and Statistic","MTH110",3);
                Courses MTH112=new Courses("Calculus","MTH112",4);
                Courses PHY111=new Courses("Vector","PHY111",3);
                Courses PHY113=new Courses("Wave and Properties","PHY113",3);
                Courses CHM111=new Courses("Inorganic Chemistry 1","CHM111",3);
                Courses CHM112=new Courses("Organic Chemistry 1","CHM112",3);
                mathematics.getLevelMaps().get("100")
                        .setFirstSemCourse(GST111,GST112,MTH110,MTH112,PHY111,PHY113,CHM111,CHM112);
            //forSecondSemester
            Courses GST121=new Courses("Peace and Conflict","GST 121",5);
            Courses GST122=new Courses("Nigeria; People and Culture","GST 122",2);
            Courses GST123=new Courses("History of Science and Technology","GST 123",10);
            Courses MTH125=new Courses("Differential Equations","MTH125",3);
            Courses MTH123=new Courses("Vector and Statistics","MTH123",4);
            Courses PHY124=new Courses("Electromagnetism","PHY124",3);
            Courses CHM121=new Courses("Inorganic Chemistry 2","CHM111",3);
            Courses CHM122=new Courses("Organic Chemistry 2","CHM112",3);
            mathematics.getLevelMaps().get("100")
                    .setSecSemCourse(GST121,GST122,GST123,MTH123,MTH125,PHY124,CHM121,CHM122);
                    mathematics.getLevelMaps().get("100").setAllCourses();

        facultyMap.put(physicalScience.getNameOfFaculty(), physicalScience);
     
    }
    public final void lifeScienceData(){
        
        // initializing faculties
         Faculties lifeScience=new Faculties("Life Science");
         faculties.add(lifeScience);
        
            //initializing departments for engineering
            Department microbiology=new Department(4,"Micro Biology");
                    Levels mcbfirst=new Levels("100");
                    Levels mcbsecond=new Levels("200");
                    Levels mcbthird=new Levels("300");
                    Levels mcbfourth=new Levels("400");
                    Levels mcbfifth=new Levels("500");
                    microbiology.setLevels(mcbfirst,mcbsecond,mcbthird,mcbfourth,mcbfifth);
 
            Department bioChemistry=new Department(4,"Biochemistry");
            Department optometry=new Department(6,"Optometry");
            Department medLab=new Department(4,"Medical Science Laboratory");
            Department pbb=new Department(6,"Plant Biology & BioTechnology");
            Department aeb=new Department(4,"Animal & Environmental Biology");
            lifeScience.setDepartments(microbiology,bioChemistry,optometry,medLab,pbb,aeb);
           

            // settting general courses for 100 level
                //forFirstSemester
                Courses GST111=new Courses("Philosophy and Logic","GST 111",30);
                Courses GST112=new Courses("Use of Library","GST 121",4);
                Courses MTH110=new Courses("Algebra,Trigonometry and Statistic","MTH110",3);
                Courses MTH112=new Courses("Calculus","MTH112",7);
                Courses PHY111=new Courses("Vector","PHY111",3);
                Courses PHY113=new Courses("Wave and Properties","PHY113",3);
                Courses CHM111=new Courses("Inorganic Chemistry 1","CHM111",3);
                Courses CHM112=new Courses("Organic Chemistry 1","CHM112",3);
                microbiology.getLevelMaps().get("100")
                        .setFirstSemCourse(GST111,GST112,MTH110,MTH112,PHY111,PHY113,CHM111,CHM112);
            //forSecondSemester
            Courses GST121=new Courses("Peace and Conflict","GST 121",50);
            Courses GST122=new Courses("Nigeria; People and Culture","GST 122",2);
            Courses GST123=new Courses("History of Science and Technology","GST 123",10);
            Courses MTH125=new Courses("Differential Equations","MTH125",3);
            Courses MTH123=new Courses("Vector and Statistics","MTH123",4);
            Courses PHY124=new Courses("Electromagnetism","PHY124",3);
            Courses CHM121=new Courses("Inorganic Chemistry 2","CHM111",3);
            Courses CHM122=new Courses("Organic Chemistry 2","CHM112",3);
            microbiology.getLevelMaps().get("100")
                    .setSecSemCourse(GST121,GST122,GST123,MTH123,MTH125,PHY124,CHM121,CHM122);
                    microbiology.getLevelMaps().get("100").setAllCourses();

        facultyMap.put(lifeScience.getNameOfFaculty(), lifeScience);
     
    }
      public final void educationingData(){
        
        // initializing faculties
         Faculties education=new Faculties("Education");
         faculties.add(education);
        
            //initializing departments for engineering
            Department hse=new Department(5,"Human Kinetics & Sports Science");
                    Levels hsefirst=new Levels("100");
                    Levels hsesecond=new Levels("200");
                    Levels hsethird=new Levels("300");
                    Levels hsefourth=new Levels("400");
                    Levels hsefifth=new Levels("500");
                    hse.setLevels(hsefirst,hsesecond,hsethird,hsefourth,hsefifth);
 
            Department biologyEducation=new Department(5,"Biology Education");
            Department mathsEducation=new Department(5,"Mathematics Education");
            Department adultEducation=new Department(5,"Adult Education");
            Department eeeEducation=new Department(5,"Electrical/Electronics Education");
            education.setDepartments(hse,biologyEducation,mathsEducation,adultEducation,eeeEducation);
           

            // settting general courses for 100 level
                //forFirstSemester
                Courses GST111=new Courses("Philosophy and Logic","GST 111",2);
                Courses GST112=new Courses("Use of Library","GST 121",2);
                Courses MTH110=new Courses("Algebra,Trigonometry and Statistic","MTH110",3);
                Courses MTH112=new Courses("Calculus","MTH112",3);
                Courses PHY111=new Courses("Vector","PHY111",3);
                Courses PHY113=new Courses("Wave and Properties","PHY113",3);
                Courses CHM111=new Courses("Inorganic Chemistry 1","CHM111",3);
                Courses CHM112=new Courses("Organic Chemistry 1","CHM112",3);
                hse.getLevelMaps().get("100")
                        .setFirstSemCourse(GST111,GST112,MTH110,MTH112,PHY111,PHY113,CHM111,CHM112);
            //forSecondSemester
            Courses GST121=new Courses("Peace and Conflict","GST 121",2);
            Courses GST122=new Courses("Nigeria; People and Culture","GST 122",2);
            Courses GST123=new Courses("History of Science and Technology","GST 123",2);
            Courses MTH125=new Courses("Differential Equations","MTH125",3);
            Courses MTH123=new Courses("Vector and Statistics","MTH123",3);
            Courses PHY124=new Courses("Electromagnetism","PHY124",3);
            Courses CHM121=new Courses("Inorganic Chemistry 2","CHM111",3);
            Courses CHM122=new Courses("Organic Chemistry 2","CHM112",3);
            hse.getLevelMaps().get("100")
                    .setSecSemCourse(GST121,GST122,GST123,MTH123,MTH125,PHY124,CHM121,CHM122);
                    hse.getLevelMaps().get("100").setAllCourses();

        facultyMap.put(education.getNameOfFaculty(), education);
     
    }
      public final void agricData(){
        
        // initializing faculties
         Faculties agric=new Faculties("Agricultural Science");
         faculties.add(agric);
        
            //initializing departments for engineering
            Department fis=new Department(5,"Fisheries");
                    Levels fisfirst=new Levels("100");
                    Levels fissecond=new Levels("200");
                    Levels fisthird=new Levels("300");
                    Levels fisfourth=new Levels("400");
                    Levels fisfifth=new Levels("500");
                    fis.setLevels(fisfirst,fissecond,fisthird,fisfourth,fisfifth);
 
            Department aee=new Department(5,"Agric Education & Extension");
            Department soilScience=new Department(5,"Soil Science");
            Department animalScience=new Department(5,"Animal Science");
            Department forestry=new Department(5,"Forestry");
            agric.setDepartments(fis,soilScience,animalScience,forestry,aee);
           

            // settting general courses for 100 level
                //forFirstSemester
                Courses GST111=new Courses("Philosophy and Logic","GST 111",2);
                Courses GST112=new Courses("Use of Library","GST 121",2);
                Courses MTH110=new Courses("Algebra,Trigonometry and Statistic","MTH110",3);
                Courses MTH112=new Courses("Calculus","MTH112",3);
                Courses PHY111=new Courses("Vector","PHY111",3);
                Courses PHY113=new Courses("Wave and Properties","PHY113",3);
                Courses CHM111=new Courses("Inorganic Chemistry 1","CHM111",3);
                Courses CHM112=new Courses("Organic Chemistry 1","CHM112",3);
                fis.getLevelMaps().get("100")
                        .setFirstSemCourse(GST111,GST112,MTH110,MTH112,PHY111,PHY113,CHM111,CHM112);
            //forSecondSemester
            Courses GST121=new Courses("Peace and Conflict","GST 121",2);
            Courses GST122=new Courses("Nigeria; People and Culture","GST 122",2);
            Courses GST123=new Courses("History of Science and Technology","GST 123",2);
            Courses MTH125=new Courses("Differential Equations","MTH125",3);
            Courses MTH123=new Courses("Vector and Statistics","MTH123",3);
            Courses PHY124=new Courses("Electromagnetism","PHY124",3);
            Courses CHM121=new Courses("Inorganic Chemistry 2","CHM111",3);
            Courses CHM122=new Courses("Organic Chemistry 2","CHM112",3);
            fis.getLevelMaps().get("100")
                    .setSecSemCourse(GST121,GST122,GST123,MTH123,MTH125,PHY124,CHM121,CHM122);
                    fis.getLevelMaps().get("100").setAllCourses();

        facultyMap.put(agric.getNameOfFaculty(), agric);
     
    }
    
}