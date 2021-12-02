package persistencia;

public interface DAO<E> {

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public E get(String id) throws DAOException;

	/**
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public int insert(E entity) throws DAOException;

	/**
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public E update(E entity) throws DAOException;

	/**
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public int delete(E entity) throws DAOException;

}