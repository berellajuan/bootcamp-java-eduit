package ar.com.educacionit.services.files;

public class PreOrdenRecursivo {
	public static void main(String[] args) {
		
		Nodo nodoPadre = BuildNodo();
		
		
		Arbol arbol = new Arbol(true, nodoPadre);
		
		recorrerPreOrden(arbol);
		
		
	}
	

	private static void recorrerPreOrden(Arbol arbol) {
		if(arbol.getRoot() && arbol.getNodo() != null) {
			System.out.print(arbol.getNodo().getLetra()+",");
			recorrerPreOrdenNodo(arbol.getNodo());
		}
			
	}


	private static void recorrerPreOrdenNodo(Nodo nodo) {
		if(nodo != null) {
			if(nodo.getIzq() != null) {
				System.out.print(nodo.getIzq().getLetra()+",");
				recorrerPreOrdenNodo(nodo.getIzq());
				if(nodo.getDer() != null) {
					System.out.print(nodo.getDer().getLetra()+",");
				}				
			}
			recorrerPreOrdenNodo(nodo.getDer());
		}
		
	}


	private static Nodo BuildNodo() {
		Nodo nodoO = new Nodo("O",null,null);
		
		Nodo nodoN = new Nodo("N",null,null);		
		
		Nodo nodoM = new Nodo("M",null,null);
		
		Nodo nodoL = new Nodo("L",null,null);
		
		Nodo nodoG = new Nodo("G",nodoN,nodoO);
		
		Nodo nodoF = new Nodo("F",nodoL,nodoM);
		
		Nodo nodoJ = new Nodo("J",null,null);
		
		Nodo nodoK = new Nodo("K",null,null);
		
		Nodo nodoI = new Nodo("I",null,null);
		
		Nodo nodoH = new Nodo("H",null,null);
		
		Nodo nodoD = new Nodo("D",nodoH,nodoI);
		
		Nodo nodoE = new Nodo("E",nodoJ,nodoK);
		
		Nodo nodoC = new Nodo("C",nodoF,nodoG);
		
		Nodo nodoB = new Nodo("B",nodoD,nodoE);
		
		Nodo nodoA = new Nodo("A", nodoB, nodoC);
		return nodoA;
	}
}
