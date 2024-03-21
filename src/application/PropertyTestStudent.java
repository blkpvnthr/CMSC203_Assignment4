/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: An application that lets the user create a management company and add the properties managed by the company to its list.
 * Due: 03/18/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: ___Asmaa Abdul-Amin_______
*/

package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestStudent {

    private Property property;

    @Before
    public void setUp() {
        property = new Property(); // Initialize the property object
    }

    @After
    public void tearDown() {
        property = null;
    }

    @Test
    public void testPropertyConstructorWithNoArgs() {
        assertNotNull(property);
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals(0.0, property.getRentAmount(), 0.001);
        assertEquals("", property.getOwner());
    }

    @Test
    public void testPropertyConstructorWithArgs() {
        property = new Property("MyProperty", "MyCity", 1000.0, "John Doe");
        assertNotNull(property);
        assertEquals("MyProperty", property.getPropertyName());
        assertEquals("MyCity", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.001);
        assertEquals("John Doe", property.getOwner());
    }

    @Test
    public void testPropertyConstructorWithPlotArgs() {
        property = new Property("MyProperty", "MyCity", 1000.0, "John Doe", 1, 2, 3, 4);
        assertNotNull(property);
        assertEquals("MyProperty", property.getPropertyName());
        assertEquals("MyCity", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.001);
        assertEquals("John Doe", property.getOwner());
        assertNotNull(property.getPlot());
        assertEquals(1, property.getPlot().getX());
        assertEquals(2, property.getPlot().getY());
        assertEquals(3, property.getPlot().getWidth());
        assertEquals(4, property.getPlot().getDepth());
    }

    @Test
    public void testPropertyCopyConstructor() {
        Property originalProperty = new Property("MyProperty", "MyCity", 1000.0, "John Doe", 1, 2, 3, 4);
        property = new Property(originalProperty);
        assertNotNull(property);
        assertEquals(originalProperty.getPropertyName(), property.getPropertyName());
        assertEquals(originalProperty.getCity(), property.getCity());
        assertEquals(originalProperty.getRentAmount(), property.getRentAmount(), 0.001);
        assertEquals(originalProperty.getOwner(), property.getOwner());
        assertNotNull(property.getPlot());
        assertEquals(originalProperty.getPlot().getX(), property.getPlot().getX());
        assertEquals(originalProperty.getPlot().getY(), property.getPlot().getY());
        assertEquals(originalProperty.getPlot().getWidth(), property.getPlot().getWidth());
        assertEquals(originalProperty.getPlot().getDepth(), property.getPlot().getDepth());
    }

    @Test
    public void testPropertyToString() {
        property = new Property("MyProperty", "MyCity", 1000.0, "John Doe");
        String expectedString = "MyProperty,MyCity,John Doe,1000.0";
        assertEquals(expectedString, property.toString());
    }

    @Test
    public void testPropertyGettersAndSetters() {
        property.setPropertyName("MyProperty");
        property.setCity("MyCity");
        property.setRentAmount(1000.0);
        property.setOwner("John Doe");
        assertEquals("MyProperty", property.getPropertyName());
        assertEquals("MyCity", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.001);
        assertEquals("John Doe", property.getOwner());

        property.setPlot(new Plot(1, 2, 3, 4));  // This line may cause NullPointerException
        Plot plot = property.getPlot();
        assertNotNull("Plot is null", plot);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }
}
