package org.makhani.demo.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injection")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class Injectdemoresource {
	
	@GET
	@Path("annotation")
	public String getparamusingannotation(@MatrixParam("param")String matrixparam,
										  @HeaderParam("authid")String header,
										  @CookieParam("name")String cookie) {
											 
				return "Matrix param:" + matrixparam + "Header param:" + header + "Cookie param"  + cookie;
	}
	
	@GET
	@Path("context")
	public String getparaamusingcontext(@Context UriInfo uriinfo) {
		
		String path = uriinfo.getAbsolutePath().toString();
			return "path:" + path;
	}
   public String getparaamusingcontext(@Context HttpHeaders header) {
		
		String cookie = header.getCookies().toString();
		return "Cookie" + cookie;
	}
}



