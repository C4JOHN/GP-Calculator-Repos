package DataWork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

    public class Levels {
        // declaring variable for levels
        private String levelName;
        private ObservableList<Courses> firstSemCourse;
        private ObservableList<Courses> secSemCourse;
        private ObservableList<Courses> allCourses;
        private Map<String, Courses> firstCoursesMap;
        private Map<String, Courses> secCoursesMap;
        
        public Levels(){
            setLevelName(null);
        }
           public Levels(String name){
            setLevelName(name);
            this.firstSemCourse=FXCollections.observableArrayList();
            this.secSemCourse=FXCollections.observableArrayList();
            this.allCourses=FXCollections.observableArrayList();
            this.firstCoursesMap=new HashMap();
            this.secCoursesMap=new HashMap();
        }

//declaring setters and getters for level properties
    public String getLevelName() {
        return this.levelName;
    }

    public final void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public ObservableList<Courses> getFirstSemCourse() {
        return firstSemCourse;
    }
    public void setFirstSemCourse(Courses... courses) {
        for(Courses loop:courses){
        this.firstSemCourse.add(loop);
        this.firstCoursesMap.put(loop.getTitle(), loop);
        }
    }
    public ObservableList<Courses> getSecSemCourse() {
        return this.secSemCourse;
    }

    public void setSecSemCourse(Courses... courses) {
        for(Courses loop:courses){
        this.secSemCourse.add(loop);
        this.secCoursesMap.put(loop.getTitle(),loop);
        }
    }

    public ObservableList<Courses> getAllCourses() {
        return this.allCourses;
    }

    public void setAllCourses() {
        this.allCourses.addAll(this.firstSemCourse);
        this.allCourses.addAll(this.secSemCourse);
    }

    public Map<String, Courses> getFirstCoursesMap() {
        return this.firstCoursesMap;
    }
    
    public void setFirstCoursesMap(ObservableList<Courses> firstSemCourse) {
        Iterator<Courses> iterator=firstSemCourse.iterator();
        while(iterator.hasNext())
            this.firstCoursesMap.put(iterator.next().getTitle(),iterator.next());
    }

    public Map<String, Courses> getSecCoursesMap() {
        return this.secCoursesMap;
    }

    public void setSecCoursesMap(ObservableList<Courses> secSecCourse) {
         Iterator<Courses> iterator=secSemCourse.iterator();
        while(iterator.hasNext())
            this.secCoursesMap.put(iterator.next().getTitle(),iterator.next());
    }
    @Override
    public String toString() {
        return "Levels{" + "levelName=" + this.levelName + ", firstSemCourse=" + this.firstSemCourse + ", secSemCourse=" + this.secSemCourse + ", allCourses=" + this.allCourses + ", firstSemCreditList=" + ", firstCoursesMap=" + this.firstCoursesMap + ", secCoursesMap=" + this.secCoursesMap + '}';
    }
    }