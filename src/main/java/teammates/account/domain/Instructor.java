package teammates.account.domain;

import teammates.account.domain.ValueObjects.AccountId;
import teammates.account.domain.ValueObjects.InstructorId;

import java.util.UUID;

public class Instructor {

    private UUID serialNumber;
    private AccountId accountId;
    private InstructorId instructorId;

    private String role = "";
    private String displayedName = "";
    private String registrationKey = "";

    public Instructor(String id)
    {
        this.serialNumber = UUID.randomUUID();
        this.instructorId = new InstructorId(id);
    }
}
