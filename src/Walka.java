import java.util.Scanner;

public class Walka {
    public static void rozpocznijWalke(Bohater bohater, Wrog wrog, Scanner scanner) {
        System.out.println("====== WALKA ROZPOCZĘTA ======");
        bohater.wyswietlStatystyki();
        System.out.println(" VS ");
        wrog.wyswietlStatystyki();

        while (bohater.czyZyje() && wrog.czyZyje()) {
            System.out.println("\nCo robisz, " + bohater.getImie()+ "?");
            System.out.println("1. Atak");
            System.out.println("2. Mocny atak (2x obrażenia, -10 obrony)");
            System.out.println("3. Ulecz się (30 HP)");
            System.out.println("4. Ucieczka");
            System.out.println("> ");
            String wybor = scanner.nextLine();
            int oryginalnaObrona = bohater.getObrona();
            int obrazeniaBohatera = 0;
            if (wybor.equals("1")) {
                obrazeniaBohatera = bohater.getCalkowityAtak() - wrog.getObrona();
                if (obrazeniaBohatera < 0) {
                    obrazeniaBohatera = 1;
                }
            } else if (wybor.equals("2")) {
                if (bohater.getObrona() >= 10) {
                    obrazeniaBohatera = (bohater.getCalkowityAtak() - wrog.getObrona()) * 2;
                    if (obrazeniaBohatera < 0) {
                        obrazeniaBohatera = 1;
                    }
                    bohater.setObrona(oryginalnaObrona - 10);
                    System.out.println("Mocny atak! Twoja obrona spada do: " + bohater.getObrona());
                } else {
                    System.out.println("Brak wystarczających punktów obrony");
                    continue;
                }
            } else if (wybor.equals("3")) {
                if (bohater.getStimmPack() > 0) {
                    bohater.lecz(30);
                    System.out.println("Używasz Stimm Pack!");
                } else {
                    System.out.println("Brak Stimm Packów! Wybierz inną akcję!");
                    continue;
                }
            } else if (wybor.equals("4")) {
                System.out.println(bohater.getImie() + " ucieka z pola walki!");
                return;
            } else {
                System.out.println("Nieznana opcja - tracisz turę!");
            }


            if (obrazeniaBohatera > 0) {
                wrog.otrzymajObrazenia(obrazeniaBohatera);
                System.out.println(bohater.getImie() + " zadaje: " + obrazeniaBohatera + ", " + wrog.getImie() + ": pozostałe życie -> " + wrog.getHp());
            }
            if (!wrog.czyZyje()) {
                break;
            }

            int obrazeniaWroga = wrog.getAtak() - bohater.getObrona();
            if (obrazeniaWroga < 0) {
                obrazeniaWroga = 1;
            }

            bohater.otrzymajObrazenia(obrazeniaWroga);
            System.out.println(wrog.getImie() + " zadaje: " + obrazeniaWroga + ", " + bohater.getImie() + ": pozostałe życie -> " + bohater.getHp());

            bohater.setObrona(oryginalnaObrona);

            if (!bohater.czyZyje()) {
                break;
            }
        }

        if (bohater.czyZyje()) {
            System.out.println("Wygrałeś!");
            bohater.dodajExp(wrog.getNagroda());
        } else {
            System.out.println("Nie żyjesz...");
        }
    }
}
