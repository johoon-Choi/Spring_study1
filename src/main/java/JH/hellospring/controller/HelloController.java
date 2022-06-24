package JH.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
