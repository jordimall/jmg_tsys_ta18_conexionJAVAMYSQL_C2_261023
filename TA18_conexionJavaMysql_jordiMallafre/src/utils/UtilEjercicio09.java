package utils;

public class UtilEjercicio09 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_09";

	String tablaCientificos = "cientificos";
	String columnasCientificos = "	dni VARCHAR(8) PRIMARY KEY, nomApels VARCHAR(255) NOT NULL";
	String insertsCientificos = "(\"11111111\",\"Dyanna Brewers\"), (\"22222222\",\"Shurlock Shyre\"), "
			+ "(\"33333333\",\"Kelcey Ilem\"), (\"44444444\",\"Kellen Doswell\"),(\"55555555\",\"Farra Tattoo\")";
	String deleteCientificos = "dni=\"22222222\"";
	
	String tablaProyecto = "proyecto";
	String columnasProyecto = "id CHAR(4) PRIMARY KEY, nombre VARCHAR(100) NOT NULL,horas INT NOT NULL";
	String insertsProyecto = "(\"BITN\",\"Wunsch, Weber and Walter\",1), (\"YORC\",\"Borer, Swaniawski and Kautzer\",2),"
			+ "(\"SCTT\",\"Hermann and Sons\",4),(\"LICA\",\"Little Group\",4), (\"LGPL\",\"Williamson, Kris and Raynor\",5)";
	String deleteProyecto = "id=\"YORC\"";
	
	String tablaAsignadoA = "asignado_a";
	String columnasAsignadoA = "cientifico VARCHAR(8), proyecto CHAR(4), PRIMARY KEY (cientifico, proyecto),"
			+ "FOREIGN KEY (cientifico) REFERENCES cientificos (DNI) ON UPDATE CASCADE ON DELETE CASCADE,"
			+ "FOREIGN KEY (proyecto)REFERENCES proyecto (id) ON UPDATE CASCADE ON DELETE CASCADE";
	String insertsAsignadoA = "(\"11111111\",\"BITN\"),(\"33333333\",\"SCTT\"),(\"44444444\",\"LICA\"),(\"55555555\",\"LICA\"),"
			+ "(\"44444444\",\"LGPL\")";
	String deleteAsignadoA = "cientifico=\"11111111\" AND proyecto=\"BITN\"";

	public void iniciarAplicación() {
		
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaCientificos, columnasCientificos);
		utilMysql.crearTabla(baseDatos, tablaProyecto, columnasProyecto);
		utilMysql.crearTabla(baseDatos, tablaAsignadoA, columnasAsignadoA);

		utilMysql.insertarDatos(baseDatos, tablaCientificos, insertsCientificos);
		utilMysql.insertarDatos(baseDatos, tablaProyecto, insertsProyecto);
		utilMysql.insertarDatos(baseDatos, tablaAsignadoA, insertsAsignadoA);	

		utilMysql.mostrarDatos(baseDatos, tablaCientificos);
		utilMysql.mostrarDatos(baseDatos, tablaProyecto);
		utilMysql.mostrarDatos(baseDatos, tablaAsignadoA);


		utilMysql.eliminarDatos(baseDatos, tablaCientificos, deleteCientificos);
		utilMysql.mostrarDatos(baseDatos, tablaCientificos);
		
		utilMysql.eliminarDatos(baseDatos, tablaProyecto, deleteProyecto);
		utilMysql.mostrarDatos(baseDatos, tablaProyecto);
		
		utilMysql.eliminarDatos(baseDatos, tablaAsignadoA, deleteAsignadoA);
		utilMysql.mostrarDatos(baseDatos, tablaAsignadoA);
		
		utilMysql.cerrarSesion();

	}
}
