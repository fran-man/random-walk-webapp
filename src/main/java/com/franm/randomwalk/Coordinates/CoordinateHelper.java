package com.franm.randomwalk.Coordinates;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
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
  private int startx = 5; //Middle

  private int y = 5;
  private int starty = 5; //Middle

  private final Random ran = new Random();

  @Autowired
  public CoordinateHelper(@Value("${grid.width:9}") final int width, @Value("${grid.height:9}") final int height){
    if(width % 2 == 0){
      this.startx = width/2;
      this.x = width/2;
    }
    else{
      this.startx = (width - 1)/2;
      this.x = (width - 1)/2;
    }

    if(height % 2 == 0){
      this.starty = height/2;
      this.y = height/2;
    }
    else{
      this.starty = (height - 1)/2;
      this.y = (height - 1)/2;
    }
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
