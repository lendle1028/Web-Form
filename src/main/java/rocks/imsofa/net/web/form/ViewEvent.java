/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.net.web.form;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ViewEvent annotates a method that handles
 * the event with name specified by the value
 * @author s1088
 */
@Retention(value=RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ViewEvent {
    /**
     * the name of the event
     * @return 
     */
    String value();
}
