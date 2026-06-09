public abstract class Postac {
    private String imie;
    private int hp;
    private int maxHp;
    private int atak;
    private int obrona;

    public Postac(String imie, int hp, int maxHp, int atak, int obrona) {
        this.imie = imie;
        this.hp = hp;
        this.maxHp = hp;
        this.atak = atak;
        this.obrona = obrona;
    }

    public String getImie () {
        return imie;
    }
    public int getHp () {
        return hp;
    }
    public int getMaxHp () {
        return maxHp;
    }
    public int getAtak () {
        return atak;
    }
    public int getObrona () {
        return obrona;
    }

    protected void setHp (int hp) {
        this.hp = hp;
    }
    protected void setObrona (int obrona) { this.obrona = obrona; }

    public boolean czyZyje () {
        return hp > 0;
    }

    public void otrzymajObrazenia (int obrazenia) {
        hp = hp - obrazenia;
        if (hp<0) {
            hp = 0;
        }
    }

    public abstract void akcja();
}
