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

	    String SQLAluno = "INSERT INTO tbaluno (Nome, RGM, DataNasc, CPF, Email, Endereco, Municipio, UF, Telefone) "
	                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    String SQLCursoAluno = "INSERT INTO tbcurso (aluno_rgm, nome_curso, semestre, nota, falta, Disciplina, periodo, campus) VALUES (?,?, ?, ?, ?, ?, ?, ?)";

	    try {
	        conn.setAutoCommit(false); // Desativa autocommit para controle manual

	        // Inserção na tabela de aluno
	        try (PreparedStatement ps = conn.prepareStatement(SQLAluno)) {
	            ps.setString(1, aluno.getNome());
	            ps.setString(2, aluno.getRGM());
	            ps.setString(3, aluno.getDataNasc());
	            ps.setString(4, aluno.getCPF());
	            ps.setString(5, aluno.getEmail());
	            ps.setString(6, aluno.getEndereco());
	            ps.setString(7, aluno.getMunicipio());
	            ps.setString(8, aluno.getUF());
	            ps.setString(9, aluno.getTelefone());
	            ps.executeUpdate();
	        }

	        // Inserção na tabela de curso (ajuste se for relacionamento, como curso_aluno)
	        try (PreparedStatement psCurso = conn.prepareStatement(SQLCursoAluno)) {
	            psCurso.setString(1, aluno.getRGM());
	        	psCurso.setString(2, aluno.getCurso());       // nome_curso
	            psCurso.setString(3, aluno.getSemestre());                                                   
	            psCurso.setDouble(4, aluno.getNota());                    
	            psCurso.setInt(5, aluno.getFalta());                       
	            psCurso.setString(6, aluno.getDisciplina());                 
	            psCurso.setString(7, aluno.getPeriodo());                    
	            psCurso.setString(8, aluno.getCampus());  
	            

	            psCurso.executeUpdate();
	        }
	        

	        conn.commit(); // Tudo certo, confirma
	       

	    } catch (SQLException sqle) {
	        if (conn != null) {
	            try {
	                conn.rollback(); // Reverte qualquer alteração em caso de erro
	            } catch (SQLException rollbackEx) {
	                throw new Exception("Erro ao fazer rollback: " + rollbackEx.getMessage(), rollbackEx);
	            }
	        }
	        throw new Exception("Erro ao inserir dados: " + sqle.getMessage(), sqle);
	    } finally {
	        try {
	            if (conn != null) {
	                conn.setAutoCommit(true); // Restaura o autocommit
	                ConnectionFactory.closeConnection(conn);
	            }
	        } catch (SQLException e) {
	            throw new Exception("Erro ao fechar a conexão: " + e.getMessage(), e);
	        }
	    }
	    
	}
	public Aluno pesquisar(String rgm) throws Exception {
    	
		String SQLAluno = "SELECT nome FROM tbaluno WHERE RGM = ?";
		String SQLCursoAluno = "SELECT nome_curso, disciplina, semestre, nota, falta FROM tbcurso WHERE aluno_rgm = ?";
    	
	    Aluno aluno = new Aluno();
	    aluno.setRGM(rgm);
		
		try(PreparedStatement psAluno = conn.prepareStatement(SQLAluno)){
	    	psAluno.setString(1, aluno.getRGM());
	    	ResultSet rs = psAluno.executeQuery();
	    	if (rs.next()) {
	    		aluno = new Aluno();
	    		aluno.setRGM(aluno.getRGM());
	    		aluno.setNome(rs.getString("Nome"));
	    	}
	    }
    	
    	try (PreparedStatement psCurso = conn.prepareStatement(SQLCursoAluno)) {
	    	psCurso.setString(1, aluno.getRGM());
	    	ResultSet rs = psCurso.executeQuery();
	    	
	    	if (rs.next()) {
	    		aluno = new Aluno();
	    		aluno.setRGM(aluno.getRGM());
	    		aluno.setCurso(rs.getString("nome_curso"));
	    		aluno.setDisciplina(rs.getString("disciplina"));
	            aluno.setSemestre(rs.getString("semestre"));
	            aluno.setNota(rs.getFloat("nota"));
	            aluno.setFalta(rs.getInt("falta"));
	    	}
	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao buscar aluno: " + sqle.getMessage(), sqle);
	    }
    	return aluno;
	}	

}


