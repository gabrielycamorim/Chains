public class ExisteUsuarioChains extends Chains {
    private Server server;

    public ExisteUsuarioChains(Server server) {
        this.server = server;
    }

    public boolean checar(String email, String senha) {
        if (!server.existeEmail(email)) {
            System.out.println("Email não existe, tente novamente");
            return false;
        }
        if (!server.validaSenha(email, senha)) {
            System.out.println("Senha errada, tente novamente");
            return false;
        }
        return checarProximo(email, senha);
    }
}