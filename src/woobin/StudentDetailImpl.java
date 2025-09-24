package woobin;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    private final Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        /*
        studentsMap 안에 id(key) 없으면 put 하고 null 반환 => null == null 은 true이므로 return true;
        있으면 value 반환 => value == null 은 false이므로 return false;
         */
        return studentsMap.putIfAbsent(id, student) == null;
    }

    @Override
    public boolean removeStudent(int id) {
        /*
        studentsMap에 id 없으면 null 반환 => null != null 은 false
        있으면 매핑 삭제 후 old value 반환 => old value != null 은 true
         */
        return studentsMap.remove(id) != null;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        /*
        studentsMap에 id 없으면 null 반환 => null != null 은 false
        있으면 기존 value를 새로운 value로 교체하고, old value 반환 => old value != null 은 true
         */
        return studentsMap.replace(id, student) != null;
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream()
                .filter(student -> student.getAge() >= age)
                .limit(5)
                .map(Student::getName)
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(student -> student.getPart().equals(part))
                .findAny();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .toList();
    }

    @Override
    public void printStudents() {
        studentsMap.values()
                .forEach(System.out::println);
    }
}
