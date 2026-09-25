package week7.class_problems;

abstract class Toy {
    private final String toyId;
    private static int counter = 1000;

    public Toy() {
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public abstract String makeSound();

    String getToyId() {
        return toyId;
    }
}

class ToyCar extends Toy {
    private String name;

    public ToyCar(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    private String name;

    public ToyRobot(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class ToyProblem1 {
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}