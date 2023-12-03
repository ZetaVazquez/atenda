package test.dao;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.Result;
import dao.impl.ProdutoDAOImpl;
import model.Produto;
import services.ProdutoCriteria;
import utils.ConnectionManager;


public class ProductoDAOtest {

	private static final Logger logger= Logger.getLogger(ProductoDAOtest.class.getName());
	public static void main(String[] args) {
		 Connection connection=null;
		 ProdutoDAOImpl produtoDAO=new ProdutoDAOImpl();
		 
		 
		//FIND BY:
		 try {
			//produtoDAO.findBy(ConnectionManager.getConnection(),new ProdutoCriteria(),1,50);
			 produtoDAO.findBy(ConnectionManager.getConnection(),new ProdutoCriteria(1D,10D,0,2, "martelo"),1,50);
			 
			 // Imprimir la lista de produtos después de llamar a findBy
	            Result<Produto> result = produtoDAO.findBy(ConnectionManager.getConnection(), new ProdutoCriteria(2D, 50D, 1, 2, "martelo"), 1, 50);
	            List<Produto> produtosEncontrados = result.getPage();
	            
	            //FIND BY ID
	            Produto p = new Produto();
	            p = produtoDAO.findById(ConnectionManager.getConnection(), 1L);

	         // Verifica si hay productos en el resultado antes de imprimir
	         if (produtosEncontrados != null && !produtosEncontrados.isEmpty()) {
	             for (Produto produto : produtosEncontrados) {
	                 System.out.println(produto); // Esto utilizará automáticamente el método toString de la clase Produto
	             }
	         } else {
	             System.out.println("No se encontraron productos.");
	         }
	            
		 } catch (Exception e) {
				e.printStackTrace();
			}
////////////////////////////////////////////////////////////////////////////////////
		 
		 try {
	            // Obtener una conexión de la base de datos (asegúrate de tener la lógica de conexión adecuada)
	            connection = ConnectionManager.getConnection();

	            // Llamar a findAll
	            ArrayList<Produto> listaProdutos = produtoDAO.findAll(connection);

	            // Imprimir los productos recuperados
	            for (Produto produto : listaProdutos) {
	                logger.info(produto.toString());
	            }

	        } catch (Exception e) {
	            logger.log(Level.SEVERE, "Error en la prueba de findAll: " + e.getMessage(), e);
	        } 
	    
	    
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 
		 try {
			    // Crear un producto para probar el create
			    Produto creaProduto = new Produto();
			    creaProduto.setNome("popcorn");
			    creaProduto.setPrezo(6.0);
			    creaProduto.setDesconto(2);
			    creaProduto.setCoste(3.0);
			    creaProduto.setIva(18);
			    creaProduto.setStock(20);
			    creaProduto.setFoto("pop.jpg");
			    creaProduto.setBaixa(false);
			    creaProduto.setIdCategoria(1);
			    creaProduto.setIdMarca(2L);

			    // Crear el producto
			    Produto productoCreado = produtoDAO.create(ConnectionManager.getConnection(), creaProduto);
			    logger.info("Producto creado con ID: " + productoCreado.getId());

			    // Actualizar el producto creado para probar el update
			    productoCreado.setPrezo(1.40);
			    productoCreado.setStock(15);

			    // Actualizar el producto
			    Produto productoActualizado = produtoDAO.update(ConnectionManager.getConnection(), productoCreado);
			    logger.info("Producto actualizado: " + productoActualizado);

			    // Realizar un soft delete
			    boolean softDeleteOK = produtoDAO.softDelete(ConnectionManager.getConnection(), productoActualizado.getId());
			    logger.info("Soft delete OK: " + softDeleteOK);

			} catch (Exception e) {
			    logger.info("Error durante la prueba del método: " + e.getMessage());
			    e.printStackTrace();
			}
	}

}
