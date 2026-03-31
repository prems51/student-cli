package model;

public class Student {

    int studetnId;
    String name;
    int age;
    String course;
    String branch;
    int ennrolYear;
    long phone;
    String email;
    public Student(int studetnId, String name, int age, String course, String branch, int ennrolYear, long phone,
            String email) {
        this.studetnId = studetnId;
        this.name = name;
        this.age = age;
        this.course = course;
        this.branch = branch;
        this.ennrolYear = ennrolYear;
        this.phone = phone;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public int getStudetnId() {
        return studetnId;
    }

    public void setStudetnId(int studetnId) {
        this.studetnId = studetnId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getEnnrolYear() {
        return ennrolYear;
    }

    public void setEnnrolYear(int ennrolYear) {
        this.ennrolYear = ennrolYear;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}