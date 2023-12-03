package dao;

import java.sql.Connection;
import java.util.ArrayList;
import model.Produto;
import services.ProdutoCriteria;

public interface ProdutoDAO {

	public Produto findById(Connection connection, Long idProducto) throws Exception;//Encontra produtos por id

	public ArrayList<Produto> findAll(Connection connection) throws Exception; // devolve a lista de produtos

	public Result<Produto> findBy(Connection connection, ProdutoCriteria produto, int startIndex,int count) throws Exception;

	public Produto create(Connection connection, Produto produto) throws Exception;// inserta produto

	public Produto update(Connection connection, Produto produto) throws Exception;// actualiza produto

	public boolean softDelete(Connection connection, Long idProducto) throws Exception; // borra soft produto
	
}
