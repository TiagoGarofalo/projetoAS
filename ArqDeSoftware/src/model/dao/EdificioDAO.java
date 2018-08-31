package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.vo.EdificioVO;

public class EdificioDAO {

	public boolean existeRegistroPorNomeEdificio(String nomeEdificio) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM EDIFICIO " + "WHERE nomeEdificio like '" + nomeEdificio + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null,
					"Erro ao executar a query que verifica existencia de colecionador por Nome do Edifício.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int CadastrarEdificioDAO(EdificioVO edificioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO edificio (email, end, idadeEdificio, nomeEdificio, nomeSindico, nomeZelador, qtdApto, qtdBloco,"
				+ " telContato, gasIndividuall) VALUES ('" + edificioVO.getEmail() + "', '" + "', '"
				+ edificioVO.getEnd() + "', '" + edificioVO.getIdadeEdificio() + "', '" + edificioVO.getNomeEdificio()
				+ "', '" + "', '" + edificioVO.getNomeSindico() + "', '" + "', '" + edificioVO.getNomeZelador() + "', '"
				+ edificioVO.getQtdApto() + "', '" + edificioVO.getQtdBloco() + "', '" + edificioVO.getTelContato()
				+ "', '" + edificioVO.getGasIndividual() + "')";
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de cadastro.");

		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirEdificioDAO(EdificioVO edificioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM EDIFICIO " + "WHERE nomeEdificio like '" + edificioVO.getNomeEdificio() + "'";
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de exclusão do Edifício.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarEdificioDAO(EdificioVO edificioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "UPDATE EDIFICIO SET email = '" + edificioVO.getEmail() + "', end = '" + edificioVO.getEnd()
				+ "', telefone = '" + edificioVO.getIdadeEdificio() + "', nomeEdificio = '"
				+ edificioVO.getNomeEdificio() + "', nomeSindico = '" + edificioVO.getNomeSindico()
				+ "', nomeZelador = '" + edificioVO.getNomeZelador() + "', qtdApto = '" + edificioVO.getQtdApto()
				+ "', qtdBloco = '" + edificioVO.getQtdBloco() + "', telContato = '" + edificioVO.getTelContato()
				+ "', gasIndividual = '" + edificioVO.getGasIndividual() + " WHERE nomeEdificio = '"
				+ edificioVO.getNomeEdificio() + "'";

		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de atualização do Edifício.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<EdificioVO> consultarTodosEdificiosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<EdificioVO> edificiosVO = new ArrayList<EdificioVO>();
		String query = "SELECT * FROM EDIFICIO";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				EdificioVO edificioVO = new EdificioVO();
				edificioVO.setEmail(resultado.getString("email"));
				//edificioVO.setEnd(resultado.getss(2))Cla;
				edificioVO.setIdadeEdificio(Integer.parseInt(resultado.getString("idade")));
				edificioVO.setNomeEdificio(resultado.getString("nome"));
				edificioVO.setNomeSindico(resultado.getString("sindico"));
				edificioVO.setNomeZelador(resultado.getString("zelador"));
				edificioVO.setQtdApto(Integer.parseInt(resultado.getString("apto")));
				edificioVO.setQtdBloco(Integer.parseInt(resultado.getString("bloco")));
				edificioVO.setTelContato(Integer.parseInt(resultado.getString("tel")));
				edificioVO.setGasIndividual(resultado.getString("gas"));
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de consulta de Edifícios.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return edificiosVO;
	}

	public EdificioVO consultarEdificioDAO(EdificioVO edificioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		EdificioVO edificio = new EdificioVO();
		String query = "SELECT * FROM EDIFICIO WHERE nomeEdificio like '" + edificioVO.getNomeEdificio() + "'";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				edificioVO.setEmail(resultado.getString("email"));
				//edificioVO.setEnd(resultado.getss(2))Cla;
				edificioVO.setIdadeEdificio(Integer.parseInt(resultado.getString("idade")));
				edificioVO.setNomeEdificio(resultado.getString("nome"));
				edificioVO.setNomeSindico(resultado.getString("sindico"));
				edificioVO.setNomeZelador(resultado.getString("zelador"));
				edificioVO.setQtdApto(Integer.parseInt(resultado.getString("apto")));
				edificioVO.setQtdBloco(Integer.parseInt(resultado.getString("bloco")));
				edificioVO.setTelContato(Integer.parseInt(resultado.getString("tel")));
				edificioVO.setGasIndividual(resultado.getString("gas"));
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de consulta de Edifício.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return edificio;
	}
	
}