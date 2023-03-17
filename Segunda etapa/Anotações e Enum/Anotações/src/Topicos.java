import java.util.Arrays;

@RequestMapping
public class Topicos {
  
  @RequestMapping("/topicos") //Requisição HTTP 
  public List<TopicoDTO> lista() {
    Topico topico = new Topico("Duvida", "Duvida com Spring", new Curso("Spring", "Programação"));
    return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
  }
}
