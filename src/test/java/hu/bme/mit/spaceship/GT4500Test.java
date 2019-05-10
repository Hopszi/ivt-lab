package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  
  private TorpedoStore mockTS;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockTS = mock(TorpedoStore.class);
    this.ship = new GT4500(mockTS);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTS.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockTS, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTS.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockTS, times(1)).fire(1);
  }

}
