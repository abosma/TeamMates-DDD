package teammates.account.core;

import teammates.account.domain.Course;

public interface ICourseApplicationService {

    boolean addInstructorToCourse(String courseId, String instructorId);
    boolean addStudentToCourse(String courseId, String studentId);
    boolean addCourse(String courseId);

    String getCourse(String courseId);
}
