package ib.ts_2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {


    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/helloSomeone")
    public String helloSomeone(@RequestParam(required = false) String name, @RequestParam String surname){
        if(name == null) name = "John";
        return "Hello " +name+" "+surname+"!";
    }

    @GetMapping("/helloFromPath")
    public String helloFromPath(@PathVariable String name){
        return "Hello"+name+"!";
    }


    @GetMapping("/helloNumber")
    public int addition(@RequestParam int num1, @RequestParam int num2){
        return num1 + num2;
    }

}

