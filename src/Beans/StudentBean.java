package Beans;

public class StudentBean {
    private String sNumber;
    private String Major_number;
    private int sYear;
    private String Email;
    private String sGender;
    private String phone_number;

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public void setMajor_number(String major_number) {
        Major_number = major_number;
    }

    public void setsYear(int sYear) {
        this.sYear = sYear;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getsNumber() {

        return sNumber;
    }

    public String getMajor_number() {
        return Major_number;
    }

    public int getsYear() {
        return sYear;
    }

    public String getEmail() {
        return Email;
    }

    public String getsGender() {
        return sGender;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
