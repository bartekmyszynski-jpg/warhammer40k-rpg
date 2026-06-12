import java.util.Scanner;

public class Sklep {
    public static void wejdzDoSklepu (Bohater bohater, Scanner scanner) {

        System.out.println("=== WITAJ W SKLEPIE ===");
        System.out.println("Wybierz przedmiot, który chcesz kupić: ");
        System.out.println("1. Boltgun MK2 -> +15 ataku - 30 złota");
        System.out.println("2. Power Sword -> +25 ataku - 50 złota");
        System.out.println("3. Reinforced Armour -> +10 obrony - 40 złota");
        System.out.println("4. Stimm Pack -> +1 Stimmpack - 20 złota");
        System.out.println("5. Wyjdź ze sklepu");
        System.out.println("> ");
        String wybor = scanner.nextLine();

        if (wybor.equals("1")) {
            if (bohater.getZloto() >= 30) {
                bohater.dodajBron("Boltgun MK2", 15);
                bohater.odejmijZloto(30);
                System.out.println("Dodano do ekwipunku Boltgun MK2 +15 do ataku");
            } else {
                System.out.println("Za mało złota!");
            }
        } else if (wybor.equals("2")) {
            if (bohater.getZloto() >= 50) {
                bohater.dodajBron("Power Sword", 25);
                bohater.odejmijZloto(50);
                System.out.println("Dodano do ekwipunku Power Sword +25 do ataku");
            } else {
                System.out.println("Za mało złota!");
            }
        } else if (wybor.equals("3")) {
            if (bohater.getZloto() >= 40) {
                bohater.dodajZbroje("Reinforced Armour", 10);
                bohater.odejmijZloto(40);
                System.out.println("Dodano do ekwipunku Reinforced Armour +10 do obrony");
            } else {
                System.out.println("Za mało złota!");
            }
        } else if (wybor.equals("4")) {
            if (bohater.getZloto() >= 20) {
                bohater.dodajStimmPack();
                bohater.odejmijZloto(20);
                System.out.println("Dodano do ekwipunku Stimm pack");
            } else {
                System.out.println("Za mało złota!");
            }
        } else if (wybor.equals("5")) {
            return;
        }
    }
}