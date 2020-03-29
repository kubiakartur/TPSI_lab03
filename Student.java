package lab03;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    public static void main(String[] args) {
       
    }
    private String groupId;
    private List<Double> grades = new ArrayList<>();    
    
    public Student(String firstName, String lastName, String emailAddress, String groupId) {
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
    }
    
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public List<Double> getGrades() {
        return grades;
    }
    
    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    public void getGradesAverage()
    {
        double suma = 0;
        double srednia = 0;
        for(Double grade: grades){
            suma = suma + grade;
        }
        srednia = suma / grades.size();
        System.out.println(srednia);
    }
}