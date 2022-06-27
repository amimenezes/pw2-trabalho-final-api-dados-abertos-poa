package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.vertx.core.json.JsonObject;

@Path("/cadastro-escolas")
@Produces(MediaType.APPLICATION_JSON)
public class CadastroEscolasResource {

  static String resource_id = "5579bc8e-1e47-47ef-a06e-9f08da28dec8";

  @Inject
  @RestClient
  CadastroEscolasService cadastroEscolasService;

  @GET
  @Path("getCEByCodigo/{_codigo}")
  public String getCEByCodigo(@PathParam("_codigo") Integer _codigo) {
    JsonObject obj = new JsonObject();
    obj.put("codigo", _codigo);
    String serialized = obj.toString();

    return cadastroEscolasService.getCEByCodigo(resource_id, serialized);
  }

  @GET
  @Path("all")
  public String getAllCE() {
    return cadastroEscolasService.getAll(resource_id);
  }
}
