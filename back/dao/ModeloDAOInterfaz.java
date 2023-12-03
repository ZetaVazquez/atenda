package dao;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.Informe;
import model.LineaPedido;
import model.Opinion;
import model.Pedido;
import model.Produto;
import model.Usuario;

public interface ModeloDAOInterfaz {
	 public static final String DEFAULT_FOTO="default.PNG";
	 public static final String UPLOAD_DIR ="c:/ficheros/images/";
//	 public static final String UPLOAD_DIR ="/atenda/uploads";
	 public static final LocalDate INICIO_REXISTRO_PEDIDOS = LocalDate.now().minusYears(5); // data de inicio dos pedidos
	 public static final int ALTURA_IMAXES=200;
	 public static final int ANCHURA_IMAXES=200;
	 public static final int ALTURA_AVATAR=40;
	 public static final int ANCHURA_AVATAR=40;
	 
	
	 // XML
	 public void exportaProdutos(ArrayList<Produto> produtos, File exportedFile); // exporta a lista de productos a o ficheiro en formato XML
	 public void importaProdutos (File xmlFileProdutos); //importa os productos do ficheiro na lista de produtos
	 // PedidoDAO
	 public Pedido getPedidoPorId(int id) throws Exception; // devolve pedido de campo id= id
	// devolve os pedidos abertos ou pechados entre as d�as datas con ou sin devoluci�ns e recibidos ou non
	 public ArrayList<Pedido> getPedidosPeriodo(LocalDate dende, LocalDate ata, boolean conDevolucions, boolean pechado, boolean recibido) throws Exception;
	// devolve os pedidos abertos ou pechados entre as d�as datas dun usuario e con ou sin devoluci�ns e recibidos ou non
	 public ArrayList<Pedido> getPedidosPeriodoDe(LocalDate dendeLocalDate, LocalDate ataLocalDate, boolean eDevolucions,
				Usuario usuario, boolean pechado, boolean recibido) throws Exception; 
	 public ArrayList<Pedido> getDevolucionsDe (Pedido pedido)throws Exception; // devolve a lista de pedidos devoluci�ns do pedido parametro
	 public int inserta(Pedido pedido)throws Exception; // // inserta pedido como aberto, insertando tam�n lineas pedido que cont�n
	 public void actualiza(Pedido pedido )throws Exception; // actualiza todo menos lineas pedido
	 // novo en v. 230102
	 public void borra (Pedido pedido) throws Exception;// borra pedido
	 // LineaPedidoDAO
	 public int inserta (LineaPedido lineaPedido, Pedido pedido) throws Exception; // inserta LineaPedido e devolve id
	 public void actualiza (LineaPedido lineaPedido) throws Exception; // actualiza LineaPedido (unidades só)
	 public int getUnidadesDevoltasDe (LineaPedido lineaPedido) throws Exception;   // devolve as devoluci�ns xa feitas dunha li�a pedido
	 /// novo en v. 230102
	 public void borra(LineaPedido linea) throws Exception;// borra linea pedido.
	 // OpinionDAO
	 public int getValoracionMedia(Produto produto) throws Exception; // obten a valoración media enteira dun produto 
	 public ArrayList<Opinion>  getOpinions(Produto produto) throws Exception ; // devolve as opinions sobre un produto
	 public LinkedHashMap<Integer, Integer> getValoracions (Produto produto) throws Exception; // devolve as valoracións sobre un produto
	  																							// como pares valoracion-numero de valoracions
	 public int inserta(Opinion comentario) throws Exception; // insertar unha opinión na base de datos
	 // BI
	 public Informe getInformePedidos (ArrayList<Pedido> pedidos ) throws Exception; // devolve o infome da lista de pedidos par�metro
	
}

