package eu.codebits.bonkai.domain;

public class Language extends Language_Base {

  public Language(String locale, String description) {
    setLocale(locale);
    setDescription(description);
  }

  public boolean isLocale(String locale) {
    return locale!=null && getLocale().equals(locale);
  }

}
