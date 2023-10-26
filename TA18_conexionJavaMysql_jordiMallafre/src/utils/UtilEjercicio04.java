package utils;

public class UtilEjercicio04 {
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_04";

	String tablaPeliculas = "peliculas";
	String columnasPeliculas = "codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100) NOT NULL, calificacion_edad INT NOT NULL";
	String insertsAlmacen = "(\"Brekke, Rosenbaum and Beatty\", 0), (\"Hartmann Group\",18), (\"Medhurst-Pfeffer\", 7)," +
	"(\"Fisher-Monahan\", 12), (\"Johns, Larson and Stroman\", 16)";
	String deleteAlmacen = "codigo=3";

	String tablaSalas = "salas";
	String columnasSalas = "codigo INT AUTO_INCREMENT PRIMARY KEY,nombre NVARCHAR(100), pelicula INT REFERENCES peliculas, FOREIGN KEY (pelicula) REFERENCES peliculas(codigo)"+
	"ON DELETE CASCADE ON UPDATE CASCADE";
	String insertsSalas = "(\"Holdlamis\", 1), (\"Fixflex\", 5),(\"Sonair\", 5), (\"Stringtough\", 2),(\"Daltfresh\",4)";
	String deleteSalas = "codigo=4";

	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);

		utilMysql.crearTabla(baseDatos, tablaPeliculas, columnasPeliculas);
		utilMysql.crearTabla(baseDatos, tablaSalas, columnasSalas);

		utilMysql.insertarDatos(baseDatos, tablaPeliculas, insertsAlmacen);
		utilMysql.insertarDatos(baseDatos, tablaSalas, insertsSalas);

		utilMysql.mostrarDatos(baseDatos, tablaPeliculas);
		utilMysql.mostrarDatos(baseDatos, tablaSalas);

		utilMysql.eliminarDatos(baseDatos, tablaPeliculas, deleteAlmacen);
		utilMysql.mostrarDatos(baseDatos, tablaPeliculas);

		utilMysql.eliminarDatos(baseDatos, tablaSalas, deleteSalas);
		utilMysql.mostrarDatos(baseDatos, tablaSalas);

		utilMysql.cerrarSesion();

	}
}
