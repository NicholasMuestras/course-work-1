// Stuff book

import java.util.Arrays;

public class Main {

    protected static Employee[] storage = new Employee[10];

    public static void main(String[] args) {
        storage[0] = new Employee("Ben", "Gun", "Yoshkovich", "2", 10.5F);
        storage[2] = new Employee("Gans", "Grueber", "", "1", 100.0F);
//        storage[3] = new Employee("Josef", "Barbera", "", "3", -1.0F);
        storage[6] = new Employee("Devi", "Jons", "", "2", 10.5F);
        storage[9] = new Employee("Mike", "Vazovski", "", "3", 100.0F);

        // Requirements Basic
        System.out.println("Список всех сотрудников со всеми данными:");
        printEmployees();
        System.out.println("Список ФИО всех сотрудников:");
        printEmployeesFullNames();
        System.out.println("Сумма затрат на ЗП: " + getSumOfSalaries());
        System.out.println("Поиск сотрудника с минимальной ЗП: " + Arrays.toString(getEmployeesWithMinimumSalary()));
        System.out.println("Поиск сотрудника с максимальной ЗП: " + Arrays.toString(getEmployeesWithMaximumSalary()));
        System.out.println("Подсчет среднего значения ЗП: " + getAverageSalary());
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
        float minimumSalary = 0;
        Employee[] found = null;

        for (Employee employee : storage) {
            if (employee == null) {
                continue;
            }

            if (minimumSalary > employee.getSalary() || minimumSalary == 0) {
                minimumSalary = employee.getSalary();
            }
        }

        for (Employee employee : storage) {
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
        float maximumSalary = 0;
        Employee[] found = null;

        for (Employee employee : storage) {
            if (employee == null) {
                continue;
            }

            if (maximumSalary < employee.getSalary() || maximumSalary == 0) {
                maximumSalary = employee.getSalary();
            }
        }

        for (Employee employee : storage) {
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
        float averageSalary = 0;
        int countEmploees = 0;

        for (Employee employee : storage) {
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
}
