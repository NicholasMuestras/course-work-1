import java.util.Objects;

public class Employee {
    protected static int idCounter;

    protected int id;
    protected String firstName;
    protected String secondName;
    protected String thirdName;
    protected String team; // 1-5
    protected float salary;

    public Employee(String firstName, String secondName, String thirdName, String team, float salary) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setThirdName(thirdName);
        this.setTeam(team);
        this.setSalary(salary);
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if (salary < 0) {
            throw new RuntimeException("Salary must be >= 0 for " + this);
        }

        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, thirdName, team, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", team='" + team + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String fullName() {
        return secondName + " " + firstName + " " + thirdName;
    }
}
