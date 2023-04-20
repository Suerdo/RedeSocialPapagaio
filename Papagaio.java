import java.util.ArrayList;

public class Papagaio {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public boolean criarUsuario(String nome){
        usuarios.add(new Usuario(nome));
        System.out.println("Usuário adicionado com sucesso!");
        return true;
    }
    public Usuario getUsuario(String nome){
        for(int i = 0; i < usuarios.size(); i++){
            Usuario usuario = usuarios.get(i);
            if(usuario.getNome().equals(nome)){
                return usuario;
            }
        }
        System.out.println("Usuário não encontrado!");
        return null;
    }
    public void listarUsuarios(){
        for(int i = 0; i < usuarios.size(); i++){
            Usuario usuario = usuarios.get(i);
            System.out.println(usuario.getNome());
        }
    }
    public void listarSeguindo(String nome){
        try {
            getUsuario(nome).verSeguidores();
        } catch(NullPointerException e){
            System.out.println("Usuário não encontrado!");
        }
    }
    public void postagensUsuario(String nome, String textoASerPostado){
        getUsuario(nome).postagensUsuario(textoASerPostado);
    }
    public void lerMural(String nome){
        getUsuario(nome).verMural();
    }
    public void seguir(String nomeUsuarioQueVaiSeguir, String nomeUsuarioQueVaiSerSeguido){

        if(getUsuario(nomeUsuarioQueVaiSeguir) == null) {
            System.out.println("Usuário " + nomeUsuarioQueVaiSeguir + " não foi encontrado! ");
            return;
        }
        if(getUsuario(nomeUsuarioQueVaiSerSeguido) == null){
            System.out.println("Usuário "+ nomeUsuarioQueVaiSerSeguido + " não foi encontrado! ");
            return;
        }
        getUsuario(nomeUsuarioQueVaiSeguir).seguirUsuarios(getUsuario(nomeUsuarioQueVaiSerSeguido));
    }

}