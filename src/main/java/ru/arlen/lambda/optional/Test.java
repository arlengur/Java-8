package ru.arlen.lambda.optional;

import java.util.Optional;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        Company company = generateData();
        for (Department dpt : company.getDepartments()) {
//            System.out.println(dpt.getName() + " Manager: " + dpt.getManager().getName());
            if (dpt.getManager().isPresent()) {
                System.out.println(dpt.getName() + " Manager: " + dpt.getManager().get().getName());
            } else {
                System.out.println(dpt.getName() + " Manager: N/A");
            }
        }
    }

    private static Company generateData() {
        Company company = new Company();
        Department department01 = new Department("Accouting");
//        Manager manager01 = new Manager("Jane Doe");
        Optional<Manager> manager01 = Optional.of(new Manager("Jane Doe"));
        department01.setManager(manager01);
        company.addDepartment(department01);

        Department department02 = new Department("Development");
//        Manager manager02 = new Manager("John Doe");
        Optional<Manager> manager02 = Optional.of(new Manager("John Doe"));
        department02.setManager(manager02);
        company.addDepartment(department02);

        Department department03 = new Department("Research");
        company.addDepartment(department03);

        return company;
    }
}
