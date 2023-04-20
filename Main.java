import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Papagaio papagaio = new Papagaio();

        boolean sairDoPapagaio = false;

        while (!sairDoPapagaio) {
            Usuario usuario = null;

            while (usuario == null && !sairDoPapagaio) {
                System.out.println("""
                        |1- LOGIN
                        |2- REGISTRAR
                        |3- SAIR""");

                int escolhaDoUsuario = sc.nextInt();
                sc.nextLine();

                String nomeUsu;

                switch (escolhaDoUsuario) {
                    case 1:
                        usuario = login(papagaio, sc);
                        break;

                    case 2:
                        usuario = registrar(papagaio, sc);
                        break;

                    case 3:
                        sairDoPapagaio = true;
                        System.exit(0);
                        break;

                    default:
                        break;
                }

            }
            System.out.println("Olá " + usuario.getNome() + " boas vindas!");
            usuario.setUsuarioLog(true);
            String input = "";

            while (!input.equals("sair")) {
                System.out.print("\n>");
                input = sc.nextLine();

                String[] palavras = separaPalavras(input, " ");

                if (palavras.length > 2 && palavras[1].equals("-->")) {
                    postar(input, papagaio);

                } else if (palavras.length == 2 && palavras[0].equals("Mural")) {
                    verMural(input, papagaio);

                } else if (palavras.length == 3 && palavras[1].equals("Segue")) {
                    seguir(input, papagaio);

                } else if (input.equals("Listar")) {
                    papagaio.listarUsuarios();


                } else if (palavras.length == 2 && palavras[0].equals("Seguindo")) {
                    papagaio.listarSeguindo(palavras[1]);
                }

            }
        }
    }

    public static Usuario login(Papagaio papagaio, Scanner sc) {
        System.out.print("DIGITE SEU NOME DE USUARIO: ");
        String nomeUsuario = sc.nextLine();
        return papagaio.getUsuario(nomeUsuario);
    }

    public static Usuario registrar(Papagaio papagaio, Scanner sc) {
        System.out.print("DIGITE SEU NOME DE USUARIO: ");
        String nomeUsuario = sc.nextLine();
        if (!papagaio.criarUsuario(nomeUsuario))
            return null;
        return papagaio.getUsuario(nomeUsuario);
    }

    public static void postar(String input, Papagaio papagaio) {
        String[] palavras = separaPalavras(input, " ");
        String nomeUsuario = palavras[0];
        if (papagaio.getUsuario(nomeUsuario) == null)
            return;
        papagaio.postagensUsuario(nomeUsuario, input.replace(palavras[0] + " " + palavras[1] + " ", ""));
    }
    public static void verMural(String input, Papagaio papagaio){
        String[] palavras = separaPalavras(input, " ");
        String nomeUsuario = palavras[1];
        if (papagaio.getUsuario(nomeUsuario) == null)
            return;
        papagaio.lerMural(nomeUsuario);
    }

    public static void seguir(String input, Papagaio papa){
        String[] palavras = separaPalavras(input, " ");
        String quemVaiSeguir = palavras[0];
        String quemVaiSerSeguido = palavras[2];
        papa.seguir(quemVaiSeguir, quemVaiSerSeguido);
    }

    public static String[] separaPalavras(String palavras, String separador){
        return palavras.split(separador);
    }
}