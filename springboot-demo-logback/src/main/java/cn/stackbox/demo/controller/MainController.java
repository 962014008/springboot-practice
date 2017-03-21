/**
 * Project Name:cache
 * Package Name:cn.stackbox.demo.controller
 * Date: 2016-12-08 15:21
 */
package cn.stackbox.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ClassName: MainController <br/>
 * Reason: SomeReason <br/>
 * Date: 2016-12-08 15:21
 *
 * @author SRK.Lyu
 */
@RestController
public class MainController {

    private static Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index() {

        String content = "Request at " + new Date().toString();
        LOG.warn(content);
        return content;
    }
}
