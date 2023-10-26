package utils;

public class UtilEjercicio02 {
	
	UtilsMysql utilMysql = new UtilsMysql();

	String baseDatos = "ejercicio_02";

	String tablaDepartamentos = "departamentos";
	String columnasDepartamentos = "codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100) NOT NULL, presupuesto INT NOT NULL";
	String insertsDepartamentos = "(\"Saxifraga\",700000),(\"Phyllodoce\",30000),(\"Cornus\",100000),(\"Hazardia\",9800000),"
			+ "(\"Agoseris\",89000);";
	String deleteDepartamentos = "codigo=3";

	String tablaEmpleados = "empleados";
	String columnasEmpleados = "dni VARCHAR(8) PRIMARY KEY," + "    nombre NVARCHAR(100) NOT NULL,"
			+ "    apellidos NVARCHAR(255) NOT NULL," + "    departamento INT NOT NULL REFERENCES departamentos,"
			+ "    UNIQUE ( nombre , apellidos , departamento )";
	String insertsEmpleados = "(\"11111111\", \"Cloé\", \"Mat Lam Tam\", 1), (\"22222222\", \"Laurélie\", \"Voyatouch\", 2), "
			+ "(\"33333333\", \"Véronique\", \"Fix San\", 4), (\"44444444\", \"Aimée\", \"Voltsillam\", 1),"
			+ "(\"55555555\", \"Ophélie\", \"Greenlam\", 2)";
	String deleteEmpleados = "dni=\"44444444\"";
	
	public void iniciarAplicación() {
		utilMysql.iniciarSessionBaseDatos();
		utilMysql.crearBaseDatos(baseDatos);
		
		utilMysql.crearTabla(baseDatos, tablaDepartamentos, columnasDepartamentos);
		utilMysql.crearTabla(baseDatos, tablaEmpleados, columnasEmpleados);
		
		utilMysql.insertarDatos(baseDatos, tablaDepartamentos, insertsDepartamentos);
		utilMysql.insertarDatos(baseDatos, tablaEmpleados, insertsEmpleados);
		
		utilMysql.mostrarDatos(baseDatos, tablaDepartamentos);
		utilMysql.mostrarDatos(baseDatos, tablaEmpleados);
		
		
		utilMysql.eliminarDatos(baseDatos, tablaDepartamentos, deleteDepartamentos);
		utilMysql.mostrarDatos(baseDatos, tablaDepartamentos);
		
		
		utilMysql.eliminarDatos(baseDatos, tablaEmpleados, deleteEmpleados);
		utilMysql.mostrarDatos(baseDatos, tablaEmpleados);
		
		utilMysql.cerrarSesion();
		
	}
}
