package eu.codebits.bonkai.domain;

import java.util.Set;

public class User extends User_Base {

  public User(String name, Set<Language> languageSkillSet) {
    setName(name);
    for(Language language : languageSkillSet) {
      addLanguage(language);
    }
  }
}
