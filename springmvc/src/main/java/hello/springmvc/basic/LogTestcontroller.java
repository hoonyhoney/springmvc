package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestcontroller {


    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        log.info("log={}",name);
        log.warn("trace log={}",name);
        log.error(" info log={}",name);

        return "ok";
    }
}
