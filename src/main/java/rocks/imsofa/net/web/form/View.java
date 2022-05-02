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
 *
 * @author s1088
 */
@Retention(value=RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface View {
    /**
     * the paths controlled by this view
     * multiple paths and paths with variables are allowed
     * but the first path must be the one that accepts
     * post with a single ViewModel object; other paths
     * can contain path variables and they will be mapped
     * to the pathVariables parameter in the initViewModel method
     * @return 
     */
    String [] paths();
    /**
     * the template page
     * by default, a template page is a thymeleaf page
     * with a "Main" fragment
     * @return 
     */
    String view();
    /**
     * the layout page
     * @return 
     */
    String layout() default "layouts/Basic";
}
