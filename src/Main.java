// Stuff book

import java.util.Arrays;

public class Main {

    protected static Employee[] storage = new Employee[10];

    public static void main(String[] args) {
        storage[0] = new Employee("Ben", "Gun", "Yoshkovich", "2", 10.5F);
        storage[2] = new Employee("Gans", "Grueber", "", "1", 100.0F);
//        storage[3] = new Employee("Josef", "Barbera", "", "3", -1.0F); // to check exception
        storage[6] = new Employee("Devi", "Jons", "", "2", 10.5F);
        storage[8] = new Employee("Mike", "Vazovski", "", "3", 100.0F);
        storage[9] = new Employee("Bond", "James", "", "3", 99.9F);

        // Requirements Basic
        System.out.println("Список всех сотрудников со всеми данными:");
        printEmployees();
        System.out.println("Список ФИО всех сотрудников:");
        printEmployeesFullNames();
        System.out.println("Сумма затрат на ЗП: " + getSumOfSalaries());
        System.out.println("Поиск сотрудника с минимальной ЗП: " + Arrays.toString(getEmployeesWithMinimumSalary()));
        System.out.println("Поиск сотрудника с максимальной ЗП: " + Arrays.toString(getEmployeesWithMaximumSalary()));
        System.out.println("Подсчет среднего значения ЗП: " + getAverageSalary());

        // Requirements Increased
        System.out.println("Список проиндексированных ЗП сотрудников:");
        increaseSalaryToAll(25);
        printEmployees();

        System.out.println("Получить в качестве параметра номер отдела (1-5) И ");
        System.out.println("найти сотрудника с минимальной зп: " + Arrays.toString(getEmployeesWithMinimumSalaryByTeam("3")));
        System.out.println("найти сотрудника с максимальной зп: " + Arrays.toString(getEmployeesWithMaximumSalaryByTeam("3")));
        System.out.println("найти сумму затрат на зп по отделу: " + getSumOfSalariesByTeam("3"));
        System.out.println("найти среднюю зп по отделу: " + getAverageOfSalariesByTeam("3"));
        System.out.println("проиндексировать зп отдела на процент: ");
        increaseSalaryByTeam("2", 10);
        printEmployees();
        System.out.println("напечатать всех сотрудников отдела (все данные, кроме отдела):");
        printEmployeesByTeam("3");

        System.out.println("Получить в качестве параметра число и вывести:");
        System.out.println("всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль):");
        printEmployeesWithSalaryLessThan(45.5F);
        System.out.println("всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль):");
        printEmployeesWithSalaryMoreThan(45.5F);
    }

    protected static void printEmployees() {
        for (Employee employee : storage) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    protected static void printEmployeesFullNames() {
        for (Employee employee : storage) {
            if (employee != null) {
                System.out.println(employee.fullName());
            }
        }
    }

    protected static float getSumOfSalaries() {
        float sumOfSalary = 0;

        for (Employee employee : storage) {
            if (employee != null) {
                sumOfSalary += employee.getSalary();
            }
        }

        return sumOfSalary;
    }

    protected static Employee[] getEmployeesWithMinimumSalary() {
        return getEmployeesWithMinimumSalary(storage);
    }

    protected static Employee[] getEmployeesWithMinimumSalary(Employee[] employees) {
        float minimumSalary = 0;
        Employee[] found = null;

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (minimumSalary > employee.getSalary() || minimumSalary == 0) {
                minimumSalary = employee.getSalary();
            }
        }

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (minimumSalary != employee.getSalary()) {
                continue;
            }

            if (found == null) {
                found = new Employee[1];
                found[0] = employee;
            } else {
                found = Arrays.copyOf(found, found.length + 1);
                found[found.length - 1] = employee;
            }
        }

        return found;
    }

    protected static Employee[] getEmployeesWithMaximumSalary() {
        return getEmployeesWithMaximumSalary(storage);
    }

    protected static Employee[] getEmployeesWithMaximumSalary(Employee[] employees) {
        float maximumSalary = 0;
        Employee[] found = null;

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (maximumSalary < employee.getSalary() || maximumSalary == 0) {
                maximumSalary = employee.getSalary();
            }
        }

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            if (maximumSalary != employee.getSalary()) {
                continue;
            }

            if (found == null) {
                found = new Employee[1];
                found[0] = employee;
            } else {
                found = Arrays.copyOf(found, found.length + 1);
                found[found.length - 1] = employee;
            }
        }

        return found;
    }

    protected static float getAverageSalary() {
        return getAverageSalary(storage);
    }

    protected static float getAverageSalary(Employee[] employees) {
        float averageSalary = 0;
        int countEmploees = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                countEmploees++;
                averageSalary += employee.getSalary();
            }
        }

        if (countEmploees > 0) {
            averageSalary = averageSalary / countEmploees;
        }

        return averageSalary;
    }

    protected static void increaseSalaryToAll(float percent) {
        for (Employee employee : storage) {
            if (employee != null) {
                increaseSalary(employee, percent);
            }
        }
    }

    protected static Employee increaseSalary(Employee employee, float percent) {
        if (percent < 0) {
            throw new RuntimeException("Percent must be >= 0.");
        }

        if (employee.getSalary() == 0) {
            return employee;
        }

        employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);

        return employee;
    }

    private static Employee[] getEmployeesByTeam(String team) {
        Employee[] found = null;

        for (Employee employee : storage) {
            if (employee == null) {
                continue;
            }

            if (!team.equals(employee.getTeam())) {
                continue;
            }

            if (found == null) {
                found = new Employee[1];
                found[0] = employee;
            } else {
                found = Arrays.copyOf(found, found.length + 1);
                found[found.length - 1] = employee;
            }
        }

        return found;
    }

    private static Employee[] getEmployeesWithMinimumSalaryByTeam(String team) {
        Employee[] found = getEmployeesByTeam(team);

        if (found == null) {
            return null;
        }

        return getEmployeesWithMinimumSalary(found);
    }

    private static Employee[] getEmployeesWithMaximumSalaryByTeam(String team) {
        Employee[] found = getEmployeesByTeam(team);

        if (found == null) {
            return null;
        }

        return getEmployeesWithMaximumSalary(found);
    }

    private static float getSumOfSalariesByTeam(String team) {
        float sum = 0;
        Employee[] found = getEmployeesByTeam(team);

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

    private static float getAverageOfSalariesByTeam(String team) {
        Employee[] found = getEmployeesByTeam(team);

        if (found == null) {
            return 0;
        }

        return getAverageSalary(found);
    }

    protected static void increaseSalaryByTeam(String team, float percent) {
        Employee[] employeesByTeam = getEmployeesByTeam(team);

        if (employeesByTeam == null) {
            return;
        }

        for (Employee employeeByTeam : employeesByTeam) {
            for (Employee employee : storage) {
                if (employee == null) {
                    continue;
                }

                if (employeeByTeam.equals(employee)) {
                    increaseSalary(employee, percent);
                }
            }
        }
    }

    protected static void printEmployeesByTeam(String team) {
        Employee[] employeesByTeam = getEmployeesByTeam(team);

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

    protected static void printEmployeesWithSalaryLessThan(float value) {
        for (Employee employee : storage) {
            if (employee == null) {
                continue;
            }

            if (employee.getSalary() < value) {
                printEmployeeFormatIdFullNameSalary(employee);
            }
        }
    }

    protected static void printEmployeesWithSalaryMoreThan(float value) {
        for (Employee employee : storage) {
            if (employee == null) {
                continue;
            }

            if (employee.getSalary() >= value) {
                printEmployeeFormatIdFullNameSalary(employee);
            }
        }
    }

    protected static void printEmployeeFormatIdFullNameSalary(Employee employee) {
        System.out.println(employee.getId() +
                " " + employee.getSecondName() +
                " " + employee.getFirstName() +
                " " + employee.getThirdName() +
                " " + employee.getSalary()
        );
    }
}
