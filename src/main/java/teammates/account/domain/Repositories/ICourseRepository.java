package teammates.account.domain.Repositories;

import teammates.account.domain.Course;

public interface ICourseRepository {
    public Course courseOfId(String courseId);
    public void save(Course instructor);
}
