package teammates.account.domain;

import teammates.account.domain.ValueObjects.CourseId;
import teammates.account.domain.ValueObjects.InstructorId;
import teammates.account.domain.ValueObjects.StudentId;

import java.util.List;
import java.util.UUID;

public class Course {

    private UUID serialNumber;
    private CourseId courseId;
    private InstructorId instructorId;

    private List<StudentId> studentIds;

    private String name = "";

    public Course(String id)
    {
        this.serialNumber = UUID.randomUUID();
        this.courseId = new CourseId(id);
    }

    public boolean hasInstructor()
    {
        return instructorId != null;
    }

    public void addInstructor(String instructor)
    {
        instructorId = new InstructorId(instructor);
    }

    public boolean isStudentAssigned(String student)
    {
        StudentId studentId = new StudentId(student);

        return studentIds.contains(studentId);
    }

    public void addStudent(String student)
    {
        studentIds.add(new StudentId(student));
    }

    @Override
    public String toString()
    {
        String students = "";

        for(StudentId ID : studentIds)
        {
            students += ID + "\n";
        }

        return String.format("Instructor: %a\nStudents: %b", instructorId.getInstructorId(), students);
    }
}
