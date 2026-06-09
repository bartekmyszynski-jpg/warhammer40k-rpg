public class Wrog extends Postac {
    private Frakcja frakcja;
    private int nagroda;

    public Wrog(String imie, int hp, int atak, int obrona, Frakcja frakcja, int nagroda) {
        super(imie, hp, hp, atak, obrona);
        this.frakcja = frakcja;
        this.nagroda = nagroda;
    }

    public Frakcja getFrakcja () {
        return frakcja;
    }
    public int getNagroda () {
        return nagroda;
    }


    @Override
    public void akcja() {
        System.out.println(getImie() + " wyprowadza atak!");
    }

    public void wyswietlStatystyki () {
        System.out.println("Imię: " + getImie());
        System.out.println("HP: " + getHp());
        System.out.println("Atak: " + getAtak());
        System.out.println("Obrona: " + getObrona());
    }
}
