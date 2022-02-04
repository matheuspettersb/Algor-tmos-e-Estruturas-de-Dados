package mapas;

public class Veiculo implements Comparable<Veiculo> {
	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;

	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.proprietario = proprietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String toString() {
		return "Veiculo <" + modelo + "> , placa <" + placa + "> , ano <" + ano + "> , proprietario <" + proprietario
				+ ">";
	}

	@Override
	public int compareTo(Veiculo outro) {
		return this.placa.compareTo(outro.getPlaca());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

}