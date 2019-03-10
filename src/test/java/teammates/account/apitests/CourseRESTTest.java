package teammates.account.apitests;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import teammates.account.api.CourseRESTService;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseRESTTest {

    static CourseRESTService courseRESTService = new CourseRESTService();

    @BeforeAll
    static void init()
    {
        Response response = courseRESTService.addCourse("0");

        assertEquals(Response.Status.OK, response.getStatusInfo(), "Response must be OK");

        System.out.println(response.getEntity());
    }

    @Test
    void testInstructorAddToCourse()
    {
        Response response = courseRESTService.addInstructorToCourse("0", "0");

        assertEquals(Response.Status.OK, response.getStatusInfo(), "Response must be OK");

        System.out.println(response.getEntity());
    }

    @Test
    void testStudentAddToCourse()
    {
        Response response = courseRESTService.addStudentToCourse("0", "0");

        assertEquals(Response.Status.OK, response.getStatusInfo(), "Response must be OK");

        System.out.println(response.getEntity());
    }

    @AfterAll
    static void end()
    {
        Response response = courseRESTService.getCourse("0");

        assertEquals(Response.Status.OK, response.getStatusInfo(), "Response must be OK");

        JSONObject courseObject = new JSONObject(response.getEntity().toString());

        System.out.printf("{ CourseID: %s\nStudentIDs: %s\nInstructorID: %s }", courseObject.get("CourseID"), courseObject.get("StudentIDs"), courseObject.get("InstructorID"));
    }
}
