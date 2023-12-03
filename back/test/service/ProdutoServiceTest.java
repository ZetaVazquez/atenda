
package test.service;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.Result;
import exceptions.Data2Exception;
import model.Produto;
import services.ProdutoCriteria;
import services.ProdutoService;
import services.imp.ProdutoServiceImpl;

public class ProdutoServiceTest {

	private static final Logger logger = Logger.getLogger(ProdutoServiceTest.class.getName());

	public static void main(String[] args) {

		ProdutoService produtoService = new ProdutoServiceImpl();

		// FINDBYID :FUNCIONA

		try {

			Produto p = produtoService.findById(1L);
			logger.info(p.toString());

		} catch (Data2Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		// FINDALL :FUNCIONA
		try {
			ArrayList<Produto> listaProdutos = produtoService.findAll();

			if (listaProdutos != null && !listaProdutos.isEmpty()) {
				logger.info("Productos encontrados:");
				for (Produto produto : listaProdutos) {
					logger.info(produto.toString());
				}
			} else {
				logger.info("No se encontraron productos.");
			}
		} catch (Data2Exception e) {
			logger.log(Level.SEVERE, "Error al probar findAll: " + e.getMessage(), e);
		}

		
		
		
		// FINDBY :FUNCIONA
		try {
			ProdutoCriteria criteria = new ProdutoCriteria(2D, 50D, 1, 2, "martelo");
			int startIndex = 1; // Página inicial
			int count = 10; // Cantidad de productos por página

			Result<Produto> result = produtoService.findBy(criteria, startIndex, count);

			if (result != null && result.getTotal() > 0) {
				logger.info("Productos encontrados (página " + startIndex + "):");
				for (Produto produto : result.getPage()) {
					logger.info(produto.toString());
				}
			} else {
				logger.info("No se encontraron productos para los criterios dados.");
			}
		} catch (Data2Exception e) {
			logger.log(Level.SEVERE, "Error al probar findBy: " + e.getMessage(), e);
		}
		
		try {
		    // CREATE: Funciona
		    Produto novoProduto = new Produto();
		    novoProduto.setIdCategoria(1);
		    novoProduto.setIdMarca(1L);
		    novoProduto.setNome("plato");
		    novoProduto.setPrezo(19.99);
		    novoProduto.setDesconto(5);
		    novoProduto.setCoste(15.0);
		    novoProduto.setIva(21);
		    novoProduto.setStock(50);
		    novoProduto.setFoto("nuevo_producto.jpg");
		    novoProduto.setBaixa(false);

		    // Crear el nuevo producto y obtener el producto creado con su ID
		    Produto nuevoProducto = produtoService.create(novoProduto);
		    logger.info("Nuevo producto creado con ID: " + novoProduto.getId());

		    // UPDATE: Funciona
		    // Actualizamos algunos atributos del producto creado
		    novoProduto.setPrezo(2.99);
		    novoProduto.setStock(10);

		    // Actualizar el producto
		    Produto productoActualizado = produtoService.update(novoProduto);
		    logger.info("Producto actualizado: " + productoActualizado);

		    // SOFT DELETE
		    // Realizar un soft delete del producto
		    boolean eliminacionExitosa = produtoService.softDelete(novoProduto.getId());

		    if (eliminacionExitosa) {
		        logger.info("Producto con ID: " + novoProduto.getId() + " puesto en baja (1)");
		    } else {
		        logger.info("No se pudo eliminar suavemente el producto con ID: " + novoProduto.getId());
		    }
		} catch (Data2Exception e) {
		    logger.log(Level.SEVERE, "Error al realizar eliminación suave del producto", e);
		}
	}
}