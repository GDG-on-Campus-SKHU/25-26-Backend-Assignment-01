package ChoiYooRa;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) {
            return false;
        }
        studentsMap.put(id, student);
        return true;
    }

    @Override
    public boolean removeStudent(int id) {
        if (studentsMap.containsKey(id)) {
            studentsMap.remove(id);
            return true;
        }
        return false;
        }

    @Override
    public boolean updateStudent(int id, Student student) {
        if (!studentsMap.containsKey(id)) {
            return false;
        }
        studentsMap.put(id, student);
        return true;
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        String[] sn = new String[5];
        studentsMap.values().stream().filter(student -> student.getAge() >= age).map(student->student.getName()).toList();
        return Arrays.asList(sn);
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream().filter(student -> student.getPart().equals(part)).findFirst();
        //return Optional.ofNullable((studentsMap) part);
    }

    @Override
    public List<Student> findAllStudents() {
        //return studentsMap.values().stream().sorted(Comparator.comparing(student::birthday)).collect(Collectors.toList());
        return studentsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream().forEach(student -> System.out.println(student));
    }
}
