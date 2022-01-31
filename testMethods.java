import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class testMethods {

    private ACar volvo;
    private ACar saab;
    private ACar scania;
    private ACar transporter;

    @Before
    public void init() {
        volvo = new Volvo240();
        saab = new Saab95();
        scania = new Scania();
        transporter = new Transporter();
    }


    @Test
    public void testYStartPosition(){
        double y = volvo.position.y;
        assertTrue(y==0);
    }

    @Test
    public void testXStartPosition(){
        double x = volvo.position.x;
        assertTrue(x==0);
    }

    @Test
    public void testTurnLeft(){
        volvo.turnLeft();
        assertTrue(volvo.direction==ACar.Direction.LEFT);
    }

    @Test
    public void testTurnRight(){
        volvo.turnRight();
        assertTrue(volvo.direction==ACar.Direction.RIGHT);
    }

    @Test
    public void testHasMoved(){
        volvo.move();
        assertTrue(volvo.position.y > 0);
    }

    @Test
    public void testSpeedIncreasedVolvo(){
        volvo.currentSpeed = 0;
        volvo.gas(1);
        assertTrue(volvo.currentSpeed > 0);
    }

    @Test
    public void testSpeedDecreasedVolvo(){
        volvo.gas(1);
        double startSpeed = volvo.currentSpeed;
        volvo.brake(0.5);
        assertTrue(startSpeed > volvo.currentSpeed);
    }

    @Test
    public void testSpeedIncreasedSaab(){
        saab.currentSpeed = 0;
        saab.gas(1);
        assertTrue(saab.currentSpeed > 0);
    }

    @Test
    public void testSpeedDecreasedSaab(){
        saab.gas(1);
        double startSpeed = saab.currentSpeed;
        saab.brake(0.5);
        assertTrue(startSpeed > saab.currentSpeed);
    }

    @Test
    public void testIncreaseAngle(){
        //double initAngle = scania.getPlatformAngle();
    }

    @Test
    public void testToggleRamp() {
        //transporter.rampMode
    }
}
