package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private Long id;
	private long idPedidoDevol;
	private Usuario cliente;
	private LocalDateTime data;
	private List <LineaPedido> lineasPedido = new ArrayList<LineaPedido>();
	private boolean pechado;
	private boolean recibido;
	
	
	public Pedido() {
		super();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPedidoDevol() {
		return idPedidoDevol;
	}

	public void setIdPedidoDevol(Long idPedidoDevol) {
		this.idPedidoDevol = idPedidoDevol;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public ArrayList getLineasPedido() {
		return (ArrayList) lineasPedido;
	}

	public void setLineasPedido(ArrayList lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	public void addLineaPedido (LineaPedido linea) {
		lineasPedido.add(linea);
	}
	public void removeLineaPedido (LineaPedido linea) {
		// non identifico lineapedido con id_lineaPedido; porque igual non o ten aínda asignado
		// identifico lineapedido polo producto. Asumo que todas as liñas pedido teñen
		// produtos distintos
		for (int i =0; i<lineasPedido.size(); i++) {
			if (lineasPedido.get(i).getProduto().equals(linea.getProduto())) {
				lineasPedido.remove(i);
			}
		}	
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
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String resultado = "Pedido [id=" + id + ", idPedidoDevol=" + idPedidoDevol + ", cliente=" + cliente.getId() + ", data=" + data+System.lineSeparator();
		for (LineaPedido linea: lineasPedido) {
			resultado += linea.toString()+System.lineSeparator();
		}
		return resultado;
	}
}
