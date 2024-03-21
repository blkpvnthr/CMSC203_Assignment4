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

public class ManagementCompany {
    private String name; // Name of the management company
    private String taxId; // Tax ID of the management company
    private double mgmtFeePercentage; // Management fee percentage
    final int MAX_PROPERTY = 5; // Maximum number of properties
    private static final int MGMT_WIDTH = 10; // Management company plot width
    private static final int MGMT_DEPTH = 10; // Management company plot depth
    protected Property[] properties; // Array to store properties
    private int numberOfProperties; // Number of properties currently managed
    private Plot plot; // Plot of the management company

    // Constructors
    public ManagementCompany() {
        this("", "", 0.0); // Calls parameterized constructor with default values
    }

    public ManagementCompany(String name, String taxId, double mgmtFeePercentage) {
        this.name = name;
        this.taxId = taxId;
        this.mgmtFeePercentage = mgmtFeePercentage;
        this.properties = new Property[MAX_PROPERTY]; // Initializes properties array
        this.numberOfProperties = 0; // Initializes number of properties
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH); // Initializes management company plot
    }

    // Getter and Setter methods
    public Plot getPlot() {
    	return plot;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public double getMgmtFeePercentage() {
        return mgmtFeePercentage;
    }

    public void setMgmtFeePercentage(double mgmtFeePercentage) {
        this.mgmtFeePercentage = mgmtFeePercentage;
    }

    // Other methods
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner)); // Calls overloaded addProperty method
    }

    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1; // Array is full
        }
        if (property == null) {
            return -2; // Property object is null
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; // Property plot is not encompassed by management company plot
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Property plot overlaps with another property's plot
            }
        }
        properties[numberOfProperties++] = property; // Adds property to array and increments count
        return numberOfProperties - 1; // Index where the property was added
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount(); // Calculates total rent amount
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null; // No properties exist
        }
        Property highestRentProperty = properties[0]; // Initialize with first property
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i]; // Updates highest rent property if found
            }
        }
        return highestRentProperty; // Returns property with highest rent
    }

    public void removeLastProperty() {
        if (properties.length > 0 && properties[properties.length - 1] != null) {
            properties[properties.length - 1] = null; // Removes last property
            numberOfProperties--; // Decrease the count of properties
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY; // Checks if properties array is full
    }

    public int getPropertiesCount() {
        return numberOfProperties; // Returns number of properties
    }

    public boolean isMgmtFeeValid() {
        return mgmtFeePercentage >= 0 && mgmtFeePercentage <= 100; // Checks if management fee is valid
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxId).append("\n");
        sb.append("________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                sb.append(properties[i].toString()).append("\n"); // Appends property details
            }
        }
        sb.append("________________________________________________\n\n");
        
        // Calculate total management fee
        double totalFee = getTotalRent() * (mgmtFeePercentage / 100);
        sb.append("total management Fee: ").append(String.format("%.2f", totalFee)).append("\n"); // Appends total fee
        return sb.toString(); // Returns string representation of management company
    }
}
