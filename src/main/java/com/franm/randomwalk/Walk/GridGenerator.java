package com.franm.randomwalk.Walk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GridGenerator {

  @Value("${grid.width:10}")
  private Integer size;

  public GridGenerator(){

  }

  public String GenerateGridFromCoordinates(){
    return size.toString();
  }
}
