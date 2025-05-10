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
	    // Verificação inicial de dados essenciais
	    if (aluno == null || aluno.getNome() == null || aluno.getNome().isEmpty()) {
	        throw new Exception("O nome não pode ser nulo ou vazio");
	    }
	    if (aluno.getRGM() == null || aluno.getRGM().isEmpty()) {
	        throw new Exception("O RGM não pode ser nulo ou vazio");
	    }
	    if (aluno.getCPF() == null || aluno.getCPF().isEmpty()) {
	        throw new Exception("O CPF não pode ser nulo ou vazio");
	    }
	    
	    // SQL de inserção com os campos necessários
	    String SQL = "INSERT INTO tbaluno (Nome, RGM, DataNasc, CPF, Email, Endereco, Municipio, UF, Telefone) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    // Tentar executar a inserção no banco de dados
	    try (PreparedStatement ps = conn.prepareStatement(SQL)) {
	        // Definindo os parâmetros do PreparedStatement
	        ps.setString(1, aluno.getNome());
	        ps.setString(2, aluno.getRGM());
	        ps.setString(3, aluno.getDataNasc());
	        ps.setString(4, aluno.getCPF());
	        ps.setString(5, aluno.getEmail());
	        ps.setString(6, aluno.getEndereco());
	        ps.setString(7, aluno.getMunicipio());
	        ps.setString(8, aluno.getUF());
	        ps.setString(9, aluno.getTelefone());

	        // Executa o comando de inserção no banco
	        ps.executeUpdate();
	    } catch (SQLException sqle) {
	        // Se ocorrer um erro, lançar uma exceção com detalhes
	        throw new Exception("Erro ao inserir dados: " + sqle.getMessage(), sqle);
	    } finally {
	        // Fechar a conexão com o banco de dados
	        ConnectionFactory.closeConnection(conn);
	    }
	}
	
}
