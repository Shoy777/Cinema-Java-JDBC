package ws;

import javax.xml.ws.Endpoint;

public class WSPublicacion {
	
	public static void main(String[] args) {
		String RUTA = "http://localhost:8085/WSMetodos";
		
		WSImpMetodos ws = new WSImpMetodos();
		//cd C:\Program Files\Java\jdk1.8.0_91\bin
		//wsimport -keep -verbose -d C:\server http://localhost:8080/WSMetodos?wsdl
		
		Endpoint edp = Endpoint.publish(RUTA, ws);
		System.out.println("SE PUBLICO: "+edp.isPublished());
	}
	
}
