public class EntradaChains extends Chains {
    private int requestPorMinuto;
    private int request;
    private long currentTime;

    public EntradaChains(int requestPorMinuto) {
        this.requestPorMinuto = requestPorMinuto;
        this.currentTime = System.currentTimeMillis();
    }

    public boolean checar(String email, String senha) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;
        
        if (request > requestPorMinuto) {
            System.out.println("Tempo expirado");
            Thread.currentThread().stop();
        }
        return checarProximo(email, senha);
    }
}