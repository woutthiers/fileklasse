
public class klok {
    private int seconden;
    private int minuten;
    private int uren;

    private int[] tijd;

    public klok(int seconden, int minuten, int uren) {
        setMinuten(minuten);
        setUren(uren);
        setSeconden(seconden);
    }
    public klok() {
        new klok(0,0,0);
    }

    public int getSeconden() {
        return seconden;
    }

    public int getMinuten() {
        return minuten;
    }

    public int getUren() {
        return uren;
    }

    /**
     *
     * @param seconden
     * @Post If the given seconds are not 0 up to 59 than the modulo 60 will be used.
     */
    public void setSeconden(int seconden) {
        this.seconden = seconden%60;
    }

    /**
     *
     * @param minuten,
     * @Post If the given minuten are not 0 up to 59 than the modulo 60 will be used.
     */
    public void setMinuten(int minuten) {
        this.minuten = minuten%60;
    }
    /**
     *
     * @param uren,
     * @Post If the given uren are not 0 up to 23 than the modulo 23 will be used.
     */
    public void setUren(int uren) {
        this.uren = uren%24;
    }

    public void addSecond(){
        setSeconden(getSeconden() + 1);
        if (getSeconden() == 0){
            setMinuten(getMinuten() + 1);
            if (getMinuten() == 0){
                setUren(getUren() + 1);
            }
        }
    }
    public void showKlok(){
        tijd[0] = getUren();
        tijd[1] = getMinuten();
        tijd[2] = getSeconden();

        System.out.println(tijd);
    }


}
