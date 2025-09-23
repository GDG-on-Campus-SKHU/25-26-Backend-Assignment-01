package 강우혁;

import java.util.List;
import java.util.Optional;

public class Main {

    static StudentDetail sd = new StudentDetailImpl();

    public static void main(String[] args) {
        System.out.println("8번까지 모두 출력되면 성공!");

        sd.addStudent(1, new Student("김준", 25, "organizer", "2001-04-18"));
        sd.addStudent(2, new Student("윤준석", 23, "organizer", "2003-03-04"));
        sd.addStudent(3, new Student("황재현", 25, "web", "2001-02-13"));
        sd.addStudent(4, new Student("한시연", 22, "mobile", "2004-08-25"));
        sd.addStudent(5, new Student("김태우", 27, "backend", "1999-12-12"));
        sd.addStudent(6, new Student("권지후", 24, "backend", "2002-05-29"));
        sd.addStudent(7, new Student("박대경", 24, "backend", "2002-06-08"));
        sd.addStudent(8, new Student("김보민", 21, "backend", "2005-02-14"));
        sd.addStudent(9, new Student("이솔", 24, "pm", "2002-03-13"));
        sd.addStudent(10, new Student("이서영", 24, "pm", "2002-10-09"));
        sd.addStudent(11, new Student("주현지", 24, "design", "2002-04-05"));
        if (sd.getStudentCount() == 11)
            System.out.println("1. 학생 추가 성공");

        boolean addHong = sd.addStudent(1, new Student("홍길동", 22, "pm", "2004-08-31"));
        boolean addKim = sd.addStudent(12, new Student("김기웅", 25, "backend", "2001-12-27"));
        if (!addHong && addKim)
            System.out.println("2. id 중복확인 성공");

        boolean deleteKim = sd.removeStudent(12);
        boolean deleteWhat = sd.removeStudent(13);
        if (deleteKim && !deleteWhat)
            System.out.println("3. 데이터 삭제 성공");

        boolean updateKim = sd.updateStudent(1, new Student("홍길동", 22, "pm", "2004-08-31"));
        boolean updateWhat = sd.updateStudent(13, new Student("홍길동", 22, "pm", "2004-08-31"));
        if (updateKim && !updateWhat)
            System.out.println("4. 정보 수정 성공");

        List<String> nameList = sd.findStudentsByAgeMoreThan(23);
        if (nameList.size() == 7)
            System.out.println("5. 조건 탐색 성공1");

        Optional<Student> studentOptional = sd.findStudentByPart("backend");
        if (studentOptional.isPresent())
            System.out.println("6. 조건 탐색 성공2");

        List<Student> studentList = sd.findAllStudents();
        if (studentList.size() == 11)
            System.out.println("7. 학생 전체 탐색 성공");

        // sd.printStudents();
        // printStudents()는 구현해야 합니다. 하지만 출력이 길어서 메서드 사용은 하지 않을게요
        // 과제 제출하면 내용 다 보이니까 구현 꼭 해주세요
        System.out.println("8. 학생 전체 출력 성공");
    }
}
