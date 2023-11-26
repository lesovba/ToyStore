package org.example;

// ToyShopMenu.java
import java.util.Scanner;

public class ToyShopMenu {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Удалить игрушку");
            System.out.println("3. Изменить частоту выпадения игрушки");
            System.out.println("4. Провести розыгрыш");
            System.out.println("5. Выйти");

            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите ID новой игрушки: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите название новой игрушки: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите количество новой игрушки: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Введите частоту выпадения новой игрушки (%): ");
                    double weight = scanner.nextDouble();
                    toyStore.addToy(new Toy(id, name, quantity, weight));
                    break;
                case 2:
                    System.out.print("Введите ID игрушки для удаления: ");
                    int deleteId = scanner.nextInt();
                    toyStore.removeToy(deleteId);
                    break;
                case 3:
                    System.out.print("Введите ID игрушки для изменения частоты выпадения: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Введите новую частоту выпадения игрушки (%): ");
                    double newWeight = scanner.nextDouble();
                    toyStore.updateWeight(updateId, newWeight);
                    break;
                case 4:
                    toyStore.playGame();
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

