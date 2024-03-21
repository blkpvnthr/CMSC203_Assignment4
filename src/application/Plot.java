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

public class Plot {
    // Attributes
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
        this(0, 0, 1, 1); // Default values
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    // Setter methods
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to check if the given plot overlaps with the current plot
    public boolean overlaps(Plot plot) {
        return !(x + width <= plot.x || plot.x + plot.width <= x ||
                 y + depth <= plot.y || plot.y + plot.depth <= y);
    }

    // Method to check if the given plot is encompassed by the current plot
    public boolean encompasses(Plot plot) {
        return (x <= plot.x && y <= plot.y &&
                x + width >= plot.x + plot.width &&
                y + depth >= plot.y + plot.depth);
    }

    // toString method
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}

