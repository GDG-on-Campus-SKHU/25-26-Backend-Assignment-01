package parkyumee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            return studentsMap.replace(id, student) != null;
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
                .toList(); //불변객체
                //.collect(Collectors.tolist()); //가변객체
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream()
                .forEach(System.out::println);
    }
}
