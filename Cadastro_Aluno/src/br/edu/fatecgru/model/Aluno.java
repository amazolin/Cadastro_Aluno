package br.edu.fatecgru.model;

public class Aluno {
		// Atributos, Construtores, Getters & Setters
	private String Nome;
	private String RGM;
	private String Endereco;
	private String DataNasc;
	private String Municipio;
	private String UF;
	private String Email;
	private String Telefone;
	private String Semestre;
	private String Curso;
	private String Campus;
	private String CPF;
	private String Periodo;
	private float Nota;
	private int Falta;
	private String Disciplina;
	
	
	public Aluno() {
		
	}

	public Aluno(String nome, String rGM, String endereco, String dataNasc, String municipio, String uF, String email,
			String telefone, String semestre, String disciplina, String curso, String cpf, String campus, String periodo, float nota, int falta) {
		Nome = nome;
		RGM = rGM;
		Endereco = endereco;
		DataNasc = dataNasc;
		Municipio = municipio;
		UF = uF;
		Email = email;
		Telefone = telefone;
		Semestre = semestre;
		Curso = curso;
		Campus = campus;
		Periodo = periodo;
		Nota = nota;
		Falta = falta;
		Disciplina = disciplina;
		CPF = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getRGM() {
		return RGM;
	}

	public void setRGM(String rGM) {
		RGM = rGM;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		Semestre = semestre;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public String getCampus() {
		return Campus;
	}

	public void setCampus(String campus) {
		Campus = campus;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

	public float getNota() {
		return Nota;
	}

	public void setNota(float nota) {
		Nota = nota;
	}

	public int getFalta() {
		return Falta;
	}

	public void setFalta(int falta) {
		Falta = falta;
	}

	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}

}