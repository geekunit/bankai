package eu.codebits.bonkai.dto;

public class DomainDto {

  public long oid;

  public DomainDto() {}

  public DomainDto(long oid) {
    setOid(oid);
  }

  public long getOid() {
    return oid;
  }

  public void setOid(long oid) {
    this.oid = oid;
  }
}
