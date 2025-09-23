package parkyeonji;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

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
        if (!studentsMap.containsKey(id)) {
            return false;
        }
        studentsMap.remove(id);
        return true;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        if (!studentsMap.containsKey(id)) {
            return false;
        }
        Student existing = studentsMap.get(id);

        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setPart(student.getPart());
        existing.setBirthday(student.getBirthday());

        return true;

    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age)
                .limit(5)
                .map(Student::getName)
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
                .sorted(Comparator.comparing(Student::getBirthday))
                .toList();
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .forEach(System.out::println);
    }
}
