package ChoiYooRa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDetailImpl implements StudentDetail {
    private Map<Integer, Student> studentsMap = new HashMap<>();

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
                .filter(student -> student.getAge() >= age)
                .map(Student::getName)
                .limit(5)
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(student -> student.getPart().equals(part))
                .findFirst();
        //findFirst(), findAny()에는 이미 Optional 포함됨
        //return Optional.ofNullable((studentsMap) part);->안 써도 됨
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .collect(Collectors.toList());
        //return studentsMap.values().stream().collect(Collectors.toList());
        //->모든 학생 정렬 없이 반환
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .forEach(System.out::println);
    }
}
