package enhanced;

import java.util.ArrayList;

public class UsersE {
	private String login;
	private String pwd;
	private String name;
	private String surname;
	private boolean[] perm;// {permission list, permission add, permission del, permision search, permission write, permission read} all boolean
	private final boolean[] perm1 = {true,true,true,true,true,true};
	private final boolean[] perm2 = {true,true,true,true,false,true};
	private final boolean[] perm3 = {true,true,false,true,false,true};
	private final boolean[] perm4 = {true,false,false,true,false,false};
	private final boolean[] perm5 = {false,false,false,false,false,false};
//	private final boolean[] perm6 = {true,true,true,true,true,true}; for future use
	
	public UsersE() {
		super();
	}
	public UsersE(String login,String pwd, String name, String surname,boolean[] perm) {
		super();
		this.login=login;
		this.pwd=pwd;
		this.name=name;
		this.surname=surname;
		this.perm=perm;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean[] getPerm() {
		return perm;
	}

	public void setPerm(boolean[] perm) {
		this.perm = perm;
	}
	
	public UsersE[] UsersIni () {
		UsersE user1 = new UsersE ("jgonzal","1234","Javier","Gonzalez",perm1);
		UsersE user2 = new UsersE ("jsanz","123456","Juan","Sanz",perm2);
		UsersE user3 = new UsersE ("ifuer","password","Inma","Fuertes",perm3);
		UsersE user4 = new UsersE ("fsanchez","hi1234","Fernando","Sanchez",perm4);
		UsersE user5 = new UsersE ("dummy","1111","All","forbidden",perm5);
		UsersE[] users = {user1,user2,user3,user4,user5};
		return users;
	}
	public ArrayList<Object> UserCheck(String a, String b) {
		UsersE users = new UsersE();
		UsersE[] totalusers = users.UsersIni();
		ArrayList<Object> user = new ArrayList<Object>();
		for (UsersE u : totalusers) {
			if (u.login.equals(a) && u.pwd.equals(b)) {
				user.add(u.name);
				user.add(u.surname);
				user.add(u.perm);
			}			
		}
		return user;
	}	

}
