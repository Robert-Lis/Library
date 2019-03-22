package pl.library.Library.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping(value = "/start")
    @ResponseBody
    public String startAppPage() {
        return "hello everyone!";
    }

    @GetMapping(value = "/home")
    @ResponseBody
    public String homeAppPage() {
        return "hello everyone!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/admin")
    @ResponseBody
    public String homeAppPageSecured() {
        return "hello everyone secured!";
    }


}
