import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


public class Client {
    private String name;
    private Date birthday;
    private String phoneNumber;
    private String eMail;

    private final String PHONE_NUMBER_ERROR = "неверный формат номера телефона";
    private final String EMAIL_FORMAT_ERROR = "неверный формат e-mail";
    private final String DATE_ERROR = "введенная дата позже текущей";

    public Client(String name, Date birthday, String phoneNumber, String eMail) {
        this.name = name;

        if (birthday.before(Date.valueOf(LocalDate.now()))) {
            this.birthday = birthday;
        } else {
            throw new RuntimeException(PHONE_NUMBER_ERROR);
        }

        if (phoneNumberValidate(phoneNumber)) {
            this.phoneNumber = phoneNumber.replaceAll("\\+", "");
        } else {
            throw new RuntimeException(PHONE_NUMBER_ERROR);
        }

        if (eMailValidate(eMail)) {
            this.eMail = eMail;
        } else {
            throw new RuntimeException(EMAIL_FORMAT_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        if (birthday.after(new Date(System.currentTimeMillis()))) {
            this.birthday = birthday;
        } else {
            throw new RuntimeException(DATE_ERROR);
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumberValidate(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new RuntimeException(PHONE_NUMBER_ERROR);
        }
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        if (eMailValidate(eMail)) {
            this.eMail = eMail;
        } else {
            throw new RuntimeException(EMAIL_FORMAT_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(birthday, client.birthday) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(eMail, client.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, phoneNumber, eMail);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    private boolean phoneNumberValidate(String phoneNumber) {
        String pattern = "([7]{1})([0-9]{10})";
        String number = phoneNumber.replaceAll("[^0-9]", "");
        return number.matches(pattern);
    }

    private boolean eMailValidate(String eMail) {
        String pattern = "^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
        return eMail.matches(pattern);
    }
}
