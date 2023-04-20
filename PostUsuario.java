import java.util.Calendar;
public class PostUsuario {
    private String textos;
    private Usuario autorUsuario;
    private Calendar data;
    public PostUsuario(String textos, Usuario autorUsuario){
        super();
        this.textos = textos;
        this.autorUsuario = autorUsuario;
        data = Calendar.getInstance();
    }
    public void lerPostagem(){
        System.out.printf("%s --> %s (%d/%d/%d %d:%d)\n",
                autorUsuario.getNome(),
                textos,
                data.get(Calendar.DAY_OF_MONTH),
                data.get(Calendar.MONTH)+1,
                data.get(Calendar.YEAR),
                data.get(Calendar.HOUR_OF_DAY),
                data.get(Calendar.MINUTE));
    }
    public String getTexto(){
        return textos;
    }

    public Usuario getAutor(){
        return autorUsuario;
    }

    public Calendar getData(){
        return data;
    }

}