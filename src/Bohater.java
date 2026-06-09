import java.util.ArrayList;
import java.util.HashMap;

public class Bohater extends Postac implements Leczacy {
    private int lvl;
    private int exp;
    private int zloto;
    private int honor;
    private HashMap<String, Integer> ekwipunek;
    private ArrayList<String> zdolnosci;
    private int stimmPack;

    public Bohater (String imie, int hp, int atak, int obrona) {
        super(imie, hp, hp, atak, obrona);
        this.lvl = 1;
        this.exp = 0;
        this.zloto = 0;
        this.honor = 50;
        this.ekwipunek = new HashMap<>();
        this.zdolnosci = new ArrayList<>();
        this.stimmPack = 4;
    }

    public int getLvl () {
        return lvl;
    }
    public int getExp () {
        return exp;
    }
    public int getZloto () { return zloto; }
    public int getHonor () { return honor; }
    public int getStimmPack () { return stimmPack ;}

    public void dodajExp (int zdobyty) {
        exp = exp + zdobyty;
        System.out.println(getImie() + " zdobył " + zdobyty + " doświadczenia ");
        if (exp >= 100) {
            lvl++;
            exp = 0;
            System.out.println(getImie() + " awansuje na kolejny lvl: " + getLvl());
        }
    }

    public void dodajZloto (int ileZlota) {
        if (ileZlota < 0) {
            throw new IllegalArgumentException("Wartość złota nie może być dodana jako ujemna. Podano: " + ileZlota);
        }
        zloto = zloto + ileZlota;
    }

    public void dodajHonor (int ileHonoru) {
        if (ileHonoru < 0) {
            throw new IllegalArgumentException("Wartość honoru nie może być dodana jako ujemna. Podano: " + ileHonoru);
        }
        honor = honor + ileHonoru;
    }

    @Override
    public void akcja () {
        System.out.println(getImie() + " wyporwadza atak.");
    }

    public void wyswietlStatystyki () {
        System.out.println("Imię: " + getImie());
        System.out.println("HP: " + getHp());
        System.out.println("Atak: " + getAtak());
        System.out.println("Obrona: " + getObrona());
        System.out.println("Złoto: " + getZloto());
        System.out.println("Honor: " + getHonor());
    }

    public void dodajBron (String nazwa, int wartoscAtaku) {
        ekwipunek.put(nazwa, wartoscAtaku);
        System.out.println(getImie() + " znalazł " + nazwa + " + " + wartoscAtaku + " do wartości ataku");
    }


    public void wyswietlEkwipunek() {
        System.out.println("=== Ekwipunek " + getImie() + " ===");
        if (ekwipunek.isEmpty()) {
            System.out.println("Brak przedmiotów");
            return;
        }
        for (String przedmiot : ekwipunek.keySet()) {
            System.out.println(przedmiot + " + do ataku: " + ekwipunek.get(przedmiot));
        }
    }

    public void lecz (int ileLeczenia) {
        if (ileLeczenia < 0) {
            throw new IllegalArgumentException("Leczenie nie może być ujemne. Podano: " + ileLeczenia);
        }
        int noweHp = getHp() + ileLeczenia;
        if (noweHp > getMaxHp()) {
            noweHp = getMaxHp();
        }
        if (stimmPack > 0) {
            setHp(noweHp);
            stimmPack--;
            System.out.println(getImie() + " jest leczony o: " + ileLeczenia + ". Nowa wartość HP to: " + noweHp + " | Stimm Packi: " + stimmPack);
        } else {
            System.out.println("Brak apteczki");
        }
    }

    public int getCalkowityAtak () {
        int bonus = 0;
        for (String przedmiot : ekwipunek.keySet()) {
            bonus = bonus + ekwipunek.get(przedmiot);
        }
        return getAtak() + bonus;
    }

    public void dodajZdolnosc (String nazwa) {
        zdolnosci.add(nazwa);
        System.out.println("Zdobył zdolność: " + nazwa);
    }

}
