
class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }
    @Override
    public String toString() {
        return """
               Computer Configuration:
               CPU: """ + CPU + "\n" +
               "RAM: " + RAM + "\n" +
               "Storage: " + storage + "\n" +
               "Graphics Card: " + graphicsCard + "\n" +
               "Operating System: " + operatingSystem;
    }

    public static class Builder {
        private final String CPU;
        private final String RAM;

        private String storage = "Not specified";
        private String graphicsCard = "Not specified";
        private String operatingSystem = "Not specified";

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String os) {
            this.operatingSystem = os;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
public class BuilderPattern{
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("2TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11")
                .build();
        System.out.println("=== Basic Computer ===");
        System.out.println(basicComputer);

        System.out.println("\n=== Gaming Computer ===");
        System.out.println(gamingComputer);
    }
}
