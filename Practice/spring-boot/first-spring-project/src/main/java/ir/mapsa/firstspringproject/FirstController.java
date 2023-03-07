package ir.mapsa.firstspringproject;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@JsonAppend
public class FirstController {
    @CrossOrigin(origins = "*")
    @PostMapping(value="/hello")
    public Response sayHelloWorld(@RequestBody Request body){
        Response response = new Response();
        response.setMessage(body.toString());
        return response;
    }

//    @GetMapping("/hello/{from}")
//    public Response sayHelloWorld(@PathVariable("from") String from) {
//        Response response = new Response();
//        response.setMessage("hello world! from " +  from);
//        return response;
//    }
}
