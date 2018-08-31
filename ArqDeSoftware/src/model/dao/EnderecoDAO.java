package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	public int atualizarEenderecoDAO(EnderecoVO enderecoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
//(int idEnd, String rua, int num, String bairro, String municipio, int cep)
		String query = "UPDATE ENDERECO SET idEnd = '" + enderecoVO.getIdEnd() + "', rua = '" + enderecoVO.getNum()
				+ "', bairro = '" + enderecoVO.getBairro() + "', municipio = '"
				+ enderecoVO.getMunicipio() + "', cep = '" + enderecoVO.getCep() + "'";

		try {
			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de atualização.");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<EnderecoVO> consultarTodosEnderecosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<EnderecoVO> enderecosVO = new ArrayList<EnderecoVO>();
		String query = "SELECT * FROM ENDERECO";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
//(int idEnd, String rua, int num, String bairro, String municipio, int cep)
				EnderecoVO enderecoVO = new EnderecoVO();
				enderecoVO.setIdEnd(Integer.parseInt(resultado.getString(1)));
				enderecoVO.setRua(resultado.getString(2));
				enderecoVO.setNum(Integer.parseInt(resultado.getString(3)));
				enderecoVO.setBairro(resultado.getString(4));
				enderecoVO.setMunicipio(resultado.getString(5));
				enderecoVO.setCep(Integer.parseInt(resultado.getString(6)));
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de consulta de Enderecos.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return enderecosVO;
	}

	public EnderecoVO consultarEnderecoDAO(EnderecoVO enderecoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		EnderecoVO endereco = new EnderecoVO();
		String query = "SELECT * FROM ENDERECO  WHERE idEnd = " + enderecoVO.getIdEnd();
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				enderecoVO.setIdEnd(Integer.parseInt(resultado.getString(1)));
				enderecoVO.setRua(resultado.getString(2));
				enderecoVO.setNum(Integer.parseInt(resultado.getString(3)));
				enderecoVO.setBairro(resultado.getString(4));
				enderecoVO.setMunicipio(resultado.getString(5));
				enderecoVO.setCep(Integer.parseInt(resultado.getString(6)));
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao executar a query de consulta.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return endereco;
	}
	
}
