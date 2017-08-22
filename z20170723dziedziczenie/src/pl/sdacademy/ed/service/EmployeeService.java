package pl.sdacademy.ed.service;

public class EmployeeService {

    private static final Double BASIC_SALARY = 2000D;
    private static final Double EXTRA_BOSS_BONUS = 500D;


    private static Double calculateSalary() {
        return BASIC_SALARY;
    }

    private static Double calculateSalary(Double PREMIA) {
        return calculateSalary() + PREMIA;
    }


    public static Double calculateSalary(Employee employee) {
        if (employee.getPosition().equals("Expert")) {
            return calculateSalary(EXTRA_BOSS_BONUS);
        } else if (employee.getPosition().equals("Regular")) {
            return calculateSalary();
        } else {
            return 0.0;
        }
    }


}
