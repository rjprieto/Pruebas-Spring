package com.companyname.springapp.web;

import junit.framework.Assert;
import java.util.Map;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.service.SimpleProductManager;

public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        Assert.assertEquals("hello", modelAndView.getViewName());
        Assert.assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        Assert.assertNotNull(nowValue);
    }
}