package Model;

public class Chofer {
    private int nLicencia;
    private String nombre;
    private String especie;
    private int masivo;

    public Chofer(int nLicencia, String nombre, String especie, int masivo) {
        this.nLicencia = nLicencia;
        this.nombre = nombre;
        this.especie = especie;
        this.masivo = masivo;

    }

    public int getnLicencia() {
        return nLicencia;
    }

    public void setnLicencia(int nLicencia) {
        this.nLicencia = nLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getMasivo() {
        return masivo;
    }

    public void setMasivo(int masivo) {
        this.masivo = masivo;
    }

    @Override
    public String toString() {
        return "Chofer{" +
                "nLicencia=" + nLicencia +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", masivo=" + masivo +
                '}';
    }
}
