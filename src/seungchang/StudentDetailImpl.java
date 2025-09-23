package seungchang;

import sample.Student;
import sample.StudentDetail;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if(studentsMap.containsKey(id)){
            return false;
        }
        studentsMap.put(id, student);
        return true;
    }

    @Override
    public boolean removeStudent(int id) {
        if (!studentsMap.containsKey(id)){
            return false;
        }
        studentsMap.remove(id);
        return true;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        if (!studentsMap.containsKey(id)){
            return false;
        }
        studentsMap.put(id, student);
        return true;
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        List<String> names = studentsMap.values().stream()
                .filter(student -> student.getAge() >= 23)
                .limit(5)
                .map(Student::getName)
                .toList();
        return names;
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        Optional<Student> student = studentsMap.values().stream()
                .filter(student1 -> student1.getPart().equals(part)).findAny();
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .toList();
        return students;
    }

    @Override
    public void printStudents() {
        Iterator<Student> studentIterator = findAllStudents().iterator();
        while (studentIterator.hasNext()){
            studentIterator.next().toString();
        }
    }
}
