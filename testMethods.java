import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class testMethods {

    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;
    private Transporter transporter;

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
    public void testIncreaseAngleScania(){
        double initAngle = scania.getPlatformAngle();
        scania.raiseAngle(10);
        assertTrue(initAngle < scania.getPlatformAngle());
    }

    @Test
    public void testGasNotIncreaseSpeedScania(){
        scania.platformAngle = 10;
        scania.gas(1);
        assertTrue(scania.currentSpeed == 0);
    }

    @Test
    public void testToggleRamp() {
        ACar.Direction initRamp = transporter.direction;
        transporter.toggleRamp();
        assertNotSame(initRamp, transporter.rampMode);
    }

    @Test
    public void testCarLoadedTransporter(){
        transporter.rampMode = Transporter.Direction.DOWN;
        transporter.loadCar(volvo);
        assertTrue(transporter.cars.size() > 0);
    }

    @Test
    public void testCarUnloadedTransporter(){
        transporter.rampMode = Transporter.Direction.DOWN;
        transporter.loadCar(volvo);
        transporter.unloadCar();
        assertTrue(transporter.cars.size() == 0);
    }

    @Test
    public void testCarPositionUpdateOnMove(){
        transporter.rampMode = Transporter.Direction.DOWN;
        transporter.loadCar(volvo);
        transporter.rampMode = Transporter.Direction.UP;
        transporter.move();
        assertTrue(transporter.cars.get(0).position.y > 0);
    }
}
