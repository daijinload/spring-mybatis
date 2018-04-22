package com.example.project.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

  private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
  private final WelcomeService welcomeService;

  @Autowired
  public WelcomeController(WelcomeService welcomeService) {
    this.welcomeService = welcomeService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public String index() {
    logger.debug("index() is executed!");
    return "Hello!!";
  }
}
