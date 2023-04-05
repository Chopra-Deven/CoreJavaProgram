package bankApplication.bean;

import bankApplication.util.BaseMethods;


public class CustomerBean
{

    private final long cId;

    private String firstName;

    private String lastName;

    private String email;

    private long contactNumber;

    private String address;

    private final long accountNumber;

    private String password;

    private double balance;

    public CustomerBean(String firstName, String lastName, String email, long contactNumber, String address, String password)
    {

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;

        this.contactNumber = contactNumber;

        this.address = address;

        this.password = password;

        BaseMethods methods = new BaseMethods();

        this.cId = methods.getCustomerId();

        this.accountNumber = methods.getAccountNumber();
        //        this.balance = balance;
    }

    public long getcId()
    {

        return cId;
    }

    public String getAddress()
    {

        return address;
    }

    public void setAddress(String address)
    {

        this.address = address;
    }

    public long getAccountNumber()
    {

        return accountNumber;
    }

    public String getPassword()
    {

        return password;
    }

    public void setPassword(String password)
    {

        this.password = password;
    }

    public double getBalance()
    {

        return balance;
    }

    public void setBalance(double balance)
    {

        this.balance = balance;
    }

    public String getFirstName()
    {

        return firstName;
    }

    public void setFirstName(String firstName)
    {

        this.firstName = firstName;
    }

    public String getLastName()
    {

        return lastName;
    }

    public void setLastName(String lastName)
    {

        this.lastName = lastName;
    }

    public String getEmail()
    {

        return email;
    }

    public void setEmail(String email)
    {

        this.email = email;
    }

    public long getContactNumber()
    {

        return contactNumber;
    }

    public void setContactNumber(long contactNumber)
    {

        this.contactNumber = contactNumber;
    }

}
