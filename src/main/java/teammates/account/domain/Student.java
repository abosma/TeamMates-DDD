package teammates.account.domain;

import teammates.account.domain.ValueObjects.AccountId;
import teammates.account.domain.ValueObjects.StudentId;

import java.util.UUID;

public class Student {

    private UUID serialNumber;
    private AccountId accountId;
    private StudentId studentId;

    private String shortName = "";
    private String nationality = "";
    private String gender = "";
    private String pictureKey = "";
    private String moreInfo = "";

    public Student(String id)
    {
        this.serialNumber = UUID.randomUUID();
        this.studentId = new StudentId(id);
    }
}
