package ru.job4j.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int inn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Person> accounts = new HashSet<>();

    public Employee of(String firstName, String lastName, int inn) {
        Employee employee = new Employee();
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.inn = inn;
        employee.hireDate = new Date(System.currentTimeMillis());
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", inn=" + inn
                + ", hire=" + hireDate
                + ", accounts=" + accounts
                + '}';
    }
}