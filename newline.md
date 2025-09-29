# Github EOF 에러


![newline](./newline.png)

예전엔 파일 끝에 개행문자가 없으면 한 줄이 끝나지 않은 것으로 인식 돼서 에러가 발생했었음.
최근에는 파일 끝에 개행문자가 없어도 에러가 발생하지 않지만, 혹시 모를 상황 대비와 POSIX에 명시되어 있기도 하고 관례상 파일 끝에 개행 추가가 권장되는 듯하다.

## IntelliJ 자동 개행 설정
**Editor** -> **General** -> **Ensure every saved file ends with a line break**
