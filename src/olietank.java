import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class of oil tanks containing a volume
 * of oit and a remaining capacity.
 * @Invar   The maximum capacity must be valid.
 *          | IsValidCapacity(getCapacity())
 *
 */
public class olietank {
    private double capaciteit;
    private double inhoud;

    /**
     * @param capaciteit
     * @Post if capaciteit is negative, it's set to 0
     */
    public olietank(double capaciteit) {
        this.inhoud = 0;
        if (capaciteit > 0) {
            this.capaciteit = capaciteit;
        } else {
            this.capaciteit = 0;
        }
    }
    @Basic
    public double getInhoud() {
        return this.inhoud;
    }

    @Basic
    public double getCapaciteit() {
        return this.capaciteit;
    }

    /**
     * @param hoeveelheid
     * @Post if hoeveelheid is negative or if it's bigger than the capaciteit, nothing is changed.
     */
    public void addOil(double hoeveelheid) {
        if(hoeveelheid > 0 && hoeveelheid <= getCapaciteit()){
            this.inhoud += hoeveelheid;
        }}
    /**
     * @param hoeveelheid
     * @Post if hoeveelheid is negative or if it's bigger than the inhoud, nothing is changed.
     */
    public void subtractOil(double hoeveelheid) {
        if(hoeveelheid > 0 && hoeveelheid <= getInhoud()){
            this.inhoud -= hoeveelheid;
        }}
    public void fillCompletely() {
        this.inhoud += getCapaciteit();
        this.capaciteit = 0;
        }
    public void leakCompletely() {
        this.capaciteit += getInhoud();
        this.inhoud = 0;
    }}