package io.undertree.demos.springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@SpringBootApplication
public class SpringSessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionDemoApplication.class, args);
    }

//    @Bean
//    public static ConfigureRedisAction configureRedisAction() {
//        return ConfigureRedisAction.NO_OP;
//    }

    @Controller
    public class GreetingController {
        @GetMapping("/greeting")
        public String greeting(HttpSession session, @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
            session.setAttribute("foo", "bar");
            model.addAttribute("name", name);
            return "greeting";
        }

    }
}
