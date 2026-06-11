public class LootSystem {
    public static void losujLoot(Bohater bohater) {
        double szansa = Math.random();

        if (szansa < 0.1) {
            bohater.dodajBron("Młot Gromu", 40);
        } else if (szansa < 0.3) {
            bohater.dodajBron("Miecz łańcuchowy", 20);
        } else if (szansa < 0.6) {
            bohater.dodajBron("Boltgun", 10);
        } else {
            System.out.println("Nie znaleziono łupu");
        }
    }
}
