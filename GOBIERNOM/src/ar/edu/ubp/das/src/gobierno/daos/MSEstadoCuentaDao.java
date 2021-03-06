package ar.edu.ubp.das.src.gobierno.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.concesionarias.beans.ConcesionariaBean;
import ar.edu.ubp.das.src.gobierno.forms.EstadoCuentaForm;
import ar.edu.ubp.das.src.gobierno.forms.FacturaForm;


public class MSEstadoCuentaDao extends DaoImpl {

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
    	
		LinkedList<FacturaForm> Facturas;
    	Facturas= new LinkedList<FacturaForm>();
    	FacturaForm Factura;
    	EstadoCuentaForm  Datos;
    	Datos = new EstadoCuentaForm();
    	if(form.getItem("permiso").equals("admin")) { 	   		
    		Datos.setNombre("admin"); 

			LinkedList<ConcesionariaBean>Listado = new LinkedList<ConcesionariaBean>();
			ConcesionariaBean Concesionaria = new ConcesionariaBean();
			this.connect();
			this.setProcedure("dbo.Obtener_Concesionarias()", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		       
	        ResultSet result3 = this.getStatement().executeQuery();		
	        result3.next();		        	
	        	while(result3.getRow() > 0)
	        		
	        	{	
	        		Concesionaria=new ConcesionariaBean();		            
		        	Concesionaria.setId_concesionaria(result3.getString("id_concesionaria"));
		        	Concesionaria.setNombre(result3.getString("Nombre"));
		        	Listado.add(Concesionaria);
		        	result3.next();
	        	}		        	     
			this.disconnect();	
			Datos.setConcesionarias(Listado);
    	}
    	else{
				this.connect();				
				this.setProcedure("dbo.Obtener_Estado_Cuenta (?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);		
			       if(form.getItem("Id_plan").isEmpty()) {
					  JOptionPane.showMessageDialog(null,"ERROR ID PLAN", "ERROR", JOptionPane.ERROR_MESSAGE);
					  this.setNull(1, Types.TINYINT);		
			        }
			        else {
			        	this.setParameter(1,(form.getItem("Id_plan")));	
			        }
		        ResultSet result = this.getStatement().executeQuery();		
		        result.next();		        	
		        	while(result.getRow() > 0)
		        	{	
		        		Factura = new FacturaForm();
			        	Factura.setNro_factura(result.getInt("nro_factura"));
			        	Factura.setEstado(result.getString("Estado"));
			        	Factura.setFecha(result.getString("Fecha"));
			        	Factura.setMonto(result.getInt("Monto"));
			        	Factura.setCobro(result.getString("Cobro"));
			        	Facturas.add(Factura);
			        	result.next();
		        	}     
				this.disconnect();
				Datos.setFacturas(Facturas);	
			    this.connect();				
				this.setProcedure("dbo.Obtener_Monto_Adeudado (?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);		
			       if(form.getItem("Id_plan").isEmpty()) {
					  JOptionPane.showMessageDialog(null,"ERROR ID PLAN", "ERROR", JOptionPane.ERROR_MESSAGE);
					  this.setNull(1, Types.TINYINT);				        	
			        }
			        else {  
			        	this.setParameter(1,(form.getItem("Id_plan")));			        	
			        }				
		        ResultSet result1 = this.getStatement().executeQuery();
		        result1.next(); 	
		        	while(result1.getRow() > 0)
		        	{	 
			        	Datos.setMonto_Adeudado(result1.getInt("Monto_Adeudado"));
			        	result1.next();
		        	} 	     
				this.disconnect();
				
				
		        this.connect();
				this.setProcedure("dbo.Obtener_DATOS_PLAN (?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			       if(form.getItem("Id_plan").isEmpty()) {
					  JOptionPane.showMessageDialog(null,"ERROR ID PLAN", "ERROR", JOptionPane.ERROR_MESSAGE);
					  this.setNull(1, Types.TINYINT);	
			        }
			        else {
			        	this.setParameter(1,(form.getItem("Id_plan")));
			        }
		        ResultSet result2 = this.getStatement().executeQuery();		
		        result2.next();		        	
		        	while(result2.getRow() > 0)
		        	{			            
			        	Datos.setNombre_Auto(result2.getString("Nombre_Auto"));
			        	Datos.setTipo_Modelo(result2.getString("Tipo_modelo"));
			        	Datos.setNombre(result2.getString("Nombre"));
			        	Datos.setFecha_actualizada(result2.getString("Fecha_actualizacion"));
			        	Datos.setDominio(result2.getString("Dominio"));
			        	Datos.setChasis(result2.getString("Chasis"));
			        	Datos.setMotor(result2.getString("Motor"));
			        	result2.next();
		        	}		        	     
				this.disconnect();	
				
				
				
				
    	}
    	
    	
    	
		return  Datos;	
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
