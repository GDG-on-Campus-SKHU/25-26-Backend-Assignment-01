package kiwoong;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDetailImpl implements StudentDetail {

    // store -> studentsById 로 변경
    private final Map<Integer, Student> studentsById = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        // putIfAbsent 사용
        return studentsById.putIfAbsent(id, student) == null;
    }

    @Override
    public boolean removeStudent(int id) {
        return studentsById.remove(id) != null;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        return studentsById.replace(id, student) != null;
    }

    @Override
    public int getStudentCount() {
        return studentsById.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsById.values().stream()
                .filter(s -> s.getAge() >= age)
                .map(Student::getName)
                .limit(5)
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        if (part == null) {
            return Optional.empty();
        }
        return studentsById.values().stream()
                .filter(s -> {
                    String studentPart = s.getPart(); // p -> studentPart로 변경
                    return studentPart != null && studentPart.equalsIgnoreCase(part);
                })
                .findFirst();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsById.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .toList();
    }

    @Override
    public void printStudents() {
        studentsById.values().stream().forEach(System.out::println);
    }
}
