/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form.example;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import rocks.imsofa.net.web.form.AbstractPageController;
import rocks.imsofa.net.web.form.View;
import rocks.imsofa.net.web.form.ViewContext;
import rocks.imsofa.net.web.form.ViewEvent;

/**
 *
 * @author lendle
 */
@RestController
@View(paths={"/numberSelector"}, view="/numberSelector", pageClass = NumberSelectorPage.class)
public class NumberSelectorPageController extends AbstractPageController<NumberSelectorViewModel>{
    
}
