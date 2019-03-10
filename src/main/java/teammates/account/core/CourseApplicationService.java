package teammates.account.core;

import org.json.JSONObject;
import teammates.account.domain.Course;
import teammates.account.domain.Repositories.ICourseRepository;

public class CourseApplicationService implements ICourseApplicationService{

    private ICourseRepository repository;

    public CourseApplicationService(ICourseRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public boolean addInstructorToCourse(String courseId, String instructorId)
    {
        Course course = repository.courseOfId(courseId);

        if(course.hasInstructor() || course == null)
        {
            return false;
        }

        course.addInstructor(instructorId);

        repository.update(course);

        return true;
    }

    @Override
    public boolean addStudentToCourse(String courseId, String studentId)
    {
        Course course = repository.courseOfId(courseId);

        if(course.isStudentAssigned(studentId) || course == null)
        {
            return false;
        }

        course.addStudent(studentId);

        repository.update(course);

        return true;
    }

    @Override
    public boolean addCourse(String courseId)
    {
        Course course = new Course(courseId);

        if(repository.containsCourse(course))
        {
            return false;
        }

        repository.save(course);

        return true;
    }

    @Override
    public String getCourse(String courseId)
    {
        Course course = repository.courseOfId(courseId);

        if(course == null)
        {
            return "";
        }

        JSONObject returnObject = new JSONObject();

        returnObject.put("CourseID", course.getCourseId().getCourseId());
        returnObject.put("InstructorID", course.getInstructor().getInstructorId());
        returnObject.put("StudentIDs", course.getStudents());

        return returnObject.toString();
    }
}
