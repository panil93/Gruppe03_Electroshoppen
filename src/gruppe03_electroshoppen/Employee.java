/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Employee {

	private String fullname;
	private String login;
	private String password;
	private String type;

	public Employee(String fullname, String login, String password, String type) {
		this.fullname = fullname;
		this.login = login;
		this.password = password;
		this.type = type;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

}
