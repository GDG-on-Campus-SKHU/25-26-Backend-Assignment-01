package 강우혁;

import java.util.*;
import java.util.stream.Collectors;


public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    // 1번
    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) { //containsKey(id) : map에 지정된 키를 포함하는지 여부 반환 ture : 값있다. false : 값이 없다.
            return false;
        } else {
            studentsMap.put(id, student); // put(K, V) : 지정된 키 와 값을 넣는다.
            return true;
        }
    }

    //2번
    @Override
    public boolean removeStudent(int id) {
        if (studentsMap.containsKey(id)) {
            studentsMap.remove(id); // remove(K) : key의 값을 제거한다.
            return true;
        } else {
            return false;
        }
    }

    //3번
    @Override
    public boolean updateStudent(int id, Student student) {
        if (studentsMap.containsKey(id)) {
            studentsMap.put(id, student);
            return true;
        } else {
            return false;
        }
    }

    //4번
    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    //5번
    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        return studentsMap.values().stream().filter(student -> student.getAge() >= age).limit(5).map(student -> student.getName()).toList();
    }

    //6번
    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream().filter(student -> student.getPart().equals(part)).findAny();
    }

    //7번
    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream().collect(Collectors.toList());
    }

    //8번
    @Override
    public void printStudents() {
        studentsMap.values().forEach(System.out::println);
    }
}
