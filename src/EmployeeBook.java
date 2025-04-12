public class EmployeeBook {

    private final Employee[] storage;

    public EmployeeBook(int capacity) {
        this.storage = new Employee[capacity];
    }

    public EmployeeBook add(Employee employee) {
        for (int i = 0; i < this.storage.length; i++) {
            if (this.storage[i] == null) {
                this.storage[i] = employee;

                return this;
            }
        }

        throw new RuntimeException("Unable to add an item. Storage is full.");
    }

    public EmployeeBook delete(int id) {
        for (int i = 0; i < this.storage.length; i++) {
            if (this.storage[i] == null) {
                continue;
            }

            if (this.storage[i].getId() == id) {
                this.storage[i] = null;

                return this;
            }
        }

        return this;
    }

    public Employee getById(int id) {
        for (Employee employee : this.storage) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public void printEmployees() {
        for (Employee employee : this.storage) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void printEmployeesFullNames() {
        for (Employee employee : this.storage) {
            if (employee != null) {
                System.out.println(employee.fullName());
            }
        }
    }

    public float getSumOfSalaries() {
        float sumOfSalary = 0;

        for (Employee employee : this.storage) {
            if (employee != null) {
                sumOfSalary += employee.getSalary();
            }
        }

        return sumOfSalary;
    }

    public Employee[] getEmployeesWithMinimumSalary() {
        return getEmployeesWithMinimumSalary(this.storage);
    }

    private Employee[] getEmployeesWithMinimumSalary(Employee[] employees) {
        float minimumSalary = 0;
        Employee[] found;
        int totalCount = 0;
        int i = 0;

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (minimumSalary > employee.getSalary() || minimumSalary == 0) {
                minimumSalary = employee.getSalary();
            }
        }

        for (Employee employee : employees) {
            if (employee != null && minimumSalary == employee.getSalary()) {
                totalCount++;
            }
        }

        found = new Employee[totalCount];

        for (Employee employee : employees) {
            if (employee != null && minimumSalary == employee.getSalary()) {
                found[i] = employee;
                i++;
            }
        }

        return found;
    }

    public Employee[] getEmployeesWithMaximumSalary() {
        return getEmployeesWithMaximumSalary(this.storage);
    }

    private Employee[] getEmployeesWithMaximumSalary(Employee[] employees) {
        float maximumSalary = 0;
        Employee[] found;
        int totalCount = 0;
        int i = 0;

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (maximumSalary < employee.getSalary() || maximumSalary == 0) {
                maximumSalary = employee.getSalary();
            }
        }

        for (Employee employee : employees) {
            if (employee != null && maximumSalary == employee.getSalary()) {
                totalCount++;
            }
        }

        found = new Employee[totalCount];

        for (Employee employee : employees) {
            if (employee != null && maximumSalary == employee.getSalary()) {
                found[i] = employee;
                i++;
            }
        }

        return found;
    }

    public float getAverageSalary() {
        return getAverageSalary(this.storage);
    }

    private float getAverageSalary(Employee[] employees) {
        float averageSalary = 0;
        int countEmployees = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                countEmployees++;
                averageSalary += employee.getSalary();
            }
        }

        if (countEmployees > 0) {
            averageSalary = averageSalary / countEmployees;
        }

        return averageSalary;
    }

    public void increaseSalaryToAll(float percent) {
        for (Employee employee : this.storage) {
            if (employee != null) {
                increaseSalary(employee, percent);
            }
        }
    }

    private void increaseSalary(Employee employee, float percent) {
        if (percent < 0) {
            throw new RuntimeException("Percent must be >= 0.");
        }

        if (employee.getSalary() != 0) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }

    public Employee[] getEmployeesByTeam(String team) {
        Employee[] found;
        int totalCount = 0;
        int i = 0;

        for (Employee employee : this.storage) {
            if (employee != null && team.equals(employee.getTeam())) {
                totalCount++;
            }
        }

        found = new Employee[totalCount];

        for (Employee employee : this.storage) {
            if (employee != null && team.equals(employee.getTeam())) {
                found[i] = employee;
                i++;
            }
        }

        return found;
    }

    public Employee[] getEmployeesWithMinimumSalaryByTeam(String team) {
        Employee[] found = this.getEmployeesByTeam(team);

        if (found == null) {
            return null;
        }

        return this.getEmployeesWithMinimumSalary(found);
    }

    public Employee[] getEmployeesWithMaximumSalaryByTeam(String team) {
        Employee[] found = this.getEmployeesByTeam(team);

        if (found == null) {
            return null;
        }

        return this.getEmployeesWithMaximumSalary(found);
    }

    public float getSumOfSalariesByTeam(String team) {
        float sum = 0;
        Employee[] found = this.getEmployeesByTeam(team);

        if (found == null) {
            return sum;
        }

        for (Employee employee : found) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }

        return sum;
    }

    public float getAverageOfSalariesByTeam(String team) {
        Employee[] found = this.getEmployeesByTeam(team);

        if (found == null) {
            return 0;
        }

        return this.getAverageSalary(found);
    }

    public void increaseSalaryByTeam(String team, float percent) {
        Employee[] employeesByTeam = this.getEmployeesByTeam(team);

        if (employeesByTeam == null) {
            return;
        }

        for (Employee employeeByTeam : employeesByTeam) {
            for (Employee employee : this.storage) {
                if (employee == null) {
                    continue;
                }

                if (employeeByTeam.equals(employee)) {
                    this.increaseSalary(employee, percent);
                }
            }
        }
    }

    public void printEmployeesByTeam(String team) {
        Employee[] employeesByTeam = this.getEmployeesByTeam(team);

        if (employeesByTeam == null) {
            return;
        }

        for (Employee employee : employeesByTeam) {
            System.out.println("Employee{" +
                    "id=" + employee.getId() +
                    ", firstName='" + employee.getFirstName() + '\'' +
                    ", secondName='" + employee.getSecondName() + '\'' +
                    ", thirdName='" + employee.getThirdName() + '\'' +
                    ", salary=" + employee.getSalary() +
                    "}");
        }
    }

    public void printEmployeesWithSalaryLessThan(float value) {
        for (Employee employee : this.storage) {
            if (employee == null) {
                continue;
            }

            if (employee.getSalary() < value) {
                this.printEmployeeFormatIdFullNameSalary(employee);
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(float value) {
        for (Employee employee : this.storage) {
            if (employee == null) {
                continue;
            }

            if (employee.getSalary() >= value) {
                this.printEmployeeFormatIdFullNameSalary(employee);
            }
        }
    }

    private void printEmployeeFormatIdFullNameSalary(Employee employee) {
        System.out.println(employee.getId() +
                " " + employee.getSecondName() +
                " " + employee.getFirstName() +
                " " + employee.getThirdName() +
                " " + employee.getSalary()
        );
    }
}
