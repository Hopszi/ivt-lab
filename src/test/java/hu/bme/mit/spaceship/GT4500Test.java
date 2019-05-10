package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  
  private TorpedoStore mockpTS;
  private TorpedoStore mocksTS;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockpTS = mock(TorpedoStore.class);
    mocksTS = mock(TorpedoStore.class);
    this.ship = new GT4500(mockpTS, mocksTS);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockpTS.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockpTS, times(1)).fire(1);
    assertEquals(true, result);
  }
  
  @Test
  public void fireTorpedo_Single_Failure(){
    // Arrange
    when(mockpTS.fire(1)).thenReturn(false);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockpTS, times(1)).fire(1);
    assertEquals(false, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockpTS.fire(1)).thenReturn(true);
    when(mocksTS.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockpTS, times(1)).fire(1);
    verify(mocksTS, times(1)).fire(1);
    assertEquals(true, result);
  }
  
  @Test
  public void fireTorpedo_All_Failure(){
    // Arrange
    when(mockpTS.fire(1)).thenReturn(false);
    when(mocksTS.fire(1)).thenReturn(false);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockpTS, times(1)).fire(1);
    verify(mocksTS, times(1)).fire(1);
    assertEquals(false, result);
  }
  
  @Test
  public void fireTorpedo_Single_isEmpty_True(){
    // Arrange
    when(mockpTS.isEmpty()).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockpTS, times(1)).isEmpty();
    assertEquals(true, result);
  }
  
  
  @Test
  public void fireTorpedo_Single_isEmpty_False(){
    // Arrange
    when(mockpTS.isEmpty()).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockpTS, times(1)).isEmpty();
    assertEquals(false, result);
  }

}
