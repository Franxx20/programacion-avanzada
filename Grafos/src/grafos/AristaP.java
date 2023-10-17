package grafos;

public class AristaP implements Comparable<AristaP> {
    protected Nodo desde;
    protected Nodo hasta;
    protected Double costo;

    public AristaP(int desde, int hasta, double costo) {
        this.desde = new Nodo(desde, String.valueOf(desde));
        this.hasta = new Nodo(hasta, String.valueOf(hasta));
        this.costo = costo;
    }

    public AristaP(int desde, double costo) {
        this(desde, desde, costo);
    }

    public int getDesde() {
        return desde.getId();
    }

    public int getHasta() {
        return hasta.getId();
    }

    public String getOrigenNombre() {
        return desde.getNombre();
    }

    public String getDestinoNombre() {
        return desde.getNombre();
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setNombres(String origen, String destino) {
        this.desde.setNombre(origen);
        this.hasta.setNombre(destino);
    }

    @Override
    public String toString() {
        return desde + " " + hasta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AristaP aristaP = (AristaP) o;

        if (Double.compare(costo, aristaP.costo) != 0) return false;
        if (!desde.equals(aristaP.desde)) return false;
        return hasta.equals(aristaP.hasta);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = desde.hashCode();
        result = 31 * result + hasta.hashCode();
        temp = Double.doubleToLongBits(costo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(AristaP aristaP) {
        return Double.compare(this.costo, aristaP.costo);
    }
}


