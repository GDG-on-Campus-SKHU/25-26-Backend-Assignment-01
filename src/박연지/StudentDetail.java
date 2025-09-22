package 박연지;

import java.util.List;
import java.util.Optional;

public interface StudentDetail {

    /*
        저장소에 학생을 추가하는 메서드
        id와 학생 정보를 저장소에 저장합니다.
        이미 존재하는 id라면 저장에 실패하여 false를 반환합니다.
        저장에 성공하면 true를 반환합니다.
     */
    boolean addStudent(int id, Student student);

    /*
        저장소에 있는 학생 정보를 삭제하는 메서드
        id를 기반으로 삭제할 학생을 찾아 삭제합니다.
        존재하지 않는 id라면 false를 반환합니다.
        삭제에 성공하면 true를 반환합니다.
     */
    boolean removeStudent(int id);

    /*
        저장소에 있는 학생 정보를 수정하는 메서드
        id를 기반으로 수정할 학생을 찾아 수정합니다.
        존재하지 않는 id라면 false를 반환합니다.
        수정에 성공하면 true를 반환합니다.
     */
    boolean updateStudent(int id, Student student);

    /*
        저장소에 있는 학생의 수를 세는 메서드
        저장소에 저장된 학생의 수를 반환합니다.
     */
    int getStudentCount();

    /*
        저장소에 있는 학생 중, 23살 이상인 학생의 이름을 리스트에 저장하는 메서드
        단, 조건에 맞는 학생이 5명 이상이라면 5명만 리스트에 저장합니다.
        stream을 활용해야 합니다.
     */
    List<String> findStudentsByAgeMoreThan(int age);

    /*
        저장소에 있는 학생 중, 파트가 백엔드인 학생 하나를 찾는 메서드
        조건을 만족하는 멤버가 없을 수도 있으니, Optional을 반환합니다.
     */
    Optional<Student> findStudentByPart(String part);

    /*
        학생 목록을 리스트로 만드는 메서드
        저장소에 있는 모든 학생을 리스트로 만들어 반환합니다.
        stream을 사용하여야 합니다.
     */
    List<Student> findAllStudents();

    /*
        학생 리스트를 출력하는 메서드
        저장소의 모든 학생을 출력(print)해야 합니다.
     */
    void printStudents();

}
