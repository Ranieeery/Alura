import javax.persistence.*; // JPA Hibernate

@Entity
@Table(name = "CONTA")
public class Conta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //@Basic pode ser omitido
  @Column(name = "ctitular", length = 100)
  private String titular;
  private String banco;
  private String agencia;
  private String numero;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public String getBanco() {
    return banco;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }
  
  @Override
  public String toString() {
    return "Model.Conta [id=" + id + ", titular=" + titular + ", banco=" + banco + ", agencia=" + agencia + ", numero=" + numero + "]";
  }
}
