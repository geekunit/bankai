package eu.codebits.bonkai;

import eu.codebits.bonkai.resource.DocumentResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class BonkaiApplication extends Application {

  public BonkaiApplication() {
    Bootstrap.init();
  }

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> s = new HashSet<Class<?>>();
    s.add(DocumentResource.class);
    return s;
  }

}
