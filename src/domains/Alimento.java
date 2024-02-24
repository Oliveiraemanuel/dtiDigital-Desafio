package domains;

import domains.enums.GrupoAlimento;

public class Alimento implements Comparable<Alimento>{

    private String nomeAlimento;

    private GrupoAlimento grupoAlimento;

    private Integer calorias;

    public Alimento(String nomeAlimento, GrupoAlimento grupoAlimento, Integer calorias) {
        this.nomeAlimento = nomeAlimento;
        this.grupoAlimento = grupoAlimento;
        this.calorias = calorias;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public GrupoAlimento getGrupoAlimento() {
        return grupoAlimento;
    }

    public void setGrupoAlimento(GrupoAlimento grupoAlimento) {
        this.grupoAlimento = grupoAlimento;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "nomeAlimento='" + nomeAlimento + '\'' +
                ", grupoAlimento=" + grupoAlimento +
                ", calorias=" + calorias +
                '}';
    }

    @Override
    public int compareTo(Alimento o) {
        return Integer.compare(this.calorias, o.calorias);
    }
}
