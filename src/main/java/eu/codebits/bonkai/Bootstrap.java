package eu.codebits.bonkai;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import eu.codebits.bonkai.domain.Bonkai;

public class Bootstrap {

  public static void init() {
    FenixFramework.initialize(new Config() {{
      domainModelPath = "/bonkai.dml";
      dbAlias = "//localhost:3306/bonkai";
      dbUsername = "root";
      dbPassword = "123";
      rootClass = Bonkai.class;
    }});
  }
}
