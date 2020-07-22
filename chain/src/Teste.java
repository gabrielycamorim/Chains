import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teste {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.registrar("admin@gmail.com", "adminsenha123");
        server.registrar("usuario@gmail.com", "usuariosenha123");

        Chains chains = new EntradaChains(2);
        chains.linkWith(new ExisteUsuarioChains(server))
                .linkWith(new ChecarChains());

        server.setChains(chains);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean successo;
        do {
            System.out.print("Email: ");
            String email = reader.readLine();
            System.out.print("Senha: ");
            String senha = reader.readLine();
            successo = server.logar(email, senha);
        } while (!successo);
    }
}