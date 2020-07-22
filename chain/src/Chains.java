
public abstract class Chains {
	private Chains proximo;

	
	public Chains linkWith(Chains proximo) {
		this.proximo = proximo;
		return proximo;
	}

	public abstract boolean checar(String email, String senha);

	protected boolean checarProximo(String email, String senha) {
		if (proximo == null) {
			return true;
		}
		return proximo.checar(email, senha);
	}
}
