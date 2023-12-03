package model;

public enum Rol {
	ADMINISTRADOR,	DEPENDENTE;
	public static Rol  parseRol(String rol) {
		switch (rol) {
		case ("ADMINISTRADOR"):
			return Rol.ADMINISTRADOR;
		case ("DEPENDENTE"):
			return Rol.DEPENDENTE;
		}
		return null;
	}
}


