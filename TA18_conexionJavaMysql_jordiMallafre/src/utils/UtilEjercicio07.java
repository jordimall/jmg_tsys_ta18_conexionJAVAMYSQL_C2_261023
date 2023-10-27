package utils;

public class UtilEjercicio07 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_07";

	String tablaProductos = "productos";
	String columnasProductos = "codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, precio INT NOT NULL";
	String insertsProductos = "(\"Lemonade - Pineapple Passion\",23),(\"Parsley - Dried\", 90),(\"Lobster - Canned Premium\",3),"
			+ "(\"Lamb Tenderloin Nz Fr\",43), (\"Pasta - Penne Primavera, Single\",64)";
	String deleteProductos = "codigo=3";

	String tablaCajeros = "cajeros";
	String columnasCajeros = "codigo INT AUTO_INCREMENT PRIMARY KEY,nom_apels VARCHAR(255) NOT NULL";
	String insertsCajeros = "(\"Rafaellle Gunning\"), (\"Sophia Houlridge\"), (\"Arlinda Bottrell\"), (\"Chandra Bice\"),"
			+ "(\"Jeannette Aish\")";
	String deleteCajeros = "codigo=3";
	
	String tablaMaquinasRegistradores = "maquinas_registradoras";
	String columnasMaquinasRegistradores = "codigo INT AUTO_INCREMENT PRIMARY KEY, piso INT NOT NULL";
	String insertsMaquinasRegistradores = "(1), (2), (10), (5), (3)";
	String deleteMaquinasRegistradores = "codigo=3";
	
	String tablaVenta = "venta";
	String columnasVenta = "cajero INT, maquina INT, producto INT, PRIMARY KEY (cajero, maquina, producto),"
			+ "FOREIGN KEY (cajero) REFERENCES cajeros (codigo) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (maquina)"
			+ "REFERENCES maquinas_registradoras (codigo) ON UPDATE CASCADE ON DELETE CASCADE, FOREIGN KEY (producto)"
			+ "REFERENCES productos (codigo) ON UPDATE CASCADE ON DELETE CASCADE";
	String insertsVenta = "(1,1,1), (2,4,5), (2,5,1), (5,5,4), (4,2,5)";
	String deleteVenta = "cajero=1 AND maquina=1 AND producto=1";

	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaProductos, columnasProductos);
		utilMysql.crearTabla(baseDatos, tablaCajeros, columnasCajeros);
		utilMysql.crearTabla(baseDatos, tablaMaquinasRegistradores, columnasMaquinasRegistradores);
		utilMysql.crearTabla(baseDatos, tablaVenta, columnasVenta);

		utilMysql.insertarDatos(baseDatos, tablaProductos, insertsProductos);
		utilMysql.insertarDatos(baseDatos, tablaCajeros, insertsCajeros);
		utilMysql.insertarDatos(baseDatos, tablaMaquinasRegistradores, insertsMaquinasRegistradores);
		utilMysql.insertarDatos(baseDatos, tablaVenta, insertsVenta);
		
		utilMysql.mostrarDatos(baseDatos, tablaProductos);
		utilMysql.mostrarDatos(baseDatos, tablaCajeros);
		utilMysql.mostrarDatos(baseDatos, tablaMaquinasRegistradores);
		utilMysql.mostrarDatos(baseDatos, tablaVenta);

		utilMysql.eliminarDatos(baseDatos, tablaProductos, deleteProductos);
		utilMysql.mostrarDatos(baseDatos, tablaProductos);

		utilMysql.eliminarDatos(baseDatos, tablaCajeros, deleteCajeros);
		utilMysql.mostrarDatos(baseDatos, tablaCajeros);
		
		utilMysql.eliminarDatos(baseDatos, tablaMaquinasRegistradores, deleteMaquinasRegistradores);
		utilMysql.mostrarDatos(baseDatos, tablaMaquinasRegistradores);
		
		utilMysql.eliminarDatos(baseDatos, tablaVenta, deleteVenta);
		utilMysql.mostrarDatos(baseDatos, tablaVenta);
		
		utilMysql.cerrarSesion();

	}
}
