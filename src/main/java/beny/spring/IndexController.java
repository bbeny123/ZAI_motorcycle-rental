package beny.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bbeny on 03.06.2017.
 */

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}