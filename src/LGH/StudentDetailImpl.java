package LGH;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.get(id) == null) {
            studentsMap.put(id, student);
            return true;
        }
        else return false;
    }

    @Override
    public boolean removeStudent(int id) {
        if (studentsMap.get(id) != null) {
            studentsMap.remove(id);
            return true;
        }
        else return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        if (studentsMap.get(id) != null) {
            studentsMap.put(id, student);
            return true;
        }
        else return false;
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(student -> student.getAge() >= age) // age 이상의 Age를 가진 쌍 필터
                .map(Student::getName) // Student의 Name요소 반환
                .limit(5) // stream의 크기 제한 (5)
                .toList(); // List 형식으로 반환
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(student -> student.getPart().equals(part))
                .limit(1)
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
                .forEach(student -> System.out.println(student));
    }
}