package dominio.entitymodel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import persistencia.DAOException;

public class EntregaVacunasTest {
	@Test
	public void testToString() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
        String expected = ": region=" + region + " -- grupoprioridad=" + grupoprioridad + " -- cantidad=" + cantidad;
        Assert.assertEquals(expected, entrega.toString());
	}
	//Getters
	@Test
	public void testGetRegion() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
        String expected = region; 
        Assert.assertEquals(expected, entrega.getRegion());
	}
	@Test
	public void testGetGrupoPrioridad() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
        String expected = grupoprioridad; 
        Assert.assertEquals(expected, entrega.getGrupoPrioridad());
	}
	@Test
	public void testGetLote() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
        String expected = lote; 
        Assert.assertEquals(expected, entrega.getLote());
	}
	/*@Test
	public void testGetEntregaDao() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
        String expected = region; 
        Assert.assertEquals(expected, entrega.getEntregaDao());
	}*/
	@Test
	public void testGetFecha() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
		LocalDate expected = LocalDate.now(); 
        Assert.assertEquals(expected, entrega.getFecha());
	}
	@Test
	public void testGetCantidad() throws DAOException {
		String grupoprioridad = "Joven";
		String lote = "ascd21";
		LocalDate fecha = LocalDate.now();
		int cantidad = 50;
		String region = "Murcia";
		EntregaVacunas entrega = new EntregaVacunas(grupoprioridad,lote,fecha,cantidad,region);
        int expected = cantidad; 
        Assert.assertEquals(expected, entrega.getCantidad());
	}
	
	
}
