package com.franm.randomwalk.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import java.util.List;
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

  @RequestMapping(value = GRID_LATEST_ENDPOINT, method = RequestMethod.GET, produces="text/plain")
  public ResponseEntity<String> getLatestGrid(){
    List<Integer> coords = this.coordHelper.IncrementCoordinates();
    if(this.generator.isGameWon(coords.get(0), coords.get(1))){
      logger.info("Game won!");
      this.coordHelper.ResetCoords();
    }
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);
    return new ResponseEntity<String>(this.generator.GenerateGridFromCoordinates(coords.get(0), coords.get(1)), headers, HttpStatus.OK);
  }

}
