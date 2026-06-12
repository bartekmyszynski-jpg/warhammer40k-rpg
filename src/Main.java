import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("   WARHAMMER 40K - LAST STAND ON TARTARUS   ");
        System.out.println("============================================");
        System.out.println("Podaj imię swojego Space Marines: ");
        System.out.print("> ");
        String imie = scanner.nextLine();
        Bohater bohater = new Bohater(imie, 100, 20, 10);
        ArrayList<Wrog> wrogowie = new ArrayList<>();
        wrogowie.add(new Wrog("Marines Chaosu", 50, 25, 8, Frakcja.CHAOS, 50));
        wrogowie.add(new Wrog("Demon Khorne'a", 120, 35, 10, Frakcja.CHAOS, 80));
        wrogowie.add(new Wrog("Lord Chaosu", 200, 45, 15, Frakcja.CHAOS, 150));

        for (Wrog wrog : wrogowie) {
            if(bohater.czyZyje()) {
                Walka.rozpocznijWalke(bohater, wrog, scanner);
                if (bohater.czyZyje()) {
                        bohater.lecz(20);
                        LootSystem.losujLoot(bohater);
                        Sklep.wejdzDoSklepu(bohater, scanner);
                }
                System.out.println("Statystyki po walce: ");
                bohater.wyswietlStatystyki();
                System.out.println("=======================");
            }
        }
    }
}
