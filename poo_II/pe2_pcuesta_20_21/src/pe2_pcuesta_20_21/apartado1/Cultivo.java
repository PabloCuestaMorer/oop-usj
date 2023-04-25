package pe2_pcuesta_20_21.apartado1;

/**
 * 1.1. Crea la clase Cultivo que contenga un nombre de cultivo, unas
 * necesidades de agua (alta, media, baja) y una cantidad de plantas de ese
 * cultivo.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class Cultivo {

	private String nombre;
	private String necesidadesDeAgua; // ALTA || MEDIA || BAJA
	private int cantidadDePlantas;

	public Cultivo(String nombre, String necesidadesDeAgua, int cantidadDePlantas) {
		this.nombre = nombre;
		this.necesidadesDeAgua = necesidadesDeAgua;
		this.cantidadDePlantas = cantidadDePlantas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNecesidadesDeAgua() {
		return necesidadesDeAgua;
	}

	public void setNecesidadesDeAgua(String necesidadesDeAgua) {
		this.necesidadesDeAgua = necesidadesDeAgua;
	}

	public int getCantidadDePlantas() {
		return cantidadDePlantas;
	}

	public void setCantidadDePlantas(int cantidadDePlantas) {
		this.cantidadDePlantas = cantidadDePlantas;
	}

	@Override
	public String toString() {
		return "\n\t\t\tCultivo{" + "nombre='" + nombre + '\'' + ", necesidadesDeAgua='" + necesidadesDeAgua + '\''
				+ ", cantidadDePlantas=" + cantidadDePlantas + '}';
	}
}
