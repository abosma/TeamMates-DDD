package teammates.account.api;

import teammates.account.core.CourseApplicationService;
import teammates.account.domain.Repositories.CourseRepository;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/course")
public class CourseRESTService{

    CourseApplicationService CourseApplicationService = new CourseApplicationService(new CourseRepository());

    @PUT
    @Path("/addInstructor/{courseId}/{instructorId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addInstructorToCourse(@PathParam("courseId") String courseId, @PathParam("instructorId") String instructorId)
    {

        if(CourseApplicationService.addInstructorToCourse(courseId, instructorId))
        {
            String returnMessage = String.format("Instructor: %s added to Course: %s", instructorId, courseId);

            return Response.status(Response.Status.OK).entity(returnMessage).build();
        }
        else
        {
            String returnMessage = String.format("Instructor: %s not added to Course: %s", instructorId, courseId);

            return Response.status(Response.Status.NOT_MODIFIED).entity(returnMessage).build();
        }
    }

    @PUT
    @Path("/addStudent/{courseId}/{studentId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addStudentToCourse(@PathParam("courseId") String courseId, @PathParam("studentId") String studentId)
    {
        if(CourseApplicationService.addStudentToCourse(courseId, studentId))
        {
            String returnMessage = String.format("Student: %s added to Course: %s", studentId, courseId);

            return Response.status(Response.Status.OK).entity(returnMessage).build();
        }
        else
        {
            String returnMessage = String.format("Student: %s not added to Course: %s", studentId, courseId);

            return Response.status(Response.Status.NOT_MODIFIED).entity(returnMessage).build();
        }
    }

    @PUT
    @Path("/add/{courseId}/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCourse(@PathParam("courseId") String courseId)
    {
        if(CourseApplicationService.addCourse(courseId))
        {
            String returnMessage = String.format("Course: %s added to repository", courseId);

            return Response.status(Response.Status.OK).entity(returnMessage).build();
        }
        else
        {
            String returnMessage = String.format("Course: %s not added to repository", courseId);

            return Response.status(Response.Status.NOT_MODIFIED).entity(returnMessage).build();
        }
    }

    @GET
    @Path("/get/{courseId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourse(@PathParam("courseId") String courseId)
    {
        String returnJson = CourseApplicationService.getCourse(courseId);

        if(returnJson != "")
        {
            return Response.status(Response.Status.OK).entity(returnJson).build();
        }
        else
        {
            String returnMessage = String.format("No course found with ID: %s", courseId);

            return Response.status(Response.Status.NO_CONTENT).entity(returnMessage).build();
        }
    }
}
