package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.vo.EdificioVO;
import model.vo.EnderecoVO;

public class EnderecoDAO {

	public boolean existeRegistroPorIdEnd(int idEnd) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM ENDERECO " + "WHERE idEnd like '" + idEnd + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query que verifica existencia de endereço por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int CadastrarEndDAO(EnderecoVO enderecoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO edificio (email, end, idadeEdificio, nomeEdificio, nomeSindico, nomeZelador, qtdApto, qtdBloco,"
				+ " telContato, gasIndividuall) VALUES ('" + enderecoVO.getIdEnd() + "', '"
				+ enderecoVO.getRua() + "', '" + enderecoVO.getNum() + "', '" + enderecoVO.getBairro() + "', '" 
				+ enderecoVO.getMunicipio() + "', '" + enderecoVO.getCep() + "')";
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

	public int excluirEnderecoDAO(EnderecoVO enderecoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM ENDERECO" + " WHERE idEnd = " + enderecoVO.getIdEnd();
		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de exclusão.");
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
				edificioVO.setEmail(resultado.getString(1));
				edificioVO.setEnd(resultado.getString(2));
				edificioVO.setIdadeEdificio(Integer.parseInt(resultado.getString(7)));
				edificioVO.setNomeEdificio(resultado.getString(4));
				edificioVO.setNomeSindico(resultado.getString(5));
				edificioVO.setNomeZelador(resultado.getString(6));
				edificioVO.setQtdApto(Integer.parseInt(resultado.getString(7)));
				edificioVO.setQtdBloco(Integer.parseInt(resultado.getString(8)));
				edificioVO.setTelContato(Integer.parseInt(resultado.getString(9)));
				edificioVO.setGasIndividual(resultado.getString(10));
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
				edificio.setEmail(resultado.getString(1));
				edificio.setEnd(resultado.getString(2));
				edificio.setIdadeEdificio(Integer.parseInt(resultado.getString(7)));
				edificio.setNomeEdificio(resultado.getString(4));
				edificio.setNomeSindico(resultado.getString(5));
				edificio.setNomeZelador(resultado.getString(6));
				edificio.setQtdApto(Integer.parseInt(resultado.getString(7)));
				edificio.setQtdBloco(Integer.parseInt(resultado.getString(8)));
				edificio.setTelContato(Integer.parseInt(resultado.getString(9)));
				edificio.setGasIndividual(resultado.getString(10));
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
