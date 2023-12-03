package services.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import dao.ProdutoDAO;
import dao.Result;
import dao.impl.ProdutoDAOImpl;
import exceptions.Data2Exception;

import model.Produto;
import services.ProdutoCriteria;
import services.ProdutoService;
import utils.ConnectionManager;


public class ProdutoServiceImpl implements ProdutoService {

	private static final Logger logger= Logger.getLogger(ProdutoServiceImpl.class.getName());

	private ProdutoDAO produtoDAO = new ProdutoDAOImpl();
	
	@Override
	public Produto findById(Long idProduto) throws Data2Exception {
		Connection connection = null;
		Produto p=null;
		boolean commit=false;
		try {
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(false);
			p=produtoDAO.findById(connection,idProduto);
			
			commit= true;
		}catch(Exception e){
			logger.log(Level.SEVERE,e.toString());
		
		}finally{
		ConnectionManager.closeConnection(connection,commit);
//		try {
//			connection.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
		return p;
	}
	
	
	
	
	@Override
	public ArrayList<Produto> findAll() throws Data2Exception {
		  Connection connection = null;
	        ArrayList<Produto> listaProdutos = new ArrayList<>();
	        boolean commit = false;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            listaProdutos = produtoDAO.findAll(connection);

	            commit = true;
	            

	            
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, e.toString());
	            throw new Data2Exception("Error,no se encuentran TODOS los productos", e);
	        } finally {
	           
	        	ConnectionManager.closeConnection(connection,commit);
	        }

	        return listaProdutos;
	    }


	@Override
	public Result<Produto> findBy(ProdutoCriteria produto, int startIndex, int count) throws Data2Exception {
		  Connection connection = null;
	        Result<Produto> result = null;
	        boolean commit = false;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);
	            
//				count = 50; // Cantidad de productos por página
//	            startIndex = 0; // Página inicial

	            result = produtoDAO.findBy(connection, produto, startIndex, count);

	            commit = true;
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, e.toString());
	            throw new Data2Exception("Error finding Produtos by criteria", e);
	        } finally {
	         
	          ConnectionManager.closeConnection(connection,commit);

	        }

	        return result;
	}

	  @Override
	    public Produto create(Produto produto) throws Data2Exception {
	        Connection connection = null;
	        boolean commit = false;
	        Produto generatedProd = null;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            generatedProd = produtoDAO.create(connection, produto);

	            commit = true;
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, e.toString());
	            throw new Data2Exception("Error al crear el producto", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, commit);
	        }

	        return generatedProd;
	    }

	    @Override
	    public Produto update(Produto produto) throws Data2Exception {
	        Connection connection = null;
	        boolean commit = false;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            produtoDAO.update(connection, produto);

	            commit = true;
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, e.toString());
	            throw new Data2Exception("Error al actualizar el producto", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, commit);
	        }

	        return produto;
	    }

	    @Override
	    public boolean softDelete(Long idProduto) throws Data2Exception {
	        Connection connection = null;
	        boolean commit = false;

	        try {
	            connection = ConnectionManager.getConnection();
	            connection.setAutoCommit(false);

	            boolean deleted = produtoDAO.softDelete(connection, idProduto);

	            commit = true;

	            return deleted;
	        } catch (Exception e) {
	            logger.log(Level.SEVERE, e.toString());
	            throw new Data2Exception("Error al realizar eliminación suave del producto", e);
	        } finally {
	            ConnectionManager.closeConnection(connection, commit);
	        }
	    }



		@Override
		public boolean asignarProdutoCategoria(Long idProduto, Integer idCategoria) throws Data2Exception {
			// TODO Auto-generated method stub
			return false;
		}




		@Override
		public boolean asignarProdutoMarca(Long idProduto, Long idMarca) throws Data2Exception {
			// TODO Auto-generated method stub
			return false;
		}

}
