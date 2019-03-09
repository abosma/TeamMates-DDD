package teammates.account.domain.ValueObjects;

public class StudentId {

    private String id;

    public StudentId(String studentId)
    {
        this.id = studentId;
    }

    public String getStudentId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
        {
            return true;
        }

        if(!(o instanceof StudentId))
        {
            return false;
        }

        StudentId si = (StudentId)o;
        return si.id == id;
    }
}
