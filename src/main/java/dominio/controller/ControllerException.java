package dominio.controller;

public class ControllerException extends Exception{

	private static final long serialVersionUID = 1L;

		public ControllerException(String message, Throwable cause) {
			super(message, cause);
		}

		public ControllerException(String message) {
			super(message);
		}

		public ControllerException(Throwable cause) {
			super(cause);
		}

}
