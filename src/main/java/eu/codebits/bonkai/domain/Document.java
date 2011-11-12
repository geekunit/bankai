package eu.codebits.bonkai.domain;

import eu.codebits.bonkai.dto.EntryDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Document extends Document_Base {

  private static final int CONTEXT_WINDOW_SIZE = 3;

  public Document(String name) {
    setName(name);
  }

  /*
  public Boolean hasCompleteTranslation(Set<Language> languageSet) {
    for(Entry)
    for(Language language : languageSet) {
      for(Translation translation : language.getTranslationSet()) {
        if(translation.getLanguage().equals(language)) {
          return true;
        }
      }
    }
    return false;
  }

  public Boolean hasIncompleteTranslation(Set<Language> languageSet) {
    for(Language language : languageSet) {
      for(Translation translation : getTranslationSet()) {
        if(translation.getLanguage().equals(language) && !translation.getIsComplete()) {
          return true;
        }
      }
    }
    return false;
  }*/


  public Set<EntryDto> getEntryDtoSet(Language sourceLanguage, Language targetLanguage) {
    Entry[] entryArray = getEntrySet().toArray(new Entry[0]);
    Arrays.sort(entryArray);
    Set<EntryDto> entryDtoSet = new HashSet<EntryDto>();

    for(int i = 0; i < entryArray.length; i++) {
      if(entryArray[i].needsTranslationIn(targetLanguage)) {
        int start = Math.max(0,i-CONTEXT_WINDOW_SIZE);
        int end = Math.min(i+CONTEXT_WINDOW_SIZE, entryArray.length);
        for(int j = start; j < end; j++) {
          Entry entry = entryArray[j];
          if(i==j) {
            entryDtoSet.add(new EntryDto(entry.getOID(), entry.getId(), entry.getLanguageTranslation(sourceLanguage), true));
          } else {
            entryDtoSet.add(new EntryDto(entry.getOID(), entry.getId(), entry.getLanguageTranslation(sourceLanguage), false));
          }
        }
        break;
      }
    }
    return entryDtoSet;
  }

}
