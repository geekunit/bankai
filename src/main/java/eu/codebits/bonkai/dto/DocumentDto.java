package eu.codebits.bonkai.dto;

public class DocumentDto extends DomainDto {

  private String name;

  public DocumentDto() {}

  public DocumentDto(long oid, String name) {
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
