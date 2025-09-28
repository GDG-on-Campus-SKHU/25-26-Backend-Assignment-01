package parkyumee;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) {
            return false;
        }
        else {
            Student newStudent = new Student(student.getName(), student.getAge(), student.getPart(), student.getBirthday().toString());
            studentsMap.put(id, newStudent);

            return true;
        }

    }

    @Override
    public boolean removeStudent(int id) {
        if (studentsMap.containsKey(id)){
            studentsMap.remove(id);

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        if (studentsMap.containsKey(id)){
            studentsMap.put(id, student);

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream() .filter(s -> s.getAge() >= age) .limit(5) .map(Student::getName) .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream() .filter(s -> s.getPart() .equals(part)) .findFirst();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream() .sorted(Comparator.comparing(Student::getBirthday)).toList();
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream() .forEach(s -> System.out.println(s));
    }
}
