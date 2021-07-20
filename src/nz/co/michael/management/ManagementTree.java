package nz.co.michael.management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManagementTree {

    public static void main(String[] args) {
        Employee a = new Employee(10, "Tom", 0);
        Employee b = new Employee(2, "Mickey", 10);
        Employee c = new Employee(3, "Jerry", 10);
        Employee d = new Employee(7, "Johm", 2);
        Employee e = new Employee(5, "Sarah", 10);
        List<Employee> list = new ArrayList<Employee>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        displayManagementTree(list);
    }

    public static void displayManagementTree(Collection<Employee> employees) {
        int rootManegerCount = (int)employees.stream().filter(item -> 0==item.getManagerId()).count();
        if (rootManegerCount == 0) {
            System.out.println("no root manager found");
        }
        else if (rootManegerCount > 1) {
            System.out.println("more than one root managers found");
        }
        else {
            employees.stream().filter(item -> 0==item.getManagerId())
                    .forEach(item -> {
                        System.out.println("->" + item.getName());
                        item.setName("->");
                        getChildren(item, employees);
                    });
        }
    }

    private static void getChildren(Employee root, Collection<Employee> all){
        all.stream().filter(item -> item.getManagerId()==root.getId())
                .forEach((item) -> {
                    System.out.println(root.getName() + "->" + item.getName());
                    item.setName(root.getName() + "->");
                    getChildren(item, all);
                });
    }

}
