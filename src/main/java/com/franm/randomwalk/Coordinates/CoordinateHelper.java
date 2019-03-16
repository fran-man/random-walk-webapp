package com.franm.randomwalk.Coordinates;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class CoordinateHelper {

  private AtomicLong x = new AtomicLong(4L); //Middle

  public CoordinateHelper(){

  }

  public long IncrementCoordinates(){
    return this.x.incrementAndGet();
  }

  public long getXCoord(){
    return this.x.longValue();
  }
}
