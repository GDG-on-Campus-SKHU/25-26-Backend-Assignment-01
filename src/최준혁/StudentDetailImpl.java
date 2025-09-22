package 최준혁;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if(!studentsMap.containsKey(id)){
            studentsMap.put(id, student);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeStudent(int id) {
        if(studentsMap.containsKey(id)){
            studentsMap.remove(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        if(studentsMap.containsKey(id)){
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
        return studentsMap.entrySet().stream()
                .filter(e -> e.getValue().getAge() >= age)
                .limit(5)
                .map(e -> e.getValue().getName())
                .toList();
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.entrySet().stream()
                .filter(e -> part.equals(e.getValue().getPart()))
                .map(e -> e.getValue())
                .findAny();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.entrySet().stream()
                .map(e -> e.getValue())
                .sorted(Comparator.comparing(e -> e.getBirthday()))
                .toList();
    }

    @Override
    public void printStudents() {
        studentsMap.entrySet().stream()
                .forEach(System.out::println);
    }
}
