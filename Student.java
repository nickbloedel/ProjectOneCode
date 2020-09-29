public class Student {
  public Long ID;
  public String major;
  public Integer gradYear;

  public Student(Long iD2, String major, Integer gradYear) {
       this.ID = iD2;
       this.major = major;
       this.gradYear = gradYear;
  }

  public Long getID() {
    return ID;
  }

  public String getMajor() {
    return major;
  }

  public Integer getGradYear() {
    return gradYear;
  }

}