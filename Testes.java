import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class Testes {
    PostUsuario posts;
    Usuario usuario;
    Papagaio papagaio;

    @BeforeEach
    public void init() {
        usuario = new Usuario("teste");
        posts = new PostUsuario("teste", usuario);
        papagaio = new Papagaio();
    }

    @Test
    public void testPost() {
        Assertions.assertEquals("teste", posts.getTexto());
        Assertions.assertEquals(usuario, posts.getAutor());
    }
    @Test
    public void testSeguir(){
        Usuario teste = new Usuario("teste2");
        usuario.setUsuarioLog(true);
        usuario.seguir(teste);
    }

}