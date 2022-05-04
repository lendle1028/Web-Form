/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @author lendle
 */
public class WebFormApplication {
    public static void run(Class cl, String [] args){
        SpringApplicationBuilder builder=new SpringApplicationBuilder(cl).properties("spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER");
        builder.build().run(args);
    }
}
