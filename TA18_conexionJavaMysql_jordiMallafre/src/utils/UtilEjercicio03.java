package utils;

public class UtilEjercicio03 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_03";

	String tablaAlmacen = "almacen";
	String columnasAlmacen = "codigo INT AUTO_INCREMENT PRIMARY KEY,lugar VARCHAR(100) NOT NULL,capacidad INT NOT NULL";
	String insertsAlmacen = "(\"14th Floor\",22), (\"Suite 85\",69), (\"Apt 1754\",15), (\"10th Floor\",1), (\"Apt 549\",44);";
	String deleteAlmacen = "codigo=3";

	String tablaCaja = "caja";
	String columnasCaja = "num_referencia CHAR(5) PRIMARY KEY, contenido VARCHAR(100) NOT NULL,"
			+ "valor INT NOT NULL,almacen INT NOT NULL,FOREIGN KEY (almacen) REFERENCES almacen(codigo)"
			+ "ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsCaja = "(\"PA-8\",\"Dragline\",6618,1),(\"TD-GR\",\"Skid-Steer\",6745,2),(\"US-OR\",\"Scraper\",3905,2),"
			+ "(\"US-CA\",\"Skid-Steer\",343,5),(\"BR-RS\",\"Excavator\",604,4);";
	String deleteCaja = "num_referencia=\"TD-GR\"";

	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaAlmacen, columnasAlmacen);
		utilMysql.crearTabla(baseDatos, tablaCaja, columnasCaja);

		utilMysql.insertarDatos(baseDatos, tablaAlmacen, insertsAlmacen);
		utilMysql.insertarDatos(baseDatos, tablaCaja, insertsCaja);

		utilMysql.mostrarDatos(baseDatos, tablaAlmacen);
		utilMysql.mostrarDatos(baseDatos, tablaCaja);

		utilMysql.eliminarDatos(baseDatos, tablaAlmacen, deleteAlmacen);
		utilMysql.mostrarDatos(baseDatos, tablaAlmacen);

		utilMysql.eliminarDatos(baseDatos, tablaCaja, deleteCaja);
		utilMysql.mostrarDatos(baseDatos, tablaCaja);

		utilMysql.cerrarSesion();

	}
}
