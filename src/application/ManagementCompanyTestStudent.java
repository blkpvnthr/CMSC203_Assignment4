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

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany company;

    @Before
    public void setUp() {
        // Initialize a new ManagementCompany object before each test
        company = new ManagementCompany();
    }

    @After
    public void tearDown() {
        // Clean up resources after each test (if necessary)
        company = null;
    }

    @Test
    public void testConstructorAndGetters() {
        // Test constructor and getters
        company = new ManagementCompany("Test Company", "123456789", 10.0);
        assertEquals("Test Company", company.getName());
        assertEquals("123456789", company.getTaxId());
        assertEquals(10.0, company.getMgmtFeePercentage(), 0.001);
        assertEquals(0, company.getPropertiesCount());
        assertTrue(company.isMgmtFeeValid());
        assertFalse(company.isPropertiesFull());
    }

    @Test
    public void testAddProperty() {
        // Test adding a property
        company = new ManagementCompany("Test Company", "123456789", 10.0);
        Property property = new Property("Test Property", "Test City", 1000.0, "Test Owner");
        int index = company.addProperty(property);
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
        assertFalse(company.isPropertiesFull());
    }

    @Test
    public void testTotalRent() {
        ManagementCompany company = new ManagementCompany();
        company.addProperty("Test Property 1", "Test City", 1000.0, "Test Owner");
        

        assertEquals(1000.0, company.getTotalRent(), 0.01); // Specify a delta for floating point comparison
    }

    @Test
    public void testHighestRentProperty() {
        ManagementCompany company = new ManagementCompany();
        // Add properties with different rent amounts
        company.addProperty("Test Property 1", "Test City", 1000.0, "Test Owner 1");

        // Set the expected highest rent property
        Property expectedHighestRentProperty = new Property("Test Property 1", "Test City", 1000.0, "Test Owner 1");
        Property actualHighestRentProperty = company.getHighestRentProperty();
        
        // Compare the attributes of the properties
        assertEquals(expectedHighestRentProperty.getPropertyName(), actualHighestRentProperty.getPropertyName());
        assertEquals(expectedHighestRentProperty.getCity(), actualHighestRentProperty.getCity());
        assertEquals(expectedHighestRentProperty.getOwner(), actualHighestRentProperty.getOwner());
        assertEquals(expectedHighestRentProperty.getRentAmount(), actualHighestRentProperty.getRentAmount(), 0.01);
    }



    @Test
    public void testRemoveLastProperty() {
        // Create a new ManagementCompany object
        ManagementCompany company = new ManagementCompany("Test Company", "123456789", 10.0);
        // Add properties
        Property property1 = new Property("Test Property 1", "Test City", 1000.0, "Test Owner");
        Property property2 = new Property("Test Property 2", "Test City", 2000.0, "Test Owner");
        company.addProperty(property1);
        company.addProperty(property2);
        
        // Remove the last added property and check if it's removed successfully
        company.removeLastProperty();
        assertEquals(1, company.getPropertiesCount());
        assertEquals(property1, company.properties[0]);
    }

    @Test
    public void testIsPropertiesFull() {
        // Create a management company
        ManagementCompany company = new ManagementCompany();

        // Initially, the properties array should not be full
        assertFalse(company.isPropertiesFull());

        // Add properties until the array is full
        for (int i = 0; i < company.MAX_PROPERTY; i++) {
            company.addProperty("Test Property " + i, "Test City", 1000.0 * i, "Test Owner " + i);
        }

        // Now, the properties array should be full
        assertTrue(company.isPropertiesFull());
    }


    @Test
    public void testGetPropertiesCount() {
        // Create a new ManagementCompany object
        ManagementCompany company = new ManagementCompany("Test Company", "123456789", 10.0);
        // Add a property and check if the count is incremented
        assertEquals(0, company.getPropertiesCount());
        company.addProperty(new Property("Test Property", "Test City", 1000.0, "Test Owner"));
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testIsMgmtFeeValid() {
        // Create ManagementCompany objects with different management fees
        ManagementCompany company1 = new ManagementCompany("Test Company", "123456789", 10.0);
        assertTrue(company1.isMgmtFeeValid());
        
        ManagementCompany company2 = new ManagementCompany("Test Company", "123456789", -10.0);
        assertFalse(company2.isMgmtFeeValid());
    }

    @Test
    public void testToString() {
        // Create a new ManagementCompany object and add properties
        ManagementCompany company = new ManagementCompany("Test Company", "123456789", 10.0);
        company.addProperty(new Property("Test Property 1", "Test City 1", 1000.0, "Test Owner 1"));
        company.addProperty(new Property("Test Property 2", "Test City 2", 2000.0, "Test Owner 2"));
        
        // Test if the string representation is as expected
        String expected = "List of the properties for Test Company, taxID: 123456789\n" +
                          "______________________________________________________\n" +
                          "Test Property 1,Test City 1,Test Owner 1,1000.0\n" +
                          "______________________________________________________\n\n" +
                          "total management Fee: 100.00\n";
        assertEquals(expected, company.toString());
    }
    
    
}
