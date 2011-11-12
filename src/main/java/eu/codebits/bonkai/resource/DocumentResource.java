package eu.codebits.bonkai.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import eu.codebits.bonkai.domain.*;
import eu.codebits.bonkai.dto.*;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;
import com.google.gson.Gson;
import java.util.HashSet;
import java.util.Set;

@Path("/document")
public class DocumentResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Atomic
  public String getEntryToTranslate() {
    Bonkai bonkai = (Bonkai)FenixFramework.getRoot();
    User user = bonkai.getCurrentUser();

    TranslationActionDto translationActionDto = bonkai.getTranslationAction(user);

    Gson gson = new Gson();
    if(translationActionDto!=null) {
      return gson.toJson(translationActionDto);
    } else {
      return gson.toJson("This user cannot translate any documents.");
    }
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Atomic
  public String createDocument(@FormParam("name") String name) {
    Bonkai bonkai = (Bonkai)FenixFramework.getRoot();
    Document document = new Document(name);
    bonkai.addDocument(document);
    DocumentDto documentDto = new DocumentDto(document.getOid(), document.getName());
    Gson gson = new Gson();
    return gson.toJson(documentDto);
  }

  @GET
  @Consumes(MediaType.APPLICATION_OCTET_STREAM)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get")
  @Atomic
  public String getDocument(@QueryParam("documentOid") String oid) {
    Document document = Bonkai.fromOID(Long.parseLong(oid));
    DocumentDto documentDto = new DocumentDto(document.getOid(), document.getName());
    Gson gson = new Gson();
    return gson.toJson(documentDto);
  }

}
