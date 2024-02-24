package domains;

import java.util.ArrayList;
import java.util.List;

public class Consulta {

    public Consulta(String data, String horario, Double peso, Double gorduraCorporal, String sensacaoFisica) {
        this.data = data;
        this.horario = horario;
        this.peso = peso;
        this.gorduraCorporal = gorduraCorporal;
        this.sensacaoFisica = sensacaoFisica;
    }

    private String data;
    private String horario;
    private Double peso;
    private Double gorduraCorporal;
    private String sensacaoFisica;
    private List<String> restricoesAlimentares;

    public static List<Consulta> consultas = new ArrayList<>();

    public Consulta() {

    }


    public void addConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getGorduraCorporal() {
        return gorduraCorporal;
    }

    public void setGorduraCorporal(Double gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public String getSensacaoFisica() {
        return sensacaoFisica;
    }

    public void setSensacaoFisica(String sensacaoFisica) {
        this.sensacaoFisica = sensacaoFisica;
    }

    public List<String> getRestricoesAlimentares() {
        return restricoesAlimentares;
    }

    public void setRestricoesAlimentares(List<String> restricoesAlimentares) {
        this.restricoesAlimentares = restricoesAlimentares;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", peso=" + peso +
                ", gorduraCorporal=" + gorduraCorporal +
                ", sensacaoFisica='" + sensacaoFisica + '\'' +
                ", restricoesAlimentares=" + restricoesAlimentares +
                '}';
    }
}
