package teammates.account.domain.ValueObjects;

public class AccountId {

    private String id;

    public AccountId(String accountId)
    {
        this.id = accountId;
    }

    public String getAccountId()
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

        if(!(o instanceof AccountId))
        {
            return false;
        }

        AccountId ai = (AccountId)o;
        return ai.id == id;
    }
}
