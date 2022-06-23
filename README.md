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
2. `cd build/libs`
3. `java -jar hello-spring-0.0.1-SNAPSHOT.jar`
    - 서버 배포할때는 위 hello-spring-0.0.1-SNAPSHOT.jar 파일만 복사해서 서버에 넣어서 배포