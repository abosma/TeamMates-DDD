package teammates.account.domain.Repositories;

import teammates.account.domain.Course;
import teammates.account.domain.Instructor;

public class CourseRepository implements ICourseRepository{

    public CourseRepository(){

    }

    @Override
    public Course courseOfId(String courseId)
    {
        Course course = new Course(courseId);
        return course;
    }

    @Override
    public void save(Course course) {
        System.out.println(course.toString());
    }

}
