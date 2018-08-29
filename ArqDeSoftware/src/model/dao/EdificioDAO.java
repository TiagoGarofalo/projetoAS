package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.EdificioVO;

public class EdificioDAO {

	public int CadastrarEdificioDAO(EdificioVO edificioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO edificio (nome, " + "cpf, telefone, email) VALUES ('" + edificioVO.getEnd() + "', '"
				+ edificioVO.getQtdApto() + "', '" + edificioVO.getQtdBloco() + "', '" + edificioVO.getEmail() + "')";
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;

	}
}