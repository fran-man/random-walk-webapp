package com.franm.randomwalk.Controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import com.franm.randomwalk.Walk.GridGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GridController{
  @Autowired
  private GridGenerator generator;

  private static final String GRID_LATEST_ENDPOINT = "/grid/latest";

  @RequestMapping(value = GRID_LATEST_ENDPOINT, method = RequestMethod.GET)
  public String getLatestGrid(){
    return this.generator.GenerateGridFromCoordinates();
  }

}
