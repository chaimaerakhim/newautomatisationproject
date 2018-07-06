package com.neoxia.newautomatisationproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "views/index";
    }
    @GetMapping("/test")
    public String test() throws Exception {

        try{
            runCypress();
            return "views/index";
        }catch(Exception e){
            return "views/index";
        }

    }

    public void runCypress()  throws Exception{
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Users\\admin\\IdeaProjects\\automatisationProject\\src\\test\\com.neoxia.cypresstest\" && npm run test");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }

    }
}
