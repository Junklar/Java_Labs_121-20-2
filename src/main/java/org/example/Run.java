package org.example;

import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypycalUniversity();
        System.out.println(university);
    }

    public static University createTypycalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        University university = new UniversityCreator().create("DO", humanCreator.create("a", "b", "c", Sex.FEMALE));
        FacultyCreator facultyCreator = new FacultyCreator(university);

        Faculty faculty = facultyCreator.create("ab-", humanCreator.create("a", "b", "c", Sex.MALE));
        DepartmentCreator departmentCreator = new DepartmentCreator(faculty);

        Department department = departmentCreator.create("abc", humanCreator.create("a", "b", "c", Sex.FEMALE));
        GroupCreator groupCreator = new GroupCreator(department);

        Group group = groupCreator.create("121-20-2");
        StudentCreator studentCreator = new StudentCreator(group);

        Student student = studentCreator.create("a","b","c", Sex.MALE);

        return university;
    }
}