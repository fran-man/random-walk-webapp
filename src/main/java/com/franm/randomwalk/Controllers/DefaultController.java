package com.franm.randomwalk.Controllers;

import com.franm.randomwalk.Walk.GridGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController{
  @Autowired
  private GridGenerator generator;
}
