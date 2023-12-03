package model;

public class Produto {
	
	private Long id;
	private Integer idCategoria;
	private Long idMarca;
	private String nome;
	private Double prezo;
	private Integer desconto;
	private Double coste;
	private Integer iva;
	private Integer stock;
	private String foto;
	private boolean baixa;

	public Produto() {
		super();

	}
	public Produto(Long id, String nome, double prezo, int stock) {
		super();
		this.id=id;
		this.nome = nome;
		this.prezo = prezo;
		this.stock = stock;
	}
	public Long getId() {
		return id;
	}
	public Produto setId(Long id) {
		this.id = id;
		return this;
	}
	public String getNome() {
		return nome;
	}
	public Produto setNome(String nome) {
		this.nome = nome;
		return this;
	}
	public double getPrezo() {
		return prezo;
	}
	public Produto setPrezo(double prezo) {
		this.prezo = prezo;
		return this;
	}
	public int getDesconto() {
		return desconto;
	}
	public Produto setDesconto(int desconto) {
		this.desconto = desconto;
		return this;
	}
	public double getCoste() {
		return coste;
	}
	public Produto setCoste(double coste) {
		this.coste = coste;
		return this;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getStock() {
		return stock;
	}
	public Produto setStock(int stock) {
		this.stock = stock;
		return this;
	}
	
	public boolean isBaixa() {
		return baixa;
	}
	public Produto setBaixa(boolean baixa) {
		this.baixa = baixa;
		return this;
	}
	
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", prezo=" + prezo + ", desconto=" + desconto + ", coste="
				+ coste + ", iva=" + iva + ", stock=" + stock + ", baixa=" + baixa + "]";
	}

}
