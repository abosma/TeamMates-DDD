package teammates.account.domain;

import teammates.account.domain.ValueObjects.AccountId;
import java.util.UUID;

public class Account {

    private UUID serialNumber;
    private AccountId accountId;

    String name = "";
    String email = "";
    String institute = "";

    public Account(String id)
    {
        this.serialNumber = UUID.randomUUID();
        this.accountId = new AccountId(id);
    }

}
