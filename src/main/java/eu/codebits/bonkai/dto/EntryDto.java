package eu.codebits.bonkai.dto;

import eu.codebits.bonkai.domain.Translation;

public class EntryDto extends DomainDto {

  private Integer id;
  private String text;
  private Boolean toBeTranslated;

  public EntryDto() {}

  public EntryDto(long oid, Integer id, String text, Boolean toBeTranslated) {
    super(oid);
    setId(id);
    setText(text);
    setToBeTranslated(toBeTranslated);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Boolean getToBeTranslated() {
    return toBeTranslated;
  }

  public void setToBeTranslated(Boolean toBeTranslated) {
    this.toBeTranslated = toBeTranslated;
  }
}

