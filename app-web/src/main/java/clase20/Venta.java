package clase20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

//clase inmutable
public class Venta {

	private Long idVendedor;
//	private Vendedor vendedor;
	private Date fecha;
	private Double monto;
	
	public Venta(String venta) {
		if(venta != null){
			String[] arrayVenta = venta.split("\\|");
			if (arrayVenta.length == 3) {
				this.setIdVendedor(arrayVenta[0]);
				this.setFecha(arrayVenta[1]);
				this.setMonto(arrayVenta[2]);
			}
		}
	}
	
	public Venta(Long idVendedor, Date fecha, Double monto) {
		this.idVendedor = idVendedor;
		this.fecha = fecha;
		this.monto = monto;
	}

	
	
	private void setIdVendedor(String idVendedor) {
		if(idVendedor != null) {
			this.idVendedor = Long.parseLong(idVendedor);
		}else {
			System.out.println("Id invalido");
		}
	}

	//ventas.add("1|18/04/2022|1500");
	private void setFecha(String fecha) {
		if(fecha != null) {
			String[] fechaParse = fecha.split("/");
			if(fechaParse.length == 3) {
				 Calendar fechaFinal = Calendar.getInstance();
				 //año mes dia
				 
				 fechaFinal.set(Integer.parseInt(fechaParse[2]),
						 Integer.parseInt(fechaParse[1]),
						 Integer.parseInt(fechaParse[0]));
				 //setteo fecha
				 this.fecha = fechaFinal.getTime();
			}else {
				System.out.println("Fecha invalida");
			}
		}
	}

	private void setMonto(String monto) {
		if(monto != null) {
			Double montoFinal = Double.parseDouble(monto);
			if(montoFinal > 0) {
				this.monto = montoFinal;
			}else {
				System.out.println("El monto no puede ser negativo");
			}
		}
		
	}

	public Date getFecha() {
		return fecha;
	}

	public Double getMonto() {
		return monto;
	}


	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return "Venta [idVendedor=" + idVendedor + ", fecha=" + formato.format(fecha) + ", monto=" + monto + "]";
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVendedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(idVendedor, other.idVendedor);
	}



	//hashCode|equals
	
	
	
}