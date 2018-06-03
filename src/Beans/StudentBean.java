package Beans;

public class StudentBean {
    private String sNumber;
    private String Major_number;
    private int SYear;
    private String Email;
    private String SGender;
    private String Phone_number;

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public void setMajor_number(String major_number) {
        Major_number = major_number;
    }

    public void setsYear(int sYear) {
        this.SYear = sYear;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setsGender(String sGender) {
        this.SGender = sGender;
    }

    public void setPhone_number(String phone_number) {
        this.Phone_number = phone_number;
    }

    public String getsNumber() {

        return sNumber;
    }

    public String getMajor_number() {
        return Major_number;
    }

    public int getsYear() {
        return SYear;
    }

    public String getEmail() {
        return Email;
    }

    public String getsGender() {
        return SGender;
    }

    public String getPhone_number() {
        return Phone_number;
    }
}
