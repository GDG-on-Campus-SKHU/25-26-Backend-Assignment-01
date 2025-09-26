package seokhwan;

import java.util.*;

public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id)){
            return false;
        }
        else {
            studentsMap.put(id,student);
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
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age) //입력받은 age보다 s(getAge)가 더 클때
                .map(Student::getName) //반환값이 List<String>이므로 getName으로 반환값 변경
                .limit(5) //5개까지 받기
                .toList(); //리스트로 반환
    }

    @Override
    public Optional<Student> findStudentByPart(String part) {
        return studentsMap.values().stream()
                .filter(s -> s.getPart().equals(part)) //파트가 같을 경우에
                .findFirst(); // 첫번째 값 반환
    }

    @Override
    public List<Student> findAllStudents() {
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday)) //오름차순으로 생일 정렬하기
                .toList(); //리스트로 반환
    }

    @Override
    public void printStudents() {
        studentsMap.values().stream() //반환값 void니 return으로 하지 않는다
                .sorted(Comparator.comparing(Student::getBirthday)) //오름차순으로 생일 정렬하기(딱히 정렬 방법이 정해져있진 않음)
                .forEach(System.out::println); //모든 값들 반환
    }
}