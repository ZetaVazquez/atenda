package model;

public class LineaPedido {
	private Long id;
	private Produto produto;
	private Long unidades;
	private Long desconto;
	private double prezo;
	private double coste;
	public LineaPedido() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getUnidades() {
		return unidades;
	}

	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}

	public Long getDesconto() {
		return desconto;
	}

	public void setDesconto(Long desconto) {
		this.desconto = desconto;
	}

	public double getPrezo() {
		return prezo;
	}

	public void setPrezo(double prezo) {
		this.prezo = prezo;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	@Override
	public int hashCode() {
		final long prime = 31;
		long result = 1;
		result = prime * result + id;
		return (int) result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", produto=" + produto + ", unidades=" + unidades + ", desconto=" + desconto
				+ "]";
	}

	
}
