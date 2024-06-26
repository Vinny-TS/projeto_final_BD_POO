package models;

public class Manutencao {
    private int id;
    private int idVeiculo;
    private String dataManutencao;
    private String descricao;

    public Manutencao(int idVeiculo, String dataManutencao, String descricao) {
        this.idVeiculo = idVeiculo;
        this.dataManutencao = dataManutencao;
        this.descricao = descricao;
    }

    public Manutencao(int id, int idVeiculo, String dataManutencao, String descricao) {
        this.id = id;
        this.idVeiculo = idVeiculo;
        this.dataManutencao = dataManutencao;
        this.descricao = descricao;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(String dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
