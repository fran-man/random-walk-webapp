package com.franm.randomwalk.Walk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GridGenerator {

  @Value("${grid.width:10}")
  private Integer size;

  public GridGenerator(){

  }

  public String GenerateGridFromCoordinates(long xCoord){
    StringBuilder builder = new StringBuilder("|");
    for(long i = 0; i < this.size; i++){
      builder.append(i == xCoord ? "+" : "-");
    }
    builder.append("|");
    return builder.toString();
  }
}
