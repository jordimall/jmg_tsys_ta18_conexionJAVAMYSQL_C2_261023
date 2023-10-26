package utils;

public class UtilEjercicio05 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_05";

	String tablaDespachos = "despachos";
	String columnasDespachos = "numero INT AUTO_INCREMENT PRIMARY KEY, capacidad INT NOT NULL";
	String insertsDespachos = "(5), (3), (1), (2), (1)";
	String deleteDespachos = "numero=3";

	String tablaDirector = "director";
	String columnasDirector = "dni VARCHAR(8) PRIMARY KEY, nombre_apellidos VARCHAR(255) NOT NULL, despacho INT NOT NULL,"
			+ "dni_jefe VARCHAR(8) NULL, FOREIGN KEY (despacho) REFERENCES despachos(numero), FOREIGN KEY (dni_jefe) REFERENCES director(dni)"
			+ "ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsDirector = "(\"11111111\", \"Caren Quinnelly\",1,null), (\"22222222\",\"Ollie Sore\",2,null),"
			+ "(\"55555555\",\"Mellie Mitro\",4,null), (\"33333333\",\"Tiffie Soldan\",4,\"11111111\"),"
			+ "(\"44444444\",\"Marnia Gounel\",5,\"22222222\")";
	String deleteDirector = "dni=11111111";

	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaDespachos, columnasDespachos);
		utilMysql.crearTabla(baseDatos, tablaDirector, columnasDirector);

		utilMysql.insertarDatos(baseDatos, tablaDespachos, insertsDespachos);
		utilMysql.insertarDatos(baseDatos, tablaDirector, insertsDirector);

		utilMysql.mostrarDatos(baseDatos, tablaDespachos);
		utilMysql.mostrarDatos(baseDatos, tablaDirector);

		utilMysql.eliminarDatos(baseDatos, tablaDespachos, deleteDespachos);
		utilMysql.mostrarDatos(baseDatos, tablaDespachos);

		utilMysql.eliminarDatos(baseDatos, tablaDirector, deleteDirector);
		utilMysql.mostrarDatos(baseDatos, tablaDirector);

		utilMysql.cerrarSesion();

	}
}
