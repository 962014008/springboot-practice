/**
 * Project Name:i18n
 * Package Name:cn.stackbox.demo.controller
 * Date: 2017-02-25 18:15
 */
package cn.stackbox.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: MainController <br/>
 * Reason: SomeReason <br/>
 * Date: 2017-02-25 18:15
 *
 * @author SRK.Lyu
 */
@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String main() {
        return "main";
    }
}
