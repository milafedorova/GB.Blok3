import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(Triangle.class);
    private static final Triangle triangle = new Triangle();

    @Test
    @DisplayName("Test triangle area is successfully")
    public void testTriangleAreaSuccessBoolean(){
        Assertions.assertTrue(triangle.areaTriangle(3,4,5)==6);
        logger.debug("Test 1");
    }

    @Test
    @DisplayName("Test triangle area is successfully (equal)")
    public void  testTriangleAreaSuccessEqual(){
        Assertions.assertEquals(5.0, triangle.areaTriangle(3,4,5));
    }

}
