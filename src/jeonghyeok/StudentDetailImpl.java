package jeonghyeok;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDetailImpl implements StudentDetail {
    private final Map<Integer, Student> studentsMap = new HashMap<>();

    // 1번
    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) {
            return false;
        }
        studentsMap.put(id, student);
        return true;
    }

    // 2번
    @Override
    public boolean removeStudent(int id) {
        return studentsMap.remove(id) != null;
    }

    // 3번
    @Override
    public boolean updateStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) {
            studentsMap.put(id, student);
            return true;
        }
        return false;
    }

    // 4번
    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    // 5번
    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(student -> student.getAge() >= age)
                .limit(5)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    // 6번
    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(student -> student.getPart().equals(part))
                .findFirst();
    }

    // 7번
    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .collect(Collectors.toList());
    }

    // 8반
    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .forEach(student -> System.out.println(student.getName()));
    }
}