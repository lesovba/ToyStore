package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeQueue;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeQueue = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy(int toyId) {
        toys.removeIf(toy -> toy.getId() == toyId);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " не найдена.");
    }

    public void playGame() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomNumber = new Random().nextDouble() * totalWeight;

        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                System.out.println("Выиграна игрушка: " + toy.getName());
                prizeQueue.add(toy);
                toys.remove(toy);
                saveToFile();
                return;
            }
            randomNumber -= toy.getWeight();
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_queue.txt", true))) {
            Toy prizeToy = prizeQueue.get(prizeQueue.size() - 1);
            writer.write(prizeToy.getId() + "," + prizeToy.getName() + "," + prizeToy.getQuantity() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

