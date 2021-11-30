package dominio.controller;

public class controllerException extends Exception{

		public controllerException(String message, Throwable cause) {
			super(message, cause);
		}

		public controllerException(String message) {
			super(message);
		}

		public controllerException(Throwable cause) {
			super(cause);
		}

}
