package teammates.account.domain.Repositories;

import teammates.account.domain.Course;

public interface ICourseRepository<T> {

    Course courseOfId(String courseId);
    Course getCourse(T course);

    Boolean containsCourse(T course);

    void update(T course);
    void remove(T course);
    void save(T course);
}
