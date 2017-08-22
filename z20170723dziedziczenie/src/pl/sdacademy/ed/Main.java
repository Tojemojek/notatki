package pl.sdacademy.ed;

import pl.sdacademy.ed.model.Tv;
import pl.sdacademy.ed.service.Employee;
import pl.sdacademy.ed.service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        //zadanie 1

//        Tv tvDevice = new Tv ("Orion", "Samsung",
//                2015, true);
//
//        System.out.println(tvDevice.getElectronicDeviceDetails());
//

        //Zadanie 2

        Employee employee = new Employee("Krzysiek", "Expert");
        Employee employee2 = new Employee("NieKrzysiek", "Regular");

        System.out.println(EmployeeService.calculateSalary(employee));
        System.out.println(EmployeeService.calculateSalary(employee2));






    }



}
