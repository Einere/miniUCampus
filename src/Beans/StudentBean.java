package Beans;

public class StudentBean {
    private String SNumber;
    private String Major_number;
    private int SYear;
    private String Email;
    private String SGender;
    private String Phone_number;

    public void setSNumber(String SNumber) {
        this.SNumber = SNumber;
    }

    public void setMajor_number(String major_number) {
        Major_number = major_number;
    }

    public void setSYear(int SYear) {
        this.SYear = SYear;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSGender(String SGender) {
        this.SGender = SGender;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getSNumber() {

        return SNumber;
    }

    public String getMajor_number() {
        return Major_number;
    }

    public int getSYear() {
        return SYear;
    }

    public String getEmail() {
        return Email;
    }

    public String getSGender() {
        return SGender;
    }

    public String getPhone_number() {
        return Phone_number;
    }
}
