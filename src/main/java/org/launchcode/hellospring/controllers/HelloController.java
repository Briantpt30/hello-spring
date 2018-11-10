package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){

        String name = request.getParameter("name");

        return "Hello " + name;
    }
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
    @RequestMapping(value = "lang", method = RequestMethod.GET)
    @ResponseBody
    public String langForm(){

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='select'>" + "<option value='English' name='English'>English</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='Italian'>Italian</option>" +
                "<option value='German'>German</option>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;

    }

    @RequestMapping(value = "lang", method = RequestMethod.POST)
    @ResponseBody
    public String langPost(HttpServletRequest request){

        String name = request.getParameter("name");
        String select = request.getParameter("select");
        String greeting = "";

        switch (select){
            case "English":
                greeting = "Hello ";
                break;
            case "Spanish":
                greeting = "Hola ";
                break;
            case "French":
                greeting = "Bonjour ";
                break;
            case "Italian":
                greeting = "Ciao ";
                break;
            case "German":
                greeting = "Hallo ";
                break;
        }


        return greeting + name;
        }



    }
