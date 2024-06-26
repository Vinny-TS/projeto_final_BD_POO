package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Veiculo;

public class VeiculoDAO {
    private final String url = "jdbc:mysql://127.0.0.1:3306/locadora_veiculos";
    private final String user = "root";
    private final String password = "root";

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO Veiculos(marca, modelo, ano, placa, disponivel) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, veiculo.getMarca());
            pstmt.setString(2, veiculo.getModelo());
            pstmt.setInt(3, veiculo.getAno());
            pstmt.setString(4, veiculo.getPlaca());
            pstmt.setBoolean(5, veiculo.isDisponivel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Obter veículo por ID
    // Exemplo de método para obter um veículo por ID
    public Veiculo obterPorId(int id) {
        String sql = "SELECT * FROM Veiculos WHERE id_veiculo = ?";
        Veiculo veiculo = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Aqui você cria um novo objeto Veiculo com base nos dados do ResultSet
                veiculo = new Veiculo(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("placa")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return veiculo;
    }
}
