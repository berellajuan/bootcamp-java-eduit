package ar.com.educacionit.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Entity{
	private Long id;
	private String texto;
	private List<Menu> subMenu = new ArrayList<>();
	private Long root;
	private Long idMenuPadre;
	private String link;
	
	public Menu(Long id, String texto, Long root, Long idMenuPadre, String link) {
		this.id = id;
		this.texto = texto;
		this.root = root;
		this.idMenuPadre = idMenuPadre;
		this.link =link;
	}

	public Menu(String texto, List<Menu> subMenu, Long root) {
		this.texto = texto;
		this.subMenu = subMenu;
		this.root = root;
	}
	
	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	

	public Long getRoot() {
		return root;
	}

	public void setRoot(Long root) {
		this.root = root;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMenuPadre() {
		return idMenuPadre;
	}

	public void setIdMenuPadre(Long idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", texto=" + texto + ", subMenu=" + subMenu + ", root=" + root + ", idMenuPadre="
				+ idMenuPadre + ", link=" + link + "]";
	}

	
	
	
	
	
	

}
