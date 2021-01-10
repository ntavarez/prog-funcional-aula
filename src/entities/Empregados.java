package entities;

public class Empregados {

	private String nome;
	private String email;
	private double salario;

	public Empregados(String nome, String email, double salario) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override

	public String toString() {
		return nome + ", " + String.format("%2.f", salario);
	}

}
