package spittr;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by root on 12.10.16.
 */
public class Spitter {

    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Spitter() {
        firstName = "";
        lastName = "";
        userName = "";
        password = "";
    }

    public Spitter(String userName, String password, String firstName,
                   String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
    }

    public Spitter(long id, String firstName, String lastName, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Spitter spitter = (Spitter) o;

        return new EqualsBuilder()
                .append(id, spitter.id)
                .append(userName, spitter.userName)
                .append(password, spitter.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(userName)
                .append(password)
                .toHashCode();
    }
}
