package Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.Student;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    private Student student=new Student();
    @Override
    public Student getModel() {
        return student;
    }
    public String add(){
        System.out.println(student);
        return NONE;
    }
}
