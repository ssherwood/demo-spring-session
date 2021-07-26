package io.undertree.demos.springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.Instant;

@SpringBootApplication
public class SpringSessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionDemoApplication.class, args);
    }

//    @Bean
//    public static ConfigureRedisAction configureRedisAction() {
//        return ConfigureRedisAction.NO_OP; // used to get past initial Lettuce exception
//    }

    @Controller
    public class GreetingController {

        @GetMapping("/greeting")
        public String greeting(HttpSession session, @RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
            // put something new in the session
            var timeStamp = Instant.now();
            session.setAttribute("time_stamp", timeStamp);

            // add lots of attributes...
            for (int i = 0; i < 50; i++) {
                session.setAttribute("foo" + i, "bar" + i + timeStamp);
            }

            model.addAttribute("name", name);
            model.addAttribute("time_stamp", timeStamp);
            return "greeting";
        }
    }
}
