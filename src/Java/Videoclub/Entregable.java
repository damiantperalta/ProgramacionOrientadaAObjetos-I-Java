public interface Entregable extends Comparable<Object> {
	public void entregar();

	public void devolver();

	public Boolean isEntregado();

	@Override
	int compareTo(Object a);

}