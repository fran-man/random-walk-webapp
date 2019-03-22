package com.franm.randomwalk.Coordinates;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class CoordinateHelper {

  Logger logger = LoggerFactory.getLogger(CoordinateHelper.class);

  private int x = 5;
  private final int start = 5; //Middle

  private final Random ran = new Random();

  public CoordinateHelper(){

  }

  public int IncrementCoordinates(){
    int returnVal = (this.ran.nextInt(2) % 2 == 0) ? ++x : --x;
    logger.debug("x = {}", returnVal);
    return returnVal;
  }

  public int getXCoord(){
    logger.debug("x = {}", this.x);
    return this.x;
  }

  public void ResetCoords(){
    this.logger.info("Resetting...");
    this.x = this.start;
  }
}
