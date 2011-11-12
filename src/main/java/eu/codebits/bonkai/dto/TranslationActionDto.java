package eu.codebits.bonkai.dto;

import java.util.Set;

public class TranslationActionDto {

  private String sourceLocale;
  private String targetLocale;
  
  private Set<EntryDto> entryDtoSet;

  public TranslationActionDto(String sourceLocale, String targetLocale, Set<EntryDto> entryDtoSet) {
    this.sourceLocale = sourceLocale;
    this.targetLocale = targetLocale;
    this.entryDtoSet = entryDtoSet;
  }

  public String getSourceLocale() {
    return sourceLocale;
  }

  public void setSourceLocale(String sourceLocale) {
    this.sourceLocale = sourceLocale;
  }

  public String getTargetLocale() {
    return targetLocale;
  }

  public void setTargetLocale(String targetLocale) {
    this.targetLocale = targetLocale;
  }

  public Set<EntryDto> getEntryDtoSet() {
    return entryDtoSet;
  }

  public void setEntryDtoSet(Set<EntryDto> entryDtoSet) {
    this.entryDtoSet = entryDtoSet;
  }
}
