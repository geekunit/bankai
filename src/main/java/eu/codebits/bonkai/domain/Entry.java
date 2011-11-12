package eu.codebits.bonkai.domain;

public class Entry extends Entry_Base implements Comparable<Entry> {

  public Entry(Integer id, String timecode) {
    setId(id);
    setTimecode(timecode);
  }

  public int compareTo(Entry entry) {
    return getId().compareTo(entry.getId());
  }

  public String getLanguageTranslation(Language language) {
    for(Translation translation : getTranslation()) {
      if(translation.getLanguage().equals(language)) {
        return translation.getText();
      }
    }
    return null;
  }

  public boolean needsTranslationIn(Language language) {
    return !getTranslationSet().contains(language);
  }
}
