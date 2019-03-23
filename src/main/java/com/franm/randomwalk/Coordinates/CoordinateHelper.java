package com.franm.randomwalk.Coordinates;

import java.util.Arrays;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class CoordinateHelper {

  Logger logger = LoggerFactory.getLogger(CoordinateHelper.class);

  private int x = 5;
  private final int startx = 5; //Middle

  private int y = 5;
  private final int starty = 5; //Middle

  private final Random ran = new Random();

  public CoordinateHelper(){

  }

  public List<Integer> IncrementCoordinates() {
    int nextRandom = this.ran.nextInt(4);
    switch (nextRandom) {
    case 0:
      this.x++;
      break;
    case 1:
      this.x--;
      break;
    case 2:
      this.y++;
      break;
    case 3:
      this.y--;
      break;
    }
    return Arrays.asList(this.x,this.y);
  }

  public void ResetCoords(){
    this.logger.info("Resetting...");
    this.x = this.startx;
    this.y = this.starty;
  }
}
