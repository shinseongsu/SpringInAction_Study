package taco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
*   컨트롤러
 *
 *   / 경로의 웹 요청을 처리한다.
 *
 *   "home" 을 반환한다.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
