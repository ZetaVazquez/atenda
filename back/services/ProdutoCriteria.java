package services;

public class ProdutoCriteria {

	private Double prezoDende;
	private Double pezoAta;
	private Integer idCategoria;
	private Integer idMarca;
	private String nome;
	
	
	
	public ProdutoCriteria() {
		super();
		prezoDende =null;
		pezoAta = null;
		idCategoria = null;
		idMarca = null;
		nome = null;
		
	}
	
	public ProdutoCriteria(Double prezoDende, Double pezoAta, Integer idCategoria, Integer idMarca, String nome) {
		super();
		this.prezoDende = prezoDende;
		this.pezoAta = pezoAta;
		this.idCategoria = idCategoria;
		this.idMarca = idMarca;
		this.nome = nome;
	}
	
	
	
	public Double getPrezoDende() {
		return prezoDende;
	}
	public void setPrezoDende(Double prezoDende) {
		this.prezoDende = prezoDende;
	}
	public Double getPezoAta() {
		return pezoAta;
	}
	public void setPezoAta(Double pezoAta) {
		this.pezoAta = pezoAta;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	



	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
