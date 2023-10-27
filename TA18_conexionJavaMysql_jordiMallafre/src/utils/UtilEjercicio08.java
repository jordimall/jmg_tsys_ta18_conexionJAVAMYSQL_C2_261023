package utils;

public class UtilEjercicio08 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_08";

	String tablaFacultad = "facultad";
	String columnasFacultad = "codigo INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL";
	String insertsFacultad = "(\"Mexican Lovegrass\"),(\"Cartilage Lichen\"),(\"Wandering Vetch\"),"
			+ "(\"Zulu Fescue\"), (\"Manchurian Walnut\")";
	String deleteFacultad = "codigo=3";

	String tablaInvestigador = "investigador";
	String columnasInvestigador = "	dni VARCHAR(8) PRIMARY KEY, nombre_apellidos VARCHAR(255) NOT NULL,"
			+ "facultad INT NOT NULL,FOREIGN KEY (facultad) REFERENCES facultad(codigo)"
			+ "ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsInvestigador = "(\"11111111\",\"Dyanna Brewers\",1), (\"22222222\",\"Shurlock Shyre\",2), "
			+ "(\"33333333\",\"Kelcey Ilem\",4), (\"44444444\",\"Kellen Doswell\",4),(\"55555555\",\"Farra Tattoo\",5)";
	String deleteInvestigador = "dni=\"22222222\"";
	
	String tablaEquipo = "equipo";
	String columnasEquipo = "num_serie CHAR(4) PRIMARY KEY, nombre VARCHAR(100) NOT NULL,"
			+ "facultad INT NOT NULL, FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsEquipo = "(\"BITN\",\"Wunsch, Weber and Walter\",1), (\"YORC\",\"Borer, Swaniawski and Kautzer\",2),"
			+ "(\"SCTT\",\"Hermann and Sons\",4),(\"LICA\",\"Little Group\",4), (\"LGPL\",\"Williamson, Kris and Raynor\",5)";
	String deleteEquipo = "num_serie=\"YORC\"";
	
	String tablaReserva = "reserva";
	String columnasReserva = "dni_investigador VARCHAR(8), num_equipo CHAR(4), comienzo DATETIME NOT NULL,"
			+ "fin DATETIME NOT NULL, PRIMARY KEY (dni_investigador, num_equipo), FOREIGN KEY (dni_investigador)"
			+ "REFERENCES investigador(dni) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (num_equipo)"
			+ "REFERENCES equipo(num_serie) ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsReserva = "(\"11111111\",\"BITN\",\"2023-06-22\",\"2023-12-25\"),(\"33333333\",\"SCTT\",\"2023-03-17\",\"2023-11-16\"),"
			+ "(\"44444444\",\"LICA\",\"2023-05-29\",\"2023-10-12\"),(\"55555555\",\"LICA\",\"2023-01-17\",\"2023-05-01\"),"
			+ "(\"44444444\",\"LGPL\",\"2023-09-30\",\"2023-12-25\")";
	String deleteReserva = "dni_investigador=\"11111111\" AND num_equipo=\"BITN\"";

	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaFacultad, columnasFacultad);
		utilMysql.crearTabla(baseDatos, tablaInvestigador, columnasInvestigador);
		utilMysql.crearTabla(baseDatos, tablaEquipo, columnasEquipo);
		utilMysql.crearTabla(baseDatos, tablaReserva, columnasReserva);

		utilMysql.insertarDatos(baseDatos, tablaFacultad, insertsFacultad);
		utilMysql.insertarDatos(baseDatos, tablaInvestigador, insertsInvestigador);
		utilMysql.insertarDatos(baseDatos, tablaEquipo, insertsEquipo);
		utilMysql.insertarDatos(baseDatos, tablaReserva, insertsReserva);
		
		utilMysql.mostrarDatos(baseDatos, tablaFacultad);
		utilMysql.mostrarDatos(baseDatos, tablaInvestigador);
		utilMysql.mostrarDatos(baseDatos, tablaEquipo);
		utilMysql.mostrarDatos(baseDatos, tablaReserva);

		utilMysql.eliminarDatos(baseDatos, tablaFacultad, deleteFacultad);
		utilMysql.mostrarDatos(baseDatos, tablaFacultad);

		utilMysql.eliminarDatos(baseDatos, tablaInvestigador, deleteInvestigador);
		utilMysql.mostrarDatos(baseDatos, tablaInvestigador);
		
		utilMysql.eliminarDatos(baseDatos, tablaEquipo, deleteEquipo);
		utilMysql.mostrarDatos(baseDatos, tablaEquipo);
		
		utilMysql.eliminarDatos(baseDatos, tablaReserva, deleteReserva);
		utilMysql.mostrarDatos(baseDatos, tablaReserva);
		
		utilMysql.cerrarSesion();

	}
}
