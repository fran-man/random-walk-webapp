package com.franm.randomwalk.Coordinates;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class CoordinateHelper {

  private AtomicLong x = new AtomicLong(5L); //Middle
  private AtomicLong start = new AtomicLong(5L); //Middle

  private final Random ran = new Random();

  public CoordinateHelper(){

  }

  public long IncrementCoordinates(){
    return (this.ran.nextInt(2) % 2 == 0) ? this.x.incrementAndGet() : this.x.decrementAndGet();
  }

  public long getXCoord(){
    return this.x.longValue();
  }

  public void ResetCoords(){
    this.x = this.start;
  }
}
