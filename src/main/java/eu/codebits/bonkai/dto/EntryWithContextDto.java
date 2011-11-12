package eu.codebits.bonkai.dto;

import java.util.List;

public class EntryWithContextDto {

  private List<EntryDto> previousEntries;
  private EntryDto entryToBeTranslated;
  private List<EntryDto> nextEntries;

  public EntryWithContextDto() {}

  public EntryWithContextDto(List<EntryDto> previousEntries, EntryDto entryToBeTranslated, List<EntryDto> nextEntries) {
    this.previousEntries = previousEntries;
    this.entryToBeTranslated = entryToBeTranslated;
    this.nextEntries = nextEntries;
  }

  public List<EntryDto> getPreviousEntries() {
    return previousEntries;
  }

  public void setPreviousEntries(List<EntryDto> previousEntries) {
    this.previousEntries = previousEntries;
  }

  public EntryDto getEntryToBeTranslated() {
    return entryToBeTranslated;
  }

  public void setEntryToBeTranslated(EntryDto entryToBeTranslated) {
    this.entryToBeTranslated = entryToBeTranslated;
  }

  public List<EntryDto> getNextEntries() {
    return nextEntries;
  }

  public void setNextEntries(List<EntryDto> nextEntries) {
    this.nextEntries = nextEntries;
  }
}
