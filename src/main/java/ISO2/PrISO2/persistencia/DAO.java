package ISO2.PrISO2.persistencia;

public interface DAO<E> {

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public E get(int id) throws DAOException, Exception;

	/**
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public int insert(E entity) throws DAOException, Exception;

	/**
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public E update(E entity) throws DAOException, Exception;

	/**
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public int delete(E entity) throws DAOException, Exception;

}