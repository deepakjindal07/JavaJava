// Computer class representing a computer with configurations
package basics_large;

class Computer {
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor
    public Computer(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // Getters and setters
    // ...

    @Override
    public String toString() {
        return "RAM=" + ram + ", HDD=" + hdd + ", CPU=" + cpu;
    }
}

// Abstract Factory interface
interface ComputerAbstractFactory {
    Computer createComputer();
}

// Concrete factory for creating PC
class PCFactory1 implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory1(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new Computer(ram, hdd, cpu);
    }
}

// Concrete factory for creating Server
class ServerFactory1 implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory1(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new Computer(ram, hdd, cpu);
    }
}

// Main class
public class TestDesignPatterns {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        // Creating a PC and Server using the Abstract Factory pattern
        ComputerAbstractFactory pcFactory = new PCFactory1("2 GB", "500 GB", "2.4 GHz");
        ComputerAbstractFactory serverFactory = new ServerFactory1("16 GB", "1 TB", "2.9 GHz");

        Computer pc = pcFactory.createComputer();
        Computer server = serverFactory.createComputer();

        // Displaying the configurations of the created PC and Server
        System.out.println("AbstractFactory PC Config: " + pc);
        System.out.println("AbstractFactory Server Config: " + server);
    }
}
