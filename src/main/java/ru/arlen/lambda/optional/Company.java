package ru.arlen.lambda.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Company {
    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

class Department {
    private String name;
    //    private Manager manager;
    private Optional<Manager> manager = Optional.empty();

    Department(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Optional<Manager> getManager() {
        return manager;
    }

    void setManager(Optional<Manager> manager) {
        this.manager = manager;
    }

    //    Manager getManager() {
//        return manager;
//    }

//    void setManager(Manager manager) {
//        this.manager = manager;
//    }
}

class Manager {
    private String name;

    Manager(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}