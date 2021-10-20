/**
 * Project Name:dba
 * Package Name:cn.stackbox.demo.controller
 * Date: 2016-12-10 18:36
 */
package cn.stackbox.demo.controller;

import cn.stackbox.demo.entity.User;
import cn.stackbox.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: ApiController <br/>
 * Reason: SomeReason <br/>
 * Date: 2016-12-10 18:36
 *
 * @author SRK.Lyu
 */
@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/listAll")
    public List<User> listAll() {
        return userService.listAll();
    }

    @GetMapping("/findByName/{name}")
    public User findByName(@PathVariable("name") String name) {
        return userService.findByName(name);
    }
}
