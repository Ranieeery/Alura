import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private String nome;
    private String cpf;
    @IdadeMinima(valor=18)
    private LocalDate dataNascimento;
    //getters e setters

   public Usuario(String nome, String cpf, LocalDate data) {
   }

   public boolean usuarioValido(Usuario usuario){
      if(!usuario.getNome().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")){
         return false;
      }
      if(!usuario.getCpf().matches("[^0-9]+")){
         return false;
      }
      return Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears() >= 18;
   }

   public static <T> boolean validador(T objeto) {
      Class<?> classe = objeto.getClass();
      for (Field field : classe.getDeclaredFields()) {
         if (field.isAnnotationPresent(IdadeMinima.class)) {
            IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);
            try{
               field.setAccessible(true);
               LocalDate dataNascimento = (LocalDate) field.get(objeto);
               return Period.between(dataNascimento, LocalDate.now()).getYears() >= idadeMinima.valor();
            } catch (IllegalAccessException e) {
                 e.printStackTrace();
            }
         }
      }
      return false;
   }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}