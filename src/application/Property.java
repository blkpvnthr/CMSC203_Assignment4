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

public class Property {

    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Constructors

    /**
     * Creates a new Property using empty strings. It also creates a default Plot.
     */
    public Property() {
        this("", "", 0.0, "");
    }

    /**
     * Creates a new Property object using given values. It also creates a default Plot.
     * @param propertyName property name
     * @param city city where the property is located
     * @param rentAmount rent amount
     * @param owner the owner's name
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    /**
     * Creates a new Property object using given values. It also creates a Plot using given values of a plot.
     * @param propertyName property name
     * @param city city where the property is located
     * @param rentAmount rent amount
     * @param owner the owner's name
     * @param x the x coordinate of the plot
     * @param y the y coordinate of the plot
     * @param width the width coordinate of the plot
     * @param depth the depth coordinate of the plot
     */
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    /**
     * Creates a new copy of the given property object.
     * @param otherProperty the Property object to make a copy of
     */
    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner,
                otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    // Getter and Setter methods

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    // toString method

    /**
     * Represents a Property object in the following String format: propertyName,city,owner,rentAmount
     * @return the string representation of a Property object
     */
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
