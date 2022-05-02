/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author lendle
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public ModelAndView indexAction(HttpServletRequest request, Model model) {
        Map data = Map.of("attr1", 1, "attr2", 2, "attr2s", List.of(1, 2, 3, 4, 5));
        model.addAttribute("data", data);
        model.addAttribute("url", "/");
        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();

        System.out.println(request.getRequestURI());
        return new ModelAndView("index");
    }
    
    @PostMapping("/")
    public Map update(@RequestBody Map data){
        List attr2s=new ArrayList();
        int attr1=Integer.valueOf(""+data.get("attr1"));
        for(int i=0; i<=5; i++){
            attr2s.add(attr1+i);
        }
        int attr2=attr1;
        data.put("attr1", attr1);
        data.put("attr2", attr2);
        data.put("attr2s", attr2s);
        return data;
    }
}
