package eu.codebits.bonkai.domain;

public class Translation extends Translation_Base {

  public Translation(Language language, String text) {
    setLanguage(language);
    setText(text);
  }

}
