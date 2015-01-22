package eu.petru.example.controller;


import eu.petru.example.data.Employee;
import org.json.JSONObject;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParsePush;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

//Controller for push notification

@Controller
@RequestMapping(value = "/push")

//Using Employee class  because no data validation where set.
//Controller for form
public class PushController {


    @RequestMapping(method = RequestMethod.GET)
    public String viewPush(Map<String, Object> model) throws ParseException {
        


         Employee pushForm = new Employee();
        model.put("pushForm", pushForm);


        return "PushN";
    }
//Sending push notification
    @RequestMapping(method = RequestMethod.POST)
    public String processPush(@ModelAttribute("pushForm")Employee employee,
                                      Map<String, Object> model) throws ParseException {
        
    //Application ID
    String app_id="tagDUSM8qg0wstc8uCXIgDI53RiUfddf0IY5eKeq";
    //REST API Key    
    String api_key="Fp84U6aax6lmoUiuK8NvBGmPfU4KtIZVkTwBVTvt";
        
    Parse.initialize(app_id, api_key);
    ParsePush parsePush=new ParsePush();
        
  //Get form data
    String channel=employee.getName();
    String message=employee.getEmail();
        

   
   //Crete JSON object for push data
   JSONObject json=new JSONObject();
   JSONObject object=new JSONObject();
    object.put("alert",message);    
  
    json.put("data",object);
    json.put("channel",channel);

     parsePush.setData(json);
        
    parsePush.send();

        return "PushView";
    }
}
