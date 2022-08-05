import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GammaTest {

    private GammaFunction gammaFunction;

    @Before
    public void init(){
        gammaFunction = new GammaFunction();
    }


    @Test
    public void testBoundaryValues_1(){
        assertEquals("Infinity", gammaFunction.calculator("111.0"));
    }
    @Test
    public void testBoundaryValues_2(){
        assertEquals("Infinity", gammaFunction.calculator("0.0"));
    }

    @Test
    public void testBoundaryValues_3() {
        assertEquals("Error!", gammaFunction.calculator("invalid"));
    }

    @Test
    public void testBoundaryValues_4() {
        assertEquals("Negative input is not allowed.", gammaFunction.calculator("-1.0"));
    }

    @Test
    public void testPositiveSpecialValues_1(){
        assertTrue(Math.abs(Double.parseDouble(gammaFunction.calculator("1.0"))-1.0) < 0.001);
    }
    @Test
    public void testPositiveSpecialValues_2(){
        assertTrue(Math.abs(Double.parseDouble(gammaFunction.calculator("1.5"))-0.88622692545275801364) < 0.001);
    }
    @Test
    public void testPositiveSpecialValues_3(){
        assertTrue(Math.abs(Double.parseDouble(gammaFunction.calculator("2.0"))-1.0) < 0.001);
    }
    @Test
    public void testPositiveSpecialValues_4(){
        assertTrue(Math.abs(Double.parseDouble(gammaFunction.calculator("2.5"))-1.32934038817913702047) < 0.001);
    }
    @Test
    public void testPositiveSpecialValues_5(){
        assertTrue(Math.abs(Double.parseDouble(gammaFunction.calculator("3.0"))-2.0) < 0.001);
    }
    @Test
    public void testPositiveSpecialValues_6(){
        assertTrue( Math.abs(Double.parseDouble(gammaFunction.calculator("3.5"))-3.32335097044784255118) < 0.001);
    }
    @Test
    public void testPositiveSpecialValues_7(){
        assertTrue( Math.abs(Double.parseDouble(gammaFunction.calculator("4.0"))-6.0) < 0.001);
    }

    @Test
    public void testSpecialValues(){
        assertFalse(Math.abs(Double.parseDouble(gammaFunction.calculator("0.5"))-1.77245385090551602729) < 0.001);
        assertFalse(Math.abs(Double.parseDouble(gammaFunction.calculator("0.5"))-1.77245385090551602729) < 0.01);
        assertTrue(Math.abs(Double.parseDouble(gammaFunction.calculator("0.5"))-1.77245385090551602729) < 0.1);
    }


    @Test
    public void testGamma(){
        assertTrue(Math.abs(gammaFunction.gamma(5)-24.0)<0.001);
    }
    @Test
    public void testIntegration(){
        assertTrue(Math.abs(gammaFunction.integration(1.5,0,201)-0.88622692545275801364)<0.001);
    }
    @Test
    public void testLogarithmFunction(){
        assertTrue(Math.abs(gammaFunction.logarithmFunction(2.7182818284)-1.0)<0.001);
    }
    @Test
    public void testPowerFunction(){
        assertTrue(Math.abs(gammaFunction.power(2,10)-1024.0)<0.001);
    }


}
