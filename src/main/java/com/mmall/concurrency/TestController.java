package com.mmall.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-10-27
 * Time: 上午9:09
 */
@Controller
@Slf4j
public class TestController {


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
