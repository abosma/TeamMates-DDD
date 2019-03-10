package teammates.account.domain;

import teammates.account.domain.ValueObjects.CourseId;
import teammates.account.domain.ValueObjects.InstructorId;
import teammates.account.domain.ValueObjects.StudentId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {

    private UUID serialNumber;
    private CourseId courseId;
    private InstructorId instructorId;

    private List<StudentId> studentIds = new ArrayList<StudentId>();

    private String name = "";

    public Course(String id)
    {
        this.serialNumber = UUID.randomUUID();
        this.courseId = new CourseId(id);
    }

    public CourseId getCourseId()
    {
        return courseId;
    }

    public boolean hasInstructor()
    {
        return instructorId != null;
    }

    public void addInstructor(String instructor)
    {
        instructorId = new InstructorId(instructor);
    }

    public InstructorId getInstructor()
    {
        InstructorId returnId = null;

        if(instructorId != null)
        {
            returnId = instructorId;
        }

        return returnId;
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

    public List<StudentId> getStudents()
    {
        List<StudentId> returnList = new ArrayList<>();

        if(studentIds != null || !studentIds.isEmpty())
        {
            returnList = studentIds;
        }

        return returnList;
    }

    @Override
    public String toString()
    {
        String students = "";
        String instructor = instructorId != null ? instructorId.getInstructorId() : "";
        String course = courseId.getCourseId();

        if(!studentIds.isEmpty())
        {
            for(StudentId ID : studentIds)
            {
                students += ID.getStudentId() + "\n";
            }
        }

        return String.format("Course: %s\nInstructor: %s\nStudents: %s", course, instructor, students);
    }
}
