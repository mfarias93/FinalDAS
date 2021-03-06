package ar.edu.ubp.das.src.gobierno.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.concesionarias.beans.ConcesionariaBean;
import ar.edu.ubp.das.src.gobierno.forms.RespuestaForm;

public class MSUtimoGanadorDao extends DaoImpl {

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
    	
		RespuestaForm respuesta = new RespuestaForm();
		respuesta.setRespuesta("SI");
		String condicion ="SI";
		String error="",res;

		
		this.connect();
        this.setProcedure("dbo.Hay_ganador", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        ResultSet result = this.getStatement().executeQuery();

        result.next();
        	
        	while(result.getRow() > 0)
        	{	
	            res= result.getString("Respuesta");
	            if(res.equals("NO")) 
	            {

						this.connect();
						
						this.setProcedure("dbo.ultimo_ganador", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				        
						ResultSet result2 = this.getStatement().executeQuery();
				
				        result2.next();
				        	
				        	while(result2.getRow() > 0)
				        	{	
					            condicion= result2.getString("actualizada");
					            if(condicion.equals("SI")) 
					            {
					            	condicion="SI";
					            }
					            else
					            {
					            	error = error + "ERROR";
					            }
					        	result2.next();
				        	}     
						this.disconnect();
				
				        if (error == "")
				        {
				        	respuesta.setRespuesta("SI");
				        }
				        else{
				        	respuesta.setRespuesta(error);
				        }
	            }
	            else{
	            	respuesta.setRespuesta("SI");
	            }
	            result.next();
        	}
       return  respuesta;	
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
