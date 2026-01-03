package com.globalin.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    public void test(HttpServletResponse resp) throws IOException {
    		resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write("User API OK");
    }
}
