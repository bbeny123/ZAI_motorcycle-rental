package beny.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "SEQ_USR_ID", sequenceName = "SEQ_USR_ID", allocationSize = 1)
public class UserData {

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = {CascadeType.ALL})
	private List<RentData> rent;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USR_ID")
	@Column(name = "USR_ID")
	private long id;
	
	@Column(name = "USR_LOGIN", length = 20, nullable = false, updatable = false)
	private String login;
	
	@Column(name = "USR_PASSWORD", length = 60, nullable = false)
	private String password;

	@Column(name = "USR_FIRST_NAME", length = 20, nullable = false)
	private String firstName;

	@Column(name = "USR_LAST_NAME", length = 30, nullable = false)
	private String lastName;

	@Column(name = "USR_EMAIL", length = 40, nullable = false)
	private String email;

	@Column(name = "USR_ADMIN", nullable = false)
	private int admin;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin == 1;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin ? 1 : 0;
	}

	public String getRole() {
		if(isAdmin())
			return "ADMIN";
		else
			return "USER";
	}

	public List<RentData> getRent() {
		if(rent == null) {
			rent = new ArrayList<>();
		}
		return rent;
	}

	public void setRent(List<RentData> rent) {
		this.rent = rent;
	}

}
