package teammates.account.core;

import teammates.account.domain.Course;
import teammates.account.domain.Repositories.ICourseRepository;

public class CourseApplicationService implements ICourseApplicationService{

    private ICourseRepository repository;

    public CourseApplicationService(ICourseRepository repository)
    {
        this.repository = repository;
    }

    public boolean addInstructorToCourse(String courseId, String instructorId)
    {
        Course course = repository.courseOfId(courseId);

        if(course.hasInstructor())
        {
            return false;
        }

        course.addInstructor(instructorId);

        repository.save(course);

        return true;
    }

    public boolean addStudentToCourse(String courseId, String studentId)
    {
        Course course = repository.courseOfId(courseId);

        if(course.isStudentAssigned(studentId))
        {
            return false;
        }

        course.addStudent(studentId);

        repository.save(course);

        return true;
    }
}
