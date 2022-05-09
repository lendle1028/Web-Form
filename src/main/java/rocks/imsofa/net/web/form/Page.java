/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rocks.imsofa.net.web.form;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author lendle
 */
public interface Page<T> {
    public T init(HttpServletRequest request, Map pathVariables);
}
