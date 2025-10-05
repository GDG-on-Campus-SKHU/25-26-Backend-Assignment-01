package pjw;

import java.util.*;
import java.util.stream.Collectors;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) {
            return false;
        }
        Student existing = studentsMap.putIfAbsent(id, student);
        return existing == null;
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
            studentsMap.put(id, student);
            return true;
        }
        return false;
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age)
                .map(Student::getName)
                .limit(5)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(s -> s.getPart().equals(part))
                .findAny();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .collect(Collectors.toList());
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .forEach(System.out::println);
    }
}
