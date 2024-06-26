package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Manutencao;

public class ManutencaoDAO {
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

    // Create
    public void inserir(Manutencao manutencao) {
        String sql = "INSERT INTO Manutencao(id_veiculo, data_manutencao, descricao) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, manutencao.getIdVeiculo());
            pstmt.setString(2, manutencao.getDataManutencao());
            pstmt.setString(3, manutencao.getDescricao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
