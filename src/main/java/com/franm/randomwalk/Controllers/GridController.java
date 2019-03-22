package com.franm.randomwalk.Controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.franm.randomwalk.Coordinates.CoordinateHelper;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import com.franm.randomwalk.Walk.GridGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GridController{
  @Autowired
  private GridGenerator generator;

  @Autowired
  private CoordinateHelper coordHelper;

  Logger logger = LoggerFactory.getLogger(GridController.class);

  private static final String GRID_LATEST_ENDPOINT = "/grid/latest";

  @RequestMapping(value = GRID_LATEST_ENDPOINT, method = RequestMethod.GET)
  public String getLatestGrid(){
    int xCoord = this.coordHelper.IncrementCoordinates();
    if(this.generator.isGameWon(xCoord)){
      logger.info("Game won!");
      this.coordHelper.ResetCoords();
    }
    return this.generator.GenerateGridFromCoordinates(xCoord);
  }

}
