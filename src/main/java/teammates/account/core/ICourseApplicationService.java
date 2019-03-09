package teammates.account.core;

public interface ICourseApplicationService {

    boolean addInstructorToCourse(String courseId, String instructorId);
    boolean addStudentToCourse(String courseId, String studentId);
}
