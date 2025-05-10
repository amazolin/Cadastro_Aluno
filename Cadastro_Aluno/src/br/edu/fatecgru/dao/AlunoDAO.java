package br.edu.fatecgru.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.fatecgru.model.Aluno;
import br.edu.fatecgru.util.ConnectionFactory;


public class AlunoDAO {
	// Metodos de Java para o Banco
	private Connection conn;	// Conecta ao BD
	private PreparedStatement ps;	// Permite SQL
	private ResultSet rs;	// Uma Table
	private Aluno aluno;
	
	public AlunoDAO() throws Exception{
		/*
		 * Chama a classe ConnectionFactory e estabelece uma conexão
		 */
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	// Método Salvar Tela Curso
	
	public void salvar(Aluno aluno) throws Exception {
	    if (aluno == null || aluno.getNome() == null || aluno.getNome().isEmpty()) {
	        throw new Exception("O nome não pode ser nulo ou vazio");
	    }
	    try {
	        String SQL = "INSERT INTO tbaluno (Nome, RGM, DataNasc, CPF, Email, Endereco, Municipio, UF, Telefone, Curso, Campus, Periodo, Disciplina) "
	                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        ps = conn.prepareStatement(SQL);
	        ps.setString(1, aluno.getNome());
	        ps.setString(2, aluno.getRGM());
	        ps.setString(3, aluno.getDataNasc());
	        ps.setString(4, aluno.getCPF());
	        ps.setString(5, aluno.getEmail());
	        ps.setString(6, aluno.getEndereco());
	        ps.setString(7, aluno.getMunicipio());
	        ps.setString(8, aluno.getUF());
	        ps.setString(9, aluno.getTelefone());
	        ps.setString(10, aluno.getCurso());
	        ps.setString(11, aluno.getCampus());
	        ps.setString(12, aluno.getPeriodo());
	        ps.setString(13, aluno.getDisciplina());
	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao inserir dados: " + sqle.getMessage());
	    } finally {
	        ConnectionFactory.closeConnection(conn, ps);
	    }
	}
}
