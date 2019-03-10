package teammates.account.domain.Repositories;

import teammates.account.domain.Course;
import teammates.account.domain.Instructor;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements ICourseRepository<Course>{

    // Voor het weergeven bij de presentatie
    private static List<Course> courseList = new ArrayList<Course>();

    public CourseRepository(){

    }

    @Override
    public Course courseOfId(String courseId)
    {
        Course course = null;

        for(Course c : courseList)
        {
            if(c.getCourseId().id.equals(courseId))
            {
                course = c;
            }
        }

        return course;
    }

    @Override
    public Course getCourse(Course course) {
        Course returnCourse = null;

        for(Course c : courseList)
        {
            if(c.equals(course))
            {
                returnCourse = c;
                break;
            }
        }

        return returnCourse;
    }

    @Override
    public Boolean containsCourse(Course course) {
        for(Course c : courseList)
        {
            if(c.equals(courseList))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public void update(Course course) {
        int courseIndex = courseList.indexOf(courseOfId(course.getCourseId().id));

        courseList.set(courseIndex, course);
    }

    @Override
    public void remove(Course course) {
        courseList.remove(course);
    }

    @Override
    public void save(Course course) {
        courseList.add(course);
    }
}
