package Hanmin;

import java.util.*;
import java.util.stream.Collectors;

/*
   GDG Backend 스터디 자료를 참고해서 Stream/Optional을 사용해 구현했습니다.
   아직 완전히 익숙하진 않아서 제가 이해한 선에서 간단히 적용했습니다!
 */
public class StudentDetailImpl implements StudentDetail {
    Map<Integer, Student> studentsMap = new HashMap<>();

    @Override
    public boolean addStudent(int id, Student student) {
        if (studentsMap.containsKey(id) || student == null) {
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
        if (!studentsMap.containsKey(id) || student == null) {
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
        // 스터디에서 배운 stream을 써서 나이 조건에 맞는 학생을 고르고
        // 이름만 뽑아서 최대 5명까지만 리스트로 만들어봤습니다.
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age)
                .map(s -> s.getName())
                .limit(5)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Student> findStudentByPart(String part) {
        if (part == null) return Optional.empty();

        return studentsMap.values().stream()
                .filter(s -> part.equals(s.getName()))
                .findFirst();
    }

    @Override
    public List<Student> findAllStudents() {
        //모든 학생을 생일이 빠른 순으로 정렬해서 반환 후
        //Comparator는 아직 메서드 참조를 하는 법을 잘 몰라서
        //그냥 람다식으로 작성했습니다.
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(s -> s.getBirthday()))
                .collect(Collectors.toList());
    }

    @Override
    public void printStudents() {
        studentsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("id=" + e.getKey() + " -> " + e.getValue()));
    }
}
