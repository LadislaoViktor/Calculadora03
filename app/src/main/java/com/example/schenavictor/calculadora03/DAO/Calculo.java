package com.example.schenavictor.calculadora03.DAO;

/**
 * Created by 2015102617 on 08/03/2017.
 */
public class Calculo {

    private long id;
    private double valolorum;
    private double valordois;
    private String operador;
    private double resposta;


    public Calculo(long id, double valolorum, double valordois, String operador, double resposta) {
        this.id = id;
        this.valolorum = valolorum;
        this.valordois = valordois;
        this.operador = operador;
        this.resposta = resposta;
    }

    public Calculo(double valolorum, double valordois, String operador, double resposta) {
        this.valolorum = valolorum;
        this.valordois = valordois;
        this.operador = operador;
        this.resposta = resposta;
    }

    public Calculo() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValolorum() {
        return valolorum;
    }

    public void setValolorum(double valolorum) {
        this.valolorum = valolorum;
    }

    public double getValordois() {
        return valordois;
    }

    public void setValordois(double valordois) {
        this.valordois = valordois;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getResposta() {
        return resposta;
    }

    public void setResposta(double resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Calculo{" +
                "id=" + id +
                ", valolorum=" + valolorum +
                ", valordois=" + valordois +
                ", operador='" + operador + '\'' +
                ", resposta=" + resposta +
                '}';
    }
}
