import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> usuario = new HashMap<>();
    private Chains chains;

    public void setChains(Chains chains) {
        this.chains = chains;
    }

    public boolean logar(String email, String senha) {
        if (chains.checar(email, senha)) {
            System.out.println("Logado com sucesso");

            return true;
        }
        return false;
    }

    public void registrar(String email, String senha) {
        usuario.put(email, senha);
    }

    public boolean existeEmail(String email) {
        return usuario.containsKey(email);
    }

    public boolean validaSenha(String email, String senha) {
        return usuario.get(email).equals(senha);
    }
}