package eu.codebits.bonkai.dto;

public class TranslationDto extends DomainDto {

  private String locale;
  private String text;

  public TranslationDto() {}

  public TranslationDto(long oid, String locale, String text) {
    super(oid);
    setLocale(locale);
    setText(text);
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
