package utils;

public class UtilEjercicio01 {

	UtilsMysql utilMysql = new UtilsMysql();
	
	String baseDatos = "ejercicio_01";
	
	String tablaFabricantes = "fabricantes";
	String columnasFabricantes = "codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL";
	String insertFabricantes = "(\"Yadel\"),(\"Dynava\"),(\"Jazzy\"),(\"Photobug\"),(\"Brainlounge\")";
	String deleteFabricantes = "codigo=1"; 
	
	String tablaArticulos = "articulos";
	String columnasArticulos = "codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL,"
			+ "precio INT NOT NULL, fabricante INT NOT NULL,"
			+ "FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsArticulos = "(\"Meevee\", 12, 1), (\"Rhybox\", 34, 2), (\"Vitz\", 52, 3),"
			+ "(\"Midel\", 47, 1), (\"Edgewire\", 74, 5);";
	String deleteArticulos = "codigo=1"; 

	public void iniciarAplicación() {
		
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);
		
		utilMysql.crearTabla(baseDatos, tablaFabricantes, columnasFabricantes);
		utilMysql.crearTabla(baseDatos, tablaArticulos, columnasArticulos);
		
		utilMysql.insertarDatos(baseDatos, tablaFabricantes, insertFabricantes);
		utilMysql.insertarDatos(baseDatos, tablaArticulos, insertsArticulos);
		
		utilMysql.mostrarDatos(baseDatos, tablaFabricantes);
		utilMysql.mostrarDatos(baseDatos, tablaArticulos);
		
		
		utilMysql.eliminarDatos(baseDatos, tablaFabricantes, deleteArticulos);
		utilMysql.mostrarDatos(baseDatos, tablaFabricantes);
		
		
		utilMysql.eliminarDatos(baseDatos, tablaArticulos, deleteArticulos);
		utilMysql.mostrarDatos(baseDatos, tablaArticulos);
		
		utilMysql.cerrarSesion();
	}

}
