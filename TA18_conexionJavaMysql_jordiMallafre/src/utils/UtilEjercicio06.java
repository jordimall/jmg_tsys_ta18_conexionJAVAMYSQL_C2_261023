package utils;

public class UtilEjercicio06 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_06";

	String tablaPiezas = "piezas";
	String columnasPiezas = "codigo INT AUTO_INCREMENT, nombre NVARCHAR(100) NOT NULL, PRIMARY KEY (codigo)";
	String insertsPiezas = "(\"Tornillo\"), (\"Manguera\"), (\"Llave Inglesa\"), (\"Codo\"), (\"Tubería\")";
	String deletePiezas = "codigo=3";

	String tablaProveedores = "proveedores";
	String columnasProveedores = "id CHAR(4), nombre NCHAR(100) NOT NULL, PRIMARY KEY (id)";
	String insertsProveedores = "(\"LTDA\",\"Twitterwire\"), (\"EGXJ\",\"Centidel\"), (\"SDRT\",\"Meembee\"),"
			+ "(\"KLMS\",\"Yakijo\"), (\"GAYE\",\"Meedoo\")";
	String deleteProveedores = "id=\"GAYE\"";
	
	String tablaSuministra = "suministra";
	String columnasSuministra = "codigoPieza INT, idProveedor CHAR(4), precio INT,"
			+ "PRIMARY KEY (codigoPieza, idProveedor), FOREIGN KEY (codigoPieza)"
			+ "REFERENCES piezas (codigo) ON UPDATE CASCADE ON DELETE CASCADE,"
			+ "FOREIGN KEY (idProveedor) REFERENCES proveedores (id) "
			+ "ON UPDATE CASCADE ON DELETE CASCADE";
	String insertsSuministra = "(1, \"LTDA\", 10), (2, \"EGXJ\", 2), (1, \"EGXJ\", 10), (5, \"SDRT\", 20),"
			+ "(3, \"KLMS\", 5)";
	String deleteSuministra = "codigoPieza=1 AND idProveedor=\"LTDA\"";

	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaPiezas, columnasPiezas);
		utilMysql.crearTabla(baseDatos, tablaProveedores, columnasProveedores);
		utilMysql.crearTabla(baseDatos, tablaSuministra, columnasSuministra);

		utilMysql.insertarDatos(baseDatos, tablaPiezas, insertsPiezas);
		utilMysql.insertarDatos(baseDatos, tablaProveedores, insertsProveedores);
		utilMysql.insertarDatos(baseDatos, tablaSuministra, insertsSuministra);

		utilMysql.mostrarDatos(baseDatos, tablaPiezas);
		utilMysql.mostrarDatos(baseDatos, tablaProveedores);
		utilMysql.mostrarDatos(baseDatos, tablaSuministra);

		utilMysql.eliminarDatos(baseDatos, tablaPiezas, deletePiezas);
		utilMysql.mostrarDatos(baseDatos, tablaPiezas);

		utilMysql.eliminarDatos(baseDatos, tablaProveedores, deleteProveedores);
		utilMysql.mostrarDatos(baseDatos, tablaProveedores);
		
		utilMysql.eliminarDatos(baseDatos, tablaSuministra, deleteSuministra);
		utilMysql.mostrarDatos(baseDatos, tablaSuministra);
		
		utilMysql.cerrarSesion();

	}
}
