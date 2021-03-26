package com.globant.restservice.controllers;

import com.globant.restservice.generators.HelloCustomerGenerator;
import com.globant.restservice.generators.SingletonBean;
import com.globant.restservice.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//@RestController
@Controller
@RequestMapping("/scopes")
public class ScopesController {

    private static final Logger logger = LoggerFactory.getLogger(ScopesController.class);

    @Resource(name = "requestScopedBean")
    private HelloCustomerGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    private HelloCustomerGenerator sessionScopedBean;

    @Resource(name = "applicationScopedBean")
    private HelloCustomerGenerator applicationScopedBean;

    @Autowired
    @Qualifier("personSingleton")
    private Person sPersonBean;

    @Autowired
    @Qualifier("personPrototype")
    private Person pPersonBean;

    @Autowired
    @Qualifier("sSingletonBean")
    private SingletonBean sSingletonBean;

    @Autowired
    @Qualifier("pSingletonBean")
    private SingletonBean pSingletonBean;

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    @RequestMapping("/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", requestScopedBean.getMessage());
        logger.info("previousMessage : {}", requestScopedBean.getMessage());
        requestScopedBean.setMessage("Good morning!");
        logger.info("currentMessage : {}", requestScopedBean.getMessage());
        model.addAttribute("currentMessage", requestScopedBean.getMessage());
        //return requestScopedBean.getMessage();
        //return requestScopedBean.toString();
        return "scopesExample";
    }

    @RequestMapping("/session")
    public String getSessionScopeMessage(final Model model) {
        model.addAttribute("previousMessage", sessionScopedBean.getMessage());
        logger.info("previousMessage : {}", sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Good afternoon!");
        logger.info("currentMessage : {}", sessionScopedBean.getMessage());
        model.addAttribute("currentMessage", sessionScopedBean.getMessage());
        //return sessionScopedBean.getMessage();
        //return sessionScopedBean.toString();
        return "scopesExample";
    }

    @RequestMapping("/application")
    public String getApplicationScopeMessage(final Model model) {
        model.addAttribute("previousMessage", applicationScopedBean.getMessage());
        logger.info("previousMessage : {}", applicationScopedBean.getMessage());
        applicationScopedBean.setMessage("Good night!");
        logger.info("currentMessage : {}", applicationScopedBean.getMessage());
        model.addAttribute("currentMessage", applicationScopedBean.getMessage());
        //return applicationScopedBean.getMessage();
        //return applicationScopedBean.toString();
        return "scopesExample";
    }

    @RequestMapping("/singleton-person")
    public String getSingletonPerson(@RequestParam(value = "name", defaultValue = NAME) String name) {
        if (sPersonBean.getName() == null) {
            logger.info("Setting name: " + sPersonBean.getName());
            sPersonBean.setName(name);
        }
        logger.info("Person name: " + sPersonBean.getName());
        //return "Person@" + System.identityHashCode(sPersonBean);
        return "scopesExample";
    }

    @RequestMapping("/prototype-person/{id}")
    public String getPrototypePerson(@PathVariable int id) {
        logger.info("BEFORE - Person name: " + pPersonBean.getName());
        pPersonBean.setName(NAME);
        if (id % 2 == 0)
            pPersonBean.setName(NAME_OTHER);
        logger.info("AFTER - Person name: " + pPersonBean.getName());
        //return "Person@" + System.identityHashCode(pPersonBean);
        return "scopesExample";
    }

    @RequestMapping("/singleton")
    public String getSingletonBean() {
        return sSingletonBean.toString();
    }

    @RequestMapping("/prototype")
    public String getPrototypeBean() {
        return pSingletonBean.toString();
    }

}
