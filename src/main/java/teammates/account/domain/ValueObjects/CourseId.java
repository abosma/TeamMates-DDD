package teammates.account.domain.ValueObjects;

public class CourseId {

    public String id;

    public CourseId(String courseId)
    {
        this.id = courseId;
    }

    public String getCourseId()
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

        if(!(o instanceof CourseId))
        {
            return false;
        }

        CourseId ci = (CourseId)o;
        return ci.id == id;
    }
}
