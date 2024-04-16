import java.util.Date;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String studentId;

    public Student(int id, String firstName, String lastName, String middleName, Date birthDate, String studentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}