package ae.spring.orm.base.dto;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "useraccount")
public class UserAccount
{
    public transient int counter;

    private String email;

    private String password;

    private byte[] photo;

    private Date registrationDate;

    private Integer score;

    private Long userAccountId;

    private String username;

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final UserAccount other = (UserAccount) obj;
        if (email == null)
        {
            if (other.email != null)
            {
                return false;
            }
        }
        else if (!email.equals(other.email))
        {
            return false;
        }
        if (password == null)
        {
            if (other.password != null)
            {
                return false;
            }
        }
        else if (!password.equals(other.password))
        {
            return false;
        }
        if (!Arrays.equals(photo, other.photo))
        {
            return false;
        }
        if (registrationDate == null)
        {
            if (other.registrationDate != null)
            {
                return false;
            }
        }
        else if (!registrationDate.equals(other.registrationDate))
        {
            return false;
        }
        if (score == null)
        {
            if (other.score != null)
            {
                return false;
            }
        }
        else if (!score.equals(other.score))
        {
            return false;
        }
        if (userAccountId == null)
        {
            if (other.userAccountId != null)
            {
                return false;
            }
        }
        else if (!userAccountId.equals(other.userAccountId))
        {
            return false;
        }
        if (username == null)
        {
            if (other.username != null)
            {
                return false;
            }
        }
        else if (!username.equals(other.username))
        {
            return false;
        }
        return true;
    }

    @Transient
    public String getComment()
    {
        return "This is a useraccount";
    }

    @Column(name = "email")
    public String getEmail()
    {
        return email;
    }

    @Column(name = "password", length = 128, nullable = false)
    public String getPassword()
    {
        return password;
    }

    @Lob
    @Column(name = "photo")
    public byte[] getPhoto()
    {
        return photo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "registrationDate")
    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    @Column(name = "scoring")
    public Integer getScore()
    {
        return score;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getUserAccountId()
    {
        return userAccountId;
    }

    @Column(name = "username", length = 128, nullable = false, unique = true)
    public String getUsername()
    {
        return username;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (email == null ? 0 : email.hashCode());
        result = prime * result + (password == null ? 0 : password.hashCode());
        result = prime * result + Arrays.hashCode(photo);
        result = prime * result + (registrationDate == null ? 0 : registrationDate.hashCode());
        result = prime * result + (score == null ? 0 : score.hashCode());
        result = prime * result + (userAccountId == null ? 0 : userAccountId.hashCode());
        result = prime * result + (username == null ? 0 : username.hashCode());
        return result;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public void setPhoto(final byte[] photo)
    {
        this.photo = photo;
    }

    public void setRegistrationDate(final Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    public void setScore(final Integer score)
    {
        this.score = score;
    }

    public void setUserAccountId(final Long userAccountId)
    {
        this.userAccountId = userAccountId;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "UserAccount [email=" + email + ", password=" + password + ", photo=" + Arrays.toString(photo)
                + ", registrationDate=" + registrationDate + ", score=" + score + ", userAccountId=" + userAccountId
                + ", username=" + username + "]";
    }

}
