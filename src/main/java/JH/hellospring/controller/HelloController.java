package JH.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller도 이 Notaion 꼭 필요
public class HelloController {

    @GetMapping("hello") // Web app 에서 flush(?) hello 라고 들어오면 이 method를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");  // {key, value} : {"data", "hello!!"}
        return "hello";
    }
}
