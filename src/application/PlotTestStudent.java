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

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class PlotTestStudent {
	
	@Before
    public void setUp() {
        new Plot();
    }

    @After
    public void tearDown() {
    }
    
    // Test for default constructor
    @Test
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    // Test for parameterized constructor
    @Test
    public void testParameterizedConstructor() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    // Test for getX and setX methods
    @Test
    public void testGetXAndSetX() {
        Plot plot = new Plot();
        plot.setX(5);
        assertEquals(5, plot.getX());
    }

    // Test for getY and setY methods
    @Test
    public void testGetYAndSetY() {
        Plot plot = new Plot();
        plot.setY(6);
        assertEquals(6, plot.getY());
    }

    // Test for getWidth and setWidth methods
    @Test
    public void testGetWidthAndSetWidth() {
        Plot plot = new Plot();
        plot.setWidth(7);
        assertEquals(7, plot.getWidth());
    }

    // Test for getDepth and setDepth methods
    @Test
    public void testGetDepthAndSetDepth() {
        Plot plot = new Plot();
        plot.setDepth(8);
        assertEquals(8, plot.getDepth());
    }

    // Test for overlaps method
    @Test
    public void testOverlaps() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 3, 3);
        
        if (!plot1.overlaps(plot2)) {
            throw new AssertionError("Plot 1 should overlap with Plot 2");
        }
    }

    // Test for encompasses method
    @Test
    public void testEncompasses() {
        Plot plot1 = new Plot(1, 1, 5, 5);
        Plot plot2 = new Plot(2, 2, 3, 3);
        
        if (!plot1.encompasses(plot2)) {
            throw new AssertionError("Plot 1 should encompass Plot 2");
        }
    }

 // Test for toString method
    @Test
    public void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertTrue("String representation is incorrect", Objects.equals("1,2,3,4", plot.toString()));
    }
}

