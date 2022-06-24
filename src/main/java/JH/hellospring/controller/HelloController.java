package JH.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Controller도 이 Notaion 꼭 필요
public class HelloController {

    @GetMapping("hello") // Web app 에서 flush(?) hello 라고 들어오면 이 method를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");  // {key, value} : {"data", "hello!!"}
        return "hello"; // hello.html에 가서 렌더링을 하라는 의미.
                        // resources:templates/ + {return Name}.html 을 찾아간다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) { // required default 값은 true
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 인데, 이전과의 차이가 뭐냐면 view가 없이 이 문자가 그대로 내려간다.
    @GetMapping("hello-string")
    @ResponseBody   // http에서 head부/body부가 있는데 이 data를 body부에 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody   // http내 응답에 그대로 data를 넘긴다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
