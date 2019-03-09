package teammates.account.domain.ValueObjects;

public class InstructorId {

    private String id;

    public InstructorId(String instructorId)
    {
        this.id = instructorId;
    }

    public String getInstructorId()
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

        if(!(o instanceof InstructorId))
        {
            return false;
        }

        InstructorId ii = (InstructorId)o;
        return ii.id == id;
    }
}
