public class Student {
  private long ID;
  private String major;
  private int gradYear;

  public Student(long iD2, String major, int gradYear) {
       this.ID = iD2;
       this.major = major;
       this.gradYear = gradYear;
  }

  public long getID() {
    return ID;
  }

  public String getMajor() {
    return major;
  }

  public int getGradYear() {
    return gradYear;
  }

}