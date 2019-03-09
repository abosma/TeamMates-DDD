package teammates.account.api;

import teammates.account.core.CourseApplicationService;
import teammates.account.domain.Repositories.CourseRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/course")
public class CourseRESTService{

    CourseApplicationService CourseApplicationService = new CourseApplicationService(new CourseRepository());

    @PUT
    @Path("/addInstructorToCourse/{courseId}/{instructorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInstructorToCourse(@PathParam("courseId") String courseId, @PathParam("instructorId") String instructorId)
    {
        CourseApplicationService.addInstructorToCourse(courseId, instructorId);
        return Response.status(200).build();
    }

    @PUT
    @Path("/addStudentToCourse/{courseId}/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudentToCourse(@PathParam("courseId") String courseId, @PathParam("studentId") String studentId)
    {
        CourseApplicationService.addStudentToCourse(courseId, studentId);
        return Response.status(200).build();
    }

}
