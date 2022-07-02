package ar.com.educacionit.web.enums;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class ActionBuilder {
	
	//Los static se construyen primero a la hora de armar el metodo
	private static Map<FormatoEnum, IFormato> actionsMap = buildActionFormat(); 
	
	public static IFormato getAction(FormatoEnum _enum) {
		//IFormato action =  actionsMap.get(_enum);
		//action == null ? new DefaultAction() : action;
		
		IFormato action =  new DefaultAction();
		if(actionsMap.containsKey(_enum)) {
			action = actionsMap.get(_enum);
		}
		return action;
	}

	private static Map<FormatoEnum, IFormato> buildActionFormat() {
		Map<FormatoEnum, IFormato> map = new HashedMap<>();
		map.put(FormatoEnum.CSV, new CSVAction());
		map.put(FormatoEnum.PDF, new PDFAction());
		map.put(FormatoEnum.XLS, new XLSAction());
		return map;
	}

}
