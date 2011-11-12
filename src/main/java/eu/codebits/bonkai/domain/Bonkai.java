package eu.codebits.bonkai.domain;

import eu.codebits.bonkai.dto.EntryDto;
import eu.codebits.bonkai.dto.TranslationActionDto;

import java.util.HashSet;
import java.util.Set;

public class Bonkai extends Bonkai_Base {

  public Bonkai() {

    Language ptLanguage = new Language("pt", "Português");
    Language enLanguage = new Language("en", "English");
    addLanguage(ptLanguage);
    addLanguage(enLanguage);

    Set<Language> languageSkillSet = new HashSet<Language>();
    languageSkillSet.add(ptLanguage);
    languageSkillSet.add(enLanguage);

    User user = new User("David Martinho", languageSkillSet);
    addUser(user);

    Document document = new Document("How I Met Your Mother");

    for(int i = 1; i < 100; i++) {
      Entry entry = new Entry(i, "TIMECODE");
      Translation t = new Translation(ptLanguage, "Subtitle "+i);
      entry.addTranslation(t);
      document.addEntry(entry);
    }
    document.addLanguage(ptLanguage);

    addDocument(document);
  }

  /*
  public Document getDocumentToBeTranslated(Set<Language> languageSkillSet) {
    for(Document document : getDocumentSet()) {
      if(document.hasCompleteTranslation(languageSkillSet) && document.hasIncompleteTranslation(languageSkillSet)) {
        return document;
      }
    }
    return null;
  }*/

  public TranslationActionDto getTranslationAction(User user) {
    for(Language userLanguage : user.getLanguageSet()) {
      for(Document document : userLanguage.getDocumentSet()) {
        for(Language userLanguage2 : user.getLanguageSet()) {
          if(!document.getLanguageSet().contains(userLanguage2)) {
            Set<EntryDto> entryDtoSet = document.getEntryDtoSet(userLanguage, userLanguage2);
            return new TranslationActionDto(userLanguage.getLocale(), userLanguage2.getLocale(),entryDtoSet);
          }
        }
      }
    }
    return null;
  }



  public User getCurrentUser() {
    return getDummyUser();
  }

  public User getDummyUser() {
    for(User user : getUserSet()) {
      return user;
    }
    return null;
  }

}
