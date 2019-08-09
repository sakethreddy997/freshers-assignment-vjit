package rubycon.saketh;

import java.util.Scanner;

public class Construct {


    private String name;
    private int quantity;
    private int capacity;
    private double weight;

    Construct(String name, int qty, int cap, double wt) {
        this.setName(name);
        Scanner x = new java.util.Scanner(System.in);
        System.out.println("Enter number of " + name);
        this.setQuantity(x.nextInt());
        this.setCapacity(cap);
        this.setWeight(wt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}