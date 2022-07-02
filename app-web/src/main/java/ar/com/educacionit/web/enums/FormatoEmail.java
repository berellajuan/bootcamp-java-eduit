package ar.com.educacionit.web.enums;

public class FormatoEmail {
	public static void main(String[] args) {
		String formato = "CSV";
		
		//pido el enum si .valueOf no existe lo que le mando larga una execpcio
		 FormatoEnum _enum = FormatoEnum.valueOf(formato);
		 //pido action que devuelva el formato
		 IFormato action = ActionBuilder.getAction(_enum);
		 //ejecuto
		 action.doAction();
	}

}
