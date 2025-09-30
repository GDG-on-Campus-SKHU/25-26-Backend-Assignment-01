package hanmin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/*
   GDG Backend 스터디 자료를 참고해서 Stream/Optional을 사용해 구현했습니다.
   아직 완전히 익숙하진 않아서 제가 이해한 선에서 간단히 적용했습니다!
 */
public class StudentDetailImpl implements StudentDetail {
    // 학생들을 저장할 컬렉션 (id -> Student)
    // private: 외부에서 직접 접근 막음
    // final: 참조가 다른 객체로 바뀌지 않도록 보장 (참조 불변성)
    private final Map<Integer, Student> studentsMap = new HashMap<>();

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
        // 긍정 조건문으로 가독성 향상
        if (studentsMap.containsKey(id)) {
            studentsMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        // 긍정 조건문 + null 체크
        if (studentsMap.containsKey(id) || student != null) {
            studentsMap.put(id, student);
            return true;
        }
        return false;
    }

    @Override
    public int getStudentCount() {
        return studentsMap.size();
    }

    @Override
    public List<String> findStudentsByAgeMoreThan(int age) {
        // stream으로 필터링
        // 나이가 age 이상인 학생만, 최대 5명까지 반환
        // Collectors.toList()는 가변 리스트를 반환(수정 가능)
        // Java 16+에서는 .toList()로 불변 리스트도 가능
        return studentsMap.values().stream()
                .filter(s -> s.getAge() >= age)
                .map(s -> s.getName())
                .limit(5)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Student> findStudentByPart(String part) {
        // 입력값 방어: null이거나 공백이면 빈 Optional 반환
        if (part == null) return Optional.empty();
        String target = part.trim();
        if (target.isEmpty()) return Optional.empty();

        // Student 자체나 getPart()가 null일 수 있는 경우도 방어
        return studentsMap.values().stream()
                .filter(Objects::nonNull)
                .filter(s -> {
                    String studentPart = s.getName();
                    return studentPart != null && studentPart.trim().contains(target);
    })
                .findFirst();
        }

    @Override
    public List<Student> findAllStudents() {
        // 생일이 빠른 순으로 정렬
        // 처음엔 람다식 (s -> s.getBirthday())을 썼지만,
        // 피드백 받은 대로 메서드 참조(Student::getBirthday)로 바꿔서 가독성과 간결성 챙김.
        return studentsMap.values().stream()
                .sorted(Comparator.comparing(Student::getBirthday))
                .collect(Collectors.toList());
    }

    @Override
    public void printStudents() {
        studentsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("id=" + e.getKey() + " -> " + e.getValue()));
    }
}
