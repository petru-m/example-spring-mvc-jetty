package eu.petru.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

//Test controller

@Controller
@SuppressWarnings("UnusedDeclaration")
public class IndexController {


    @Value("${message}")
    private String message;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return message;
    }

   
        @RequestMapping(value = "/test")
        public ModelAndView showTest () {
            ModelAndView model=new ModelAndView("test");
           

            Map<String,Object>modelMap=new LinkedHashMap<String, Object>();
            modelMap.put("message","Hello");

            

        model.addAllObjects(modelMap);
            return model;
        }
    
    }
