package Leebohyeon;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (!studentsMap.containsKey(id)) {
            studentsMap.put(id, student);
            return true;
        }
        return false;
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
        if (studentsMap.containsKey(id)) {
            studentsMap.put(id,student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getStudentCount() {
        List<String> names = studentsMap.values().stream()
                .filter(s -> s.getAge() >=23)
                .map(s -> s.getName())
                .toList();
        return names.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age)
                .map(Student::toString)
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(s -> s.getPart().equals(part))
                .findFirst();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());
    }

    @Override
    public void printStudents() {
        studentsMap.values()
                .forEach(System.out::println);
    }
}
