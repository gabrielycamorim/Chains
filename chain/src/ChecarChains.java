public class ChecarChains extends Chains {
    public boolean checar(String email, String senha) {
        if (email.equals("admin@gmail.com")) {
            System.out.println("Bem vindo, admin!");
            return true;
        }
        System.out.println("Bem vindo, usuário");
        return checarProximo(email, senha);
    }
}