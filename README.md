### Welcome page
1. static content location 에서 `index.html`을 먼저 찾는다.
    - `src/main/resources/static/index.html` 
    - 만약 못 찾으면 `index template`를 찾도록 동작된다.
---
### thymeleaf 템플릿 엔진
1. Welcome page의 모습을 원하는대로 바꿀 수 있다.
2. Links
   - thymeleaf 공식 사이트: https://www.thymeleaf.org/
   - 스프링 공식 튜토리얼: https://spring.io/guides/gs/serving-web-content/
   - 스프링부트 메뉴얼: https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-template-engines
---
### Etc.
1. Web 진입점에서 가장 먼저 실행이 되는 것이 Controller 이다.
---
### Build 하고 실행하는 방법 (Console)
1. `./gradlew build`
    - `build` directory가 생긴다.
2. `cd build/libs`
3. `java -jar hello-spring-0.0.1-SNAPSHOT.jar`
    - 서버 배포할때는 위 hello-spring-0.0.1-SNAPSHOT.jar 파일만 복사해서 서버에 넣어서 배포
4. `./gradlew clean` 혹은 `./gradlew clean build`
    - `build` directory가 다시 사라진다.

---

### Web 개발의 세 가지 방법
1. 정적 컨텐츠
   - 서버에서 뭐 하는 거 없이 파일을 그대로 웹 브라우저에 내려줌
   - spring Boot 는 정적 컨텐츠 기능을 자동으로 제공
   - `/static`에서 제공한다.
2. MVC(Model View Controller)와 Template Engine
   - 가장 많이 하는 방법
   - html을 서버에서 프로그래밍을 해서 html을
      동적으로 바꿔서 내리는 것
      -> 그걸 하기 위해서 MVC를 사용
3. API
   - json 이라는 데이타 구조 포맷으로 준다.
   - 서버끼리 통신할 때! 서버끼리는 html을 내릴 필요가 없으므로