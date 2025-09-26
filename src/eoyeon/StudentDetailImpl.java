package eoyeon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Objects;
import java.util.Comparator;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if(studentsMap.containsKey(id)) return false;
        studentsMap.put(id, student);
        return true;
    }

    @Override
    public boolean removeStudent(int id) {
        if(studentsMap.containsKey(id)) {
            studentsMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        if(studentsMap.containsKey(id)) {
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
                .filter(student -> student.getAge() >= age)
                .map(Student::getName)
                .limit(5)
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(student -> Objects.equals(part, student.getPart()))
                .findFirst();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .toList();
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .forEach(System.out::println);
    }
}
