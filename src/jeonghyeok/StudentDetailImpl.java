package jeonghyeok;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDetailImpl implements StudentDetail {
    private final Map<Integer, Student> studentsMap = new HashMap<>();

    // 1번
    // Map의 putIfAbsent() 메서드 사용
    @Override
    public boolean addStudent(int id, Student student) {
        return studentsMap.putIfAbsent(id, student) == null;
    }

    // 2번
    @Override
    public boolean removeStudent(int id) {
        return studentsMap.remove(id) != null;
    }

    // 3번
    // Map의 replace() 메서드 사용
    @Override
    public boolean updateStudent(int id, Student student) {
        return studentsMap.replace(id, student) != null;
    }

    // 4번
    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    // 5번
    // filter > map > limit 순서 변경
    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(student -> student.getAge() >= age)
                .map(Student::getName)
                .limit(5)
                .collect(Collectors.toList());
    }

    // 6번
    // Objects.equals 사용으로 null 처리
    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(student -> Objects.equals(student.getPart(), part))
                .findFirst();
    }

    // 7번
    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .collect(Collectors.toList());
    }

    // 8번
    // 전체 학생 정보 출력 및 불필요한 스트림 삭제
    @Override
    public void printStudents() {
        studentsMap.values()
                .forEach(System.out::println);
    }
}
