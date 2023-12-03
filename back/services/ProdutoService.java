package services;

import java.util.ArrayList;
import dao.Result;
import exceptions.Data2Exception;
import model.Produto;

public interface ProdutoService{

	public Produto findById( Long idProduto) throws Data2Exception;//Encontra produtos por id

	public ArrayList<Produto> findAll() throws Data2Exception; // devolve a lista de produtos

	public Result<Produto> findBy(ProdutoCriteria produto, int startIndex,int count) throws Data2Exception;

	public Produto create(Produto produto) throws Data2Exception;// inserta produto

	public Produto update(Produto produto) throws Data2Exception;// actualiza produto

	public boolean softDelete(Long idProducto) throws Data2Exception; // borra soft produto
	
	public boolean asignarProdutoCategoria (Long idProduto, Integer idCategoria)throws Data2Exception;
	
	public boolean asignarProdutoMarca( Long idProduto, Long idMarca)throws Data2Exception;
}
