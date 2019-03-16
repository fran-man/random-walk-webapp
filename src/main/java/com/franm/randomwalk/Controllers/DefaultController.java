package com.franm.randomwalk.Controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import com.franm.randomwalk.Walk.GridGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController{
  @Autowired
  private GridGenerator generator;

  private static final String DEFAULT_ENDPOINT = "/";

  @RequestMapping(value = DEFAULT_ENDPOINT, method = RequestMethod.GET)
  public String defaultMapping(){
    return "Hello! " + this.generator.GenerateGridFromCoordinates();
  }

}