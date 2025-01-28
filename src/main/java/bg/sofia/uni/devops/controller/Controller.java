package bg.sofia.uni.devops.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping
public class Controller {

    private static final String HELLO_WORLD = "Hello Borislav!";

    @GetMapping("/")
    public String sayHelloWorld() {
        return HELLO_WORLD;
    }

    @GetMapping("/hostname")
    public String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "An error has occurred, please try again";
        }
    }
}
