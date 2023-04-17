package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);
        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    public @ResponseBody String requestParamV2(
            @RequestParam("username") String userName,
            @RequestParam("age") int memberAge ){

        log.info("username={}, age={}",userName,memberAge);
        return "ok";
    }
    @RequestMapping("/request-param-v3")
    public @ResponseBody String requestParamV3(
            @RequestParam String userName,
            @RequestParam int memberAge ){

        log.info("username={}, age={}",userName,memberAge);
        return "ok";
    }
    @RequestMapping("/request-param-v4")
    public @ResponseBody String requestParamV4(
            String userName,
            int memberAge ){

        log.info("username={}, age={}",userName,memberAge);
        return "ok";
    }
    @RequestMapping("/request-param-v5")
    public @ResponseBody String requestParamV5(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) int memberAge ){

        log.info("username={}, age={}",userName,memberAge);
        return "ok";
    }

    @RequestMapping("/request-param-map")
    public @ResponseBody String requestParamMap(
        @RequestParam Map<String,Object> paramMap ){

        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV1(HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());
        return "ok";
    }
}