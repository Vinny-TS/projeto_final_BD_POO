package models;

public class Aluguel {
    private int id;
    private int idCliente;
    private int idVeiculo;
    private String dataInicio;
    private String dataFim;

    public Aluguel(int idCliente, int idVeiculo, String dataInicio, String dataFim) {
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
