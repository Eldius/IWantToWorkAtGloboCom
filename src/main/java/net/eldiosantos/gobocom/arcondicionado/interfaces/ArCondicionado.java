package net.eldiosantos.gobocom.arcondicionado.interfaces;

/**
 * Interface que define a comunicação com o aparelho.
 * 
 * @author Eldius
 * 
 */
public interface ArCondicionado {

	/**
	 * Verifica status do aparelho.
	 * 
	 * @return status do aparelho.
	 */
	public abstract boolean isLigado();

	/**
	 * Reduz em um grau a temperatura ambiente.
	 */
	public abstract void reduz_um_grau();
}
