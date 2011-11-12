package eu.codebits.bonkai.dto;

public class UserDto extends DomainDto {

  private String name;

  public UserDto(long oid, String name) {
    super(oid);
    setName(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
