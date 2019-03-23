package com.franm.randomwalk.Walk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GridGenerator {

  @Value("${grid.width:9}")
  private int width;

  @Value("${grid.height:9}")
  private int height;

  public GridGenerator(){

  }

  public String GenerateGridFromCoordinates(int xCoord, int yCoord){
    StringBuilder builder = new StringBuilder("");

    for(int j = -1; j <= this.height; j++){
      for(int i = -1; i <= this.width; i++){
        if(xCoord == i && yCoord == j){
          builder.append("+");
        }
        else if(i == -1 || i == this.width){
          builder.append("|");
        }
        else if(j == -1 || j == this.height){
          builder.append("-");
        }
        else{
          builder.append(".");
        }
      }
      builder.append(System.getProperty("line.separator"));
    }
    return builder.toString();
  }

  public boolean isGameWon(int xCoord, int yCoord){
    return xCoord == -1 || xCoord == this.width || yCoord == -1 || yCoord == this.height;
  }
}
