# GDG Backend 파트 2주차 과제

## 과제 설명
- 학생을 저장, 관리하는 시스템을 구현해 봅시다. <br>
- 본인의 이름으로 된 패키지 안에 있는 StudentDetail 인터페이스를 사용해 구현하면 됩니다. <br>
- 구현 코드는 StudentDetailImpl 클래스에 작성해 주시기 바랍니다. <br>
- Main 클래스의 main() 메서드를 통해 구현 테스트를 진행할 수 있습니다.

## 구현해야 하는 기능 및 조건
1. addStudent()
   - 파라미터로 받은 정보를 토대로 새로운 학생 인스턴스를 생성해서 저장하는 메서드
   - 멤버는 반드시 컬렉션을 통해 저장해야 합니다.
   - 저장된 모든 멤버의 id는 서로 달라야 합니다.
   - 저장에 성공했다면 true, 실패했다면 false를 반환합니다.
2. removeStudent()
   - id를 토대로 학생을 찾아 컬렉션에서 제거하는 메서드
   - 삭제에 성공했다면 true, 실패했다면(존재하지 않는 id일 경우) false를 반환합니다.
3. updateStudent()
   - id를 토대로 학생을 찾아 수정하는 메서드
   - 수정에 성공했다면 true, 실패했다면(존재하지 않는 id일 경우) false를 반환합니다.
4. studentCount()
   - 컬렉션에 있는 모든 학생의 수를 세는 메서드
   - 컬렉션에 저장된 모든 학생의 수를 반환합니다.
5. findStudentsByAgeMoreThan()
   - 파라미터로 나이를 전달받아, 그 나이 이상의 학생을 List 형태로 반환하는 메서드
   - 조건에 맞는 학생이 5명 이상이라면, 5명만 리스트에 저장합니다.
   - 메서드 내부에서 Stream을 사용해야 합니다.
6. findStudentByPart()
   - 파라미터로 파트명을 전달받아, 그 파트의 학생 하나를 반환하는 메서드
   - 메서드 내부에서 Stream을 사용해야 합니다.
7. findAllStudents()
   - 컬렉션에 저장된 모든 학생을 리스트로 만들어 반환하는 메서드
   - 학생의 생일이 빠른 학생부터 리스트를 반환합니다.
8. printStudents()
   - 컬렉션에 저장된 모든 학생을 출력하는 메서드
   - 메서드 내부에서 Stream을 사용해야 합니다.

## 주의사항
1. 본인의 이름으로 된 패키지에 있는 파일만 수정해야 합니다.
2. main() 메서드로 테스트해서 모든 기능이 정상적으로 동작하는지 확인해 볼 것을 권장합니다.

## 과제 제출
- 본인의 이름으로 된 패키지에 있는 StudentDetailImpl 클래스에 과제를 구현하면 됩니다. <br>

## Description

<!-- 구현 및 작업 내용을 적어주세요 -->

- addStudent 메소드
> id와 student를 전달받아 hashmap 자료형의 id 인자를 key 매개변수로 조회, 해당 key를 포함하고 있지 않다면 put(id, student)으로 추가 후 참 반환, 아니라면 거짓 반환

- removeStudent 메소드
> id를 전달받아 hashmap 자료형의 id 인자를 key 매개변수로 조회, 해당 key를 포함하고 있다면 remove(id)로 삭제 후 참 반환, 아니라면 거짓 반환

- updateStudent 메소드
> id와 student를 전달받아 hashmap 자료형의 id 인자를 key 매개변수로 조회, 해당 key를 포함하고 있다면 put(id, student)로 덮어씌기 후 참 반환, 아니라면 거짓 반환

- getStudentCount 메소드
> hashmap의 길이를 size() 메소드로 반환

- findStudentsByAgeMoreThan 메소드
> stream 메소드를 사용하기 위해 hashmap 자료형을 entryset()으로 set으로 변환, 전달받은 age보다 큰 학생을 거르기 위해 람다 함수로 구현, 길이를 5로 제한 후, 데이터의 요소를 student에서 student.name으로 변환, toList() 메소드로 List 자료형으로 반환

- findStudentByPart 메소드
> stream 메소드를 사용하기 위해 hashmap 자료형을 entryset()으로 set으로 변환, 전달받은 part와 값이 같은 학생을 거르기 위해 람다함수로 구현, 해당 set을 student로 변환, null 값이 올 수도 있으므로 findAny()로 opaional 자료형으로 반환

- findAllStudents 메소드
> stream 메소드를 사용하기 위해 hashmap 자료형을 entryset()으로 set으로 변환, set 요소를 student 객체로 변환, student 객체 내 LocalDate로 저장된 날짜 객체 내의 compareTo() 메소드를 sorted() 메소드에 전달하여 생년월일로 정렬, toList() 메소드로 List 자료형으로 반환
```
/* 아래 코드로 잘 정렬되었는지 확인하였음 */
studentList.stream()
        .forEach(System.out::println);
```
```
이름: 김태우, 나이: 27, 파트: backend, 생일: 1999-12-12
이름: 황재현, 나이: 25, 파트: web, 생일: 2001-02-13
이름: 이솔, 나이: 24, 파트: pm, 생일: 2002-03-13
이름: 주현지, 나이: 24, 파트: design, 생일: 2002-04-05
이름: 권지후, 나이: 24, 파트: backend, 생일: 2002-05-29
이름: 박대경, 나이: 24, 파트: backend, 생일: 2002-06-08
이름: 이서영, 나이: 24, 파트: pm, 생일: 2002-10-09
이름: 윤준석, 나이: 23, 파트: organizer, 생일: 2003-03-04
이름: 한시연, 나이: 22, 파트: mobile, 생일: 2004-08-25
이름: 홍길동, 나이: 22, 파트: pm, 생일: 2004-08-31
이름: 김보민, 나이: 21, 파트: backend, 생일: 2005-02-14
```

- printStudents 메소드
> stream 메소드를 사용하기 위해 hashmap 자료형을 entryset()으로 set으로 변환, System.out 클래스의 println 메소드를 참조하여 forEach() 메소드로 전달, 모든 요소에 대해 println 메소드 실행, 해당 객체에 오버라이딩 되어 있는 toString() 메소드로 출력
```
/* 주석을 해제하여 잘 출력되는지 확인하였음 */
// sd.printStudents();
```
```
1=이름: 홍길동, 나이: 22, 파트: pm, 생일: 2004-08-31
2=이름: 윤준석, 나이: 23, 파트: organizer, 생일: 2003-03-04
3=이름: 황재현, 나이: 25, 파트: web, 생일: 2001-02-13
4=이름: 한시연, 나이: 22, 파트: mobile, 생일: 2004-08-25
5=이름: 김태우, 나이: 27, 파트: backend, 생일: 1999-12-12
6=이름: 권지후, 나이: 24, 파트: backend, 생일: 2002-05-29
7=이름: 박대경, 나이: 24, 파트: backend, 생일: 2002-06-08
8=이름: 김보민, 나이: 21, 파트: backend, 생일: 2005-02-14
9=이름: 이솔, 나이: 24, 파트: pm, 생일: 2002-03-13
10=이름: 이서영, 나이: 24, 파트: pm, 생일: 2002-10-09
11=이름: 주현지, 나이: 24, 파트: design, 생일: 2002-04-05
```

## Important content

<!-- 주의 깊게 봐줬으면 하는 부분을 적어주세요 -->

- 

## Question

<!-- 궁금한 점을 적어주세요 -->

- 

## Reference

<!-- 참고한 레퍼런스가 있다면 공유해 주세요 -->

https://stackoverflow.com/questions/22840170/using-streams-how-can-i-map-the-values-in-a-hashmap
- 과제를 제출할 때에는 AIOS 세션 때와 같이 PR을 통해 본인의 패키지만 제출하면 됩니다.
- PR 제목은 `25-26-Server-Assignment-01_본인이름` 으로 제출해주시기 바랍니다.

### 과제 마감 기한
- 9월 28일 오후 11:59
