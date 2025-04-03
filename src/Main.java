import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook
                .add(new Employee("Ben", "Gun", "Yoshkovich", "2", 10.5F))
                .add(new Employee("Gans", "Grueber", "", "1", 100.0F))
//                .add(new Employee("Josef", "Barbera", "", "3", -1.0F)) // to check exception
                .add(new Employee("Devi", "Jons", "", "2", 10.5F))
                .add(new Employee("Mike", "Vazovski", "", "3", 100.0F))
                .add(new Employee("Bond", "James", "", "3", 99.9F));

        // Requirements Basic
        System.out.println("Список всех сотрудников со всеми данными:");
        employeeBook.printEmployees();
        System.out.println("Список ФИО всех сотрудников:");
        employeeBook.printEmployeesFullNames();
        System.out.println("Сумма затрат на ЗП: " + employeeBook.getSumOfSalaries());
        System.out.println("Поиск сотрудника с минимальной ЗП: " + Arrays.toString(employeeBook.getEmployeesWithMinimumSalary()));
        System.out.println("Поиск сотрудника с максимальной ЗП: " + Arrays.toString(employeeBook.getEmployeesWithMaximumSalary()));
        System.out.println("Подсчет среднего значения ЗП: " + employeeBook.getAverageSalary());

        // Requirements difficult
        System.out.println("Список проиндексированных ЗП сотрудников:");
        employeeBook.increaseSalaryToAll(25);
        employeeBook.printEmployees();

        System.out.println("Получить в качестве параметра номер отдела (1-5) И ");
        System.out.println("найти сотрудника с минимальной зп: " + Arrays.toString(employeeBook.getEmployeesWithMinimumSalaryByTeam("3")));
        System.out.println("найти сотрудника с максимальной зп: " + Arrays.toString(employeeBook.getEmployeesWithMaximumSalaryByTeam("3")));
        System.out.println("найти сумму затрат на зп по отделу: " + employeeBook.getSumOfSalariesByTeam("3"));
        System.out.println("найти среднюю зп по отделу: " + employeeBook.getAverageOfSalariesByTeam("3"));
        System.out.println("проиндексировать зп отдела на процент: ");
        employeeBook.increaseSalaryByTeam("2", 10);
        employeeBook.printEmployees();
        System.out.println("напечатать всех сотрудников отдела (все данные, кроме отдела):");
        employeeBook.printEmployeesByTeam("3");

        System.out.println("Получить в качестве параметра число и вывести:");
        System.out.println("всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль):");
        employeeBook.printEmployeesWithSalaryLessThan(45.5F);
        System.out.println("всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль):");
        employeeBook.printEmployeesWithSalaryMoreThan(45.5F);

        // Requirements very-difficult: Refactoring done.
        employeeBook.printEmployees();
        System.out.println("Добавить нового сотрудника:");
        employeeBook.add(new Employee("Chuck", "Norris", "", "5", 99.99F));
        employeeBook.printEmployees();

        System.out.println("Получить сотрудника по id 2:");

        var someEmployee = employeeBook.getById(2);

        if (someEmployee == null) {
            System.out.println("(не найден)");
        } else {
            System.out.println(someEmployee);
        }

        System.out.println("Удалить сотрудника по id 2:");
        employeeBook.delete(2);
        employeeBook.printEmployees();

        System.out.println("Добавить нового сотрудника (вместо Devi Jons, ячейка 3):");
        employeeBook.add(new Employee("Jack", "Sparrow", "", "4", 88.88F));
        employeeBook.printEmployees();
    }
}
