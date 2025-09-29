package 강우혁;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StudentDetailImpl implements StudentDetail {
    private final Map<Integer, Student> studentsMap = new HashMap<>();

    // 1번
    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) return false;
        studentsMap.put(id, student);
        return true;
    }

    //2번
    @Override
    public boolean removeStudent(int id) {
        return studentsMap.remove(id) != null;
    }

    //3번
    @Override
    public boolean updateStudent(int id, Student student) {
        return studentsMap.replace(id, student) != null;
    }

    //4번
    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    //5번
    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age)
                .limit(5)
                .map(Student::getName)
                .toList();
    }

    //6번
    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(s -> s.getPart() == part)
                .findAny();
    }

    //7번
    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .collect(Collectors.toList());
    }

    //8번
    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
