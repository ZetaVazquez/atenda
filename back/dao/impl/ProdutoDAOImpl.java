package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ProdutoDAO;
import dao.Result;
import model.Produto;
import services.ProdutoCriteria;
import utils.ConnectionManager;

public class ProdutoDAOImpl implements ProdutoDAO {
	private static final Logger logger = Logger.getLogger(ProdutoDAOImpl.class.getName());


	@Override
	public Produto findById(Connection connection, Long idProducto) throws Exception {
		Produto p = null;
		StringBuilder sql = new StringBuilder();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {

			sql.append(
					"SELECT id as idProduto, id_categoria as idCategoria, id_marca as idMarca ,nome as nomeProduto,prezo as prezoProduto,desconto as descontoProduto,");
			sql.append(
					"coste as costeProduto,iva as ivaProduto,stock as stockProduto,foto as fotoProduto ,baixa as baixaProduto FROM produto WHERE id = ?");
			preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			logger.info(preparedStatement.toString());
			preparedStatement.setLong(i++, idProducto);
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				p = loadNext(resultset);

				p.setId(1L);
				p.setIdCategoria(0);
				p.setIdMarca((long) 0);
				p.setNome("");
				p.setPrezo(22.22);
				p.setDesconto(0);
				p.setCoste(0);
				p.setIva(21);
				p.setStock(5);
				p.setFoto("foto.png");
				p.setBaixa(false);

			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());

		} finally {
			ConnectionManager.closeResultSet(resultset);

		}

		return p;
	}

	private Produto loadNext(ResultSet resultset) throws SQLException {
		Produto produto = null;
		int i = 1;
		produto = new Produto();
		produto.setId(resultset.getLong(i++));
		produto.setIdCategoria(resultset.getInt(i++));
		produto.setIdMarca(resultset.getLong(i++));
		produto.setNome(resultset.getString(i++));
		produto.setPrezo(resultset.getDouble(i++));
		produto.setDesconto(resultset.getInt(i++));
		produto.setCoste(resultset.getDouble(i++));
		produto.setIva(resultset.getInt(i++));
		produto.setStock(resultset.getInt(i++));
		produto.setFoto(resultset.getString(i++));
		produto.setBaixa(resultset.getBoolean(i++));
		return produto;
	}

	@Override
	public ArrayList<Produto> findAll(Connection connection) throws Exception {
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

		Produto p = null;

		StringBuilder sql = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			sql = new StringBuilder();

			sql.append("SELECT id as idProduto, id_categoria as idCategoria, id_marca as idMarca,");
			sql.append(" nome as idNome, prezo as idPrezo, desconto as idDesconto,");
			sql.append(" coste as idCoste, iva as idIva, stock as idStock, foto as idFoto,");
			sql.append(" baixa as idBaixa FROM produto");

			preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,

					ResultSet.CONCUR_READ_ONLY);

			logger.info(preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();

			// int size = DAOUtils.getTotalRow(resultSet);

			while (resultSet.next()) {

				p = this.loadNext(resultSet);
				listaProdutos.add(p);
			}

		} catch (SQLException e) {

			logger.info(e.getMessage());

		} finally {

			ConnectionManager.closePreparedStatement(preparedStatement);
			ConnectionManager.closeResultSet(resultSet);

		}

		return listaProdutos;
	}

	public Result<Produto> findBy(Connection connection, ProdutoCriteria produto, int startIndex, int count)
			throws Exception {
		// TODO: Mi forma:
//	    List<Produto> productos = new ArrayList<>();
//	    StringBuilder sql = new StringBuilder();
//
//	    sql.append("SELECT id as idProduto, id_categoria as idCategoria, id_marca as idMarca, nome as nomeProduto, prezo as prezoProduto, desconto as descontoProduto,"
//	            + " coste as costeProduto, iva as ivaProduto, stock as stockProduto, foto as fotoProduto, baixa as baixaProduto FROM produto WHERE 1=1");
//
//	    if (produto.getNome() != null) {
//	        sql.append(" AND nome = ?");
//	    }
//
//	    if (produto.getIdCategoria() != null) {
//	        sql.append(" AND id_categoria = ?");
//	    }
//
//	    if (produto.getIdMarca() != null) {
//	        sql.append(" AND id_marca = ?");
//	    }
//
//	    // paginación a la consulta
//	    sql.append(" LIMIT ? OFFSET ?");
//
//	    try {
//	        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
//
//	        // Asigna valores para los parámetros de la consulta
//	        int parameterIndex = 1;
//	        int total = 0;
//
//	        if (produto.getNome() != null && !produto.getNome().isEmpty()) {
//	            preparedStatement.setString(parameterIndex++, produto.getNome());
//	        }
//
//	        // Asigna el valor de la categoría solo si no es null
//	        if (produto.getIdCategoria() != null  ) {
//	            preparedStatement.setInt(parameterIndex++, produto.getIdCategoria());
//	        }
//
//	        // Asigna el valor de la marca solo si no es null
//	        if (produto.getIdMarca() != null) {
//	            preparedStatement.setInt(parameterIndex++, produto.getIdMarca());
//	        }
//
//	        preparedStatement.setInt(parameterIndex++, count);
//	        preparedStatement.setInt(parameterIndex++, startIndex);
//	        
//	        // Loggea el PreparedStatement
//	        logger.info("Valor de nome: " + produto.getNome());
//	        logger.info("Valor de marca: " + produto.getIdMarca());
//	        logger.info("Valor de categoria: " + produto.getIdCategoria());
//            logger.info("SQL Query: " + preparedStatement.toString());
//
//       
//
//	        ResultSet resultSet = preparedStatement.executeQuery();
//
//	        while (resultSet.next()) {
//	            Produto p = new Produto();
//
//	            p.setId(resultSet.getInt("idProduto"));
//	            p.setIdCategoria(resultSet.getInt("idCategoria"));
//	            p.setIdMarca(resultSet.getInt("idMarca"));
//	            p.setNome(resultSet.getString("nomeProduto"));
//	            p.setPrezo(resultSet.getDouble("prezoProduto"));
//	            p.setDesconto(resultSet.getInt("descontoProduto"));
//	            p.setCoste(resultSet.getDouble("costeProduto"));
//	            p.setIva(resultSet.getInt("ivaProduto"));
//	            p.setStock(resultSet.getInt("stockProduto"));
//	            p.setFoto(resultSet.getString("fotoProduto"));
//	            p.setBaixa(resultSet.getBoolean("baixaProduto"));
//	            productos.add(p);
//	        }
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return new Result<>(productos, count, count);

		// TODO:Forma de Paula
		List<Produto> listaProdutos = new ArrayList<Produto>();
		Produto p = null;
		StringBuilder sql = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			sql = new StringBuilder();
			sql.append("SELECT id as idProduto,");
			sql.append(" id_categoria as idCategoria,");
			sql.append(" id_marca as idMarca,");
			sql.append(" nome as idNome,");
			sql.append(" prezo as idPrezo,");
			sql.append(" desconto as idDesconto,");
			sql.append(" coste as idCoste,");
			sql.append(" iva as idIva,");
			sql.append(" stock as idStock,");
			sql.append(" foto as idFoto,");
			sql.append(" baixa as idBaixa FROM produto");
			if (produto.getPrezoDende() != null || produto.getPezoAta() != null || produto.getIdMarca() != null
					|| produto.getIdCategoria() != null || produto.getNome() != null) {
				sql.append(" WHERE");
			}
			if (produto.getNome() != null) {
				sql.append(" nome = ?");
			}
			if ((produto.getPrezoDende() != null || produto.getPezoAta() != null) && produto.getNome() != null) {
				sql.append(" and");
			}
			if (produto.getPrezoDende() != null && produto.getPezoAta() != null) {
				sql.append(" prezo BETWEEN ? and ?");

			} else if (produto.getPrezoDende() != null && produto.getPezoAta() == null) {
				sql.append(" prezo > ? ");

			} else if (produto.getPrezoDende() == null && produto.getPezoAta() != null) {
				sql.append(" prezo < ? ");

			}
			if ((produto.getPrezoDende() != null || produto.getPezoAta() != null)
					&& (produto.getIdMarca() != null || produto.getIdCategoria() != null)) {
				sql.append(" and");
			}
			if (produto.getIdMarca() != null) {
				sql.append(" id_marca = ?");

			}
			if (produto.getIdMarca() != null && produto.getIdCategoria() != null) {
				sql.append(" and");
			}
			if (produto.getIdCategoria() != null) {
				sql.append(" id_categoria = ?");

			}

			// sql.append(" LIMIT ? OFFSET ? "); //?????

			// rechear campos preapredStatement
			preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			if (produto.getNome() != null) {
				preparedStatement.setString(i++, produto.getNome());
			}
			if (produto.getPrezoDende() != null) {
				preparedStatement.setDouble(i++, produto.getPrezoDende());
			}
			if (produto.getPezoAta() != null) {
				preparedStatement.setDouble(i++, produto.getPezoAta());
			}
			if (produto.getIdMarca() != null) {
				preparedStatement.setInt(i++, produto.getIdMarca());
			}
			if (produto.getIdCategoria() != null) {
				preparedStatement.setInt(i++, produto.getIdCategoria());
			}

//			preparedStatement.setInt(i++, count);
//			preparedStatement.setInt(i++, startIndex);

			logger.info(preparedStatement.toString());

			// transformar as respostas en produtos e engadilo ao arrayList
			resultSet = preparedStatement.executeQuery();
			int currentCount = 0;
			if (startIndex >= 1 && resultSet.absolute(startIndex)) {
				do {
					p = this.loadNext(resultSet);
					logger.info(p.toString());
					listaProdutos.add(p);
					currentCount++;
				} while (currentCount < count && resultSet.next());
			}

		} catch (SQLException e) {
			logger.info(e.getMessage());
		} finally {
			ConnectionManager.closeResultSet(resultSet);
			ConnectionManager.closePreparedStatement(preparedStatement);
		}
		return new Result<Produto>(listaProdutos, startIndex, count);

	}

	@Override
	public Produto create(Connection connection, Produto produto) throws Exception {
		String sql = "INSERT INTO produto (id_categoria, id_marca, nome, prezo, desconto, coste, iva, stock, foto, baixa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setLong(1, produto.getIdCategoria());
			preparedStatement.setLong(2, produto.getIdMarca());
			preparedStatement.setString(3, produto.getNome());
			preparedStatement.setDouble(4, produto.getPrezo());
			preparedStatement.setInt(5, produto.getDesconto());
			preparedStatement.setDouble(6, produto.getCoste());
			preparedStatement.setInt(7, produto.getIva());
			preparedStatement.setInt(8, produto.getStock());
			preparedStatement.setString(9, produto.getFoto());
			preparedStatement.setBoolean(10, produto.isBaixa());

		     int affectedRows = preparedStatement.executeUpdate();
		    

		        if (affectedRows == 0) {
		            throw new SQLException("La creación del producto ha fallado.");
		        }

		        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                Long id = generatedKeys.getLong(1);
		                produto.setId(id); 
		                return produto;
		    	      
		            } else {
		                throw new SQLException("La creación del producto ha fallado al obtener la clave generada.");
		            }
		            
			}
	
				
		}
	
	}

	@Override
	public Produto update(Connection connection, Produto produto) throws Exception {
		String sql = "UPDATE produto SET id_categoria = ?, id_marca = ?, nome = ?, prezo = ?, desconto = ?, coste = ?, iva = ?, stock = ?, foto = ?, baixa = ? WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setLong(1, produto.getIdCategoria());
			preparedStatement.setLong(2, produto.getIdMarca());
			preparedStatement.setString(3, produto.getNome());
			preparedStatement.setDouble(4, produto.getPrezo());
			preparedStatement.setInt(5, produto.getDesconto());
			preparedStatement.setDouble(6, produto.getCoste());
			preparedStatement.setInt(7, produto.getIva());
			preparedStatement.setInt(8, produto.getStock());
			preparedStatement.setString(9, produto.getFoto());
			preparedStatement.setBoolean(10, produto.isBaixa());
			preparedStatement.setLong(11, produto.getId());

			logger.info("SQL Query for Update: " + preparedStatement.toString());

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("update fallido");
			}

			return produto;
		}
	}

	@Override
	public boolean softDelete(Connection connection, Long idProduto) throws Exception {
		String sql = "UPDATE produto SET baixa = true WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setLong(1, idProduto);

			int affectedRows = preparedStatement.executeUpdate();

			return affectedRows > 0;
			
			
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

}
