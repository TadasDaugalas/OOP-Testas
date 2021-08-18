package Data;

import java.io.Serial;
import java.io.Serializable;

public class Asmenys implements Serializable {
    private String vardas;
    private String pavarde;
    private String asmensKodas;

    @Override
    public String toString() {
        return "Asmenys{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", asmensKodas='" + asmensKodas + '\'' +
                '}';
    }

    public Asmenys() {
    }

    public Asmenys(String vardas, String pavarde, String asmensKodas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmensKodas = asmensKodas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(String asmensKodas) {
        this.asmensKodas = asmensKodas;
    }
}
