package kiwoong;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDetailImpl implements StudentDetail {

    private final Map<Integer, Student> store = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (store.containsKey(id)) return false;
        store.put(id, student);
        return true;
    }

    @Override
    public boolean removeStudent(int id) {
        return store.remove(id) != null;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        return store.replace(id, student) != null;
    }

    @Override
    public int getStudentCount() {
        return store.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return store.values().stream()
                .filter(s -> s.getAge() >= age)
                .map(Student::getName)
                .limit(5)
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        if (part == null) return Optional.empty();
        return store.values().stream()
                .filter(s -> {
                    String p = s.getPart();
                    return p != null && p.equalsIgnoreCase(part);
                })
                .findFirst();
    }

    @Override
    public List<Student> findAllStudents() {
        return store.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .toList();
    }

    @Override
    public void printStudents() {
        store.values().stream().forEach(System.out::println);
    }
}
