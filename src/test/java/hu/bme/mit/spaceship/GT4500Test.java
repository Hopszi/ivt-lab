package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  
  private DataAccess mockDA;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockDA = mock(DataAccess.class);
    this.ship = new GT4500(mockDA);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockDA.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockDA, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockDA.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockDA, times(1)).fire(1);
  }

}
