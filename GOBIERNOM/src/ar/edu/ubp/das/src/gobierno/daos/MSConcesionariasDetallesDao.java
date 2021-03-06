package ar.edu.ubp.das.src.gobierno.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.concesionarias.beans.ConcesionariaBean;
import ar.edu.ubp.das.src.gobierno.forms.ConcesionariasDetalles;


public class MSConcesionariasDetallesDao extends DaoImpl {

	@Override
	public DynaActionForm make(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
    	return null;
	}

	@Override
	public void insert(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DynaActionForm select(DynaActionForm form) throws SQLException {
    	
		ConcesionariasDetalles detalles;
		detalles=null;
		this.connect();

		this.setProcedure("dbo.Detalles_Concesionaria (?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

	       if(form.getItem("elegida").isEmpty()) {
			  JOptionPane.showMessageDialog(null,"Error al obtener Concesionaria elegida", "ERROR", JOptionPane.ERROR_MESSAGE);
			  this.setNull(1, Types.TINYINT);		        	
	        }
	        else {
	        	this.setParameter(1,(form.getItem("elegida")));
	        	
	        }
		
		
        ResultSet result = this.getStatement().executeQuery();

        result.next();
        	
        	if(result.getRow() > 0)
        	{	
	            detalles = new ConcesionariasDetalles();
	        	detalles.setNombre(result.getString("Nombre"));
	        	detalles.setHabilitado(result.getString("Habilitado"));
	        	detalles.setDireccion(result.getString("Direccion"));
	        	detalles.setTelefono(result.getString("Telefono"));
	        	detalles.setFecha_actualizacion(result.getString("Fecha_actualizacion"));
	        	detalles.setId_concesionaria(result.getString("id_concesionaria"));
	        	detalles.setMetodo(result.getString("Metodo"));
	        	detalles.setDireccion_url(result.getString("direccion_url"));
	        	detalles.setMetodo_pago(result.getString("Metodo_pago"));
	        	detalles.setServicio(result.getString("Servicio"));
        	}
        	
        detalles.setPermiso(form.getItem("permiso"));   
		this.disconnect();
		return  detalles;
    	
		
	}

	@Override
	public boolean valid(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String insert(ConcesionariaBean respuestaConcesionaria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
