package com.franm.randomwalk.Walk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GridGenerator {

  @Value("${grid.width:9}")
  private Integer size;

  public GridGenerator(){

  }

  public String GenerateGridFromCoordinates(long xCoord){
    StringBuilder builder = (xCoord == -1 ? new StringBuilder("+") : new StringBuilder("|"));

    for(long i = 0; i < this.size; i++){
      builder.append(i == xCoord ? "+" : "-");
    }

    if(xCoord == this.size){
      builder.append("+");
    }
    else{
      builder.append("|");
    }
    return builder.toString();
  }

  public boolean isGameWon(long xCoord){
    return xCoord == -1 || xCoord == this.size; //TODO: Long vs int does not always work
  }
}
