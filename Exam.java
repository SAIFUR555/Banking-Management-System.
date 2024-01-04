class Exam {
    double marks;
    int min;

    // Constructor for Exam class with no arguments
    public Exam() {
        System.out.println("E-E"); // Print "E-E" when an Exam object is created with no arguments.
    }

    // Constructor for Exam class with two arguments
    public Exam(int min, double marks) {
        this(); // Calls the no-argument constructor first
        this.min = min; // Set the min value
        this.marks = marks; // Set the marks value
        System.out.println("P-E"); // Print "P-E" after setting values.
    }

    // Method to display information about an exam
    public void show(String s) {
        System.out.println(s + "Exam"); // Display a custom message with "Exam"
        System.out.println("Marks: " + marks + " Min: " + min); // Display marks and min values
    }
}

class Midterm extends Exam {
    private int day, slot;

    // Setter method for day
    public void setDay(int day) {
        this.day = day;
    }

    // Setter method for slot
    public void setSlot(int slot) {
        this.slot = slot;
    }

    // Getter method for day
    public int getDay() {
        return day;
    }

    // Getter method for slot
    public int getSlot() {
        return slot;
    }

    // Constructor for Midterm class with no arguments
    public Midterm() {
        super(120, 100.0); // Call the Exam class constructor with default values
    }

    // Constructor for Midterm class with four arguments
    public Midterm(int day, int slot, int min, double marks) {
        this.day = day; // Set the day value
        this.slot = slot; // Set the slot value
        super.min = min; // Set the min value by accessing it from the superclass
        super.marks = marks; // Set the marks value by accessing it from the superclass
        System.out.println("P-M"); // Print "P-M" after setting values.
    }

    // Method to display information about a midterm exam
    public void show(String s) {
        super.show(s); // Call the show method from the superclass (Exam)
        System.out.println("Day: " + slot + " Slot: " + day); // Display day and slot values
    }
}

public class Output {
    public static void main(String[] args) {
        // Create a Midterm object setA with custom values
        Midterm setA = new Midterm(5, 3, 120, 100.0);
        
        // Create a Midterm object setB with no arguments (default values)
        Midterm setB = new Midterm();
        
        // Call the show method for setA with a custom message
        setA.show("Mid");
        
        // Call the show method for setB with a custom message
        setB.show("No");
    }
}
