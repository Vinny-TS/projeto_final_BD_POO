package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Aluguel;

public class AluguelDAO {
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

    public void inserir(Aluguel aluguel) {
        String sql = "INSERT INTO Alugueis(id_cliente, id_veiculo, data_inicio, data_fim) VALUES(?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, aluguel.getIdCliente());
            pstmt.setInt(2, aluguel.getIdVeiculo());
            pstmt.setString(3, aluguel.getDataInicio());
            pstmt.setString(4, aluguel.getDataFim());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
