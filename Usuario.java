import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
    private ArrayList<PostUsuario> postUsuarios = new ArrayList<>();
    private ArrayList<Usuario> seguindoUsuarios = new ArrayList<>();
    private String nome;

    public Usuario(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean usuarioLogado = false;

    public void seguirUsuarios(Usuario autorUsuario) {
        if (!usuarioLogado) {
            System.out.println("Você precisa está logado para seguir alguém: ");
            return;
        }
        seguindoUsuarios.add(autorUsuario);
    }

    public void postagensUsuario(String texto) {
        if (!usuarioLogado) {
            System.out.println("Você precisa estar logado para postar algo: ");
            return;
        }
        postUsuarios.add(new PostUsuario(texto, this));
        System.out.println("Postagem feita com sucesso");
    }

    public ArrayList<PostUsuario> getPostagens() {
        return postUsuarios;
    }

    public void lerPostagens() {
        for (int i = 0; i < postUsuarios.size(); i++) {
            PostUsuario postagem = postUsuarios.get(i);
            postagem.lerPostagem();
        }
    }

    public void lerPostagensSeguidores() {
        for (int i = 0; i < seguindoUsuarios.size(); i++) {
            Usuario usuario = seguindoUsuarios.get(i);
            usuario.lerPostagens();
        }
    }

    public void verMural() {
        lerPostagens();
        lerPostagensSeguidores();
    }

    public void verSeguidores() {
        for (int i = 0; i < seguindoUsuarios.size(); i++) {
            Usuario usuario = seguindoUsuarios.get(i);
            System.out.println("Seguindo: " + usuario.getNome());
        }
    }

    public boolean isLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLog(boolean usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void seguir(Usuario teste) {
    }

}