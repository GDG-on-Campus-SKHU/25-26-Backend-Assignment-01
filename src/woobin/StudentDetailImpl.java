package woobin;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id))
            return false;
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
        List<String> list = new ArrayList<>();
        studentsMap.values().stream()
                .filter(student -> student.getAge() >= age)
                .forEach(student -> list.add(student.getName()));

        return list;
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        Optional<Student> student = Optional.empty();
        studentsMap.values().stream()
                .filter(s -> s.getPart().equals(part))
                .limit(1);
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> list = new ArrayList<>();
        studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .forEach(student -> list.add(student));

        return list;
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream().forEach(student
                -> System.out.println("이름: " + student.getName() + ", 나이: " + student.getAge() + ", 파트: " + student.getPart() + ", 생일: " + student.getBirthday()));
    }
}