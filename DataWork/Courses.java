
    package DataWork;
    public class Courses {
        
// declaring properties for class course
    private   Integer credits;
    private  String title,code;
    
    
    public Courses(){
           setCredits(null);
           setTitle(null);
           setCode(null);
       }
        public Courses(String title,String code,Integer credits){
            setCredits(credits);
            setTitle(title);
            setCode(code);
        }
//adding setters and getters for courses properties
    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Courses{" + "credits=" + credits + ", title=" + title + ", code=" + code + '}';
    }
    }

