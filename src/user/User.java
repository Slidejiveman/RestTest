package user;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "user")
public class User implements Serializable {

   private static final long serialVersionUID = 1L;
   private String id;
   private String firstName;
   private String lastName;
   private String profession;

   public User(){}
   
   public User(String id, String firstName, String lastName, String profession){
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.profession = profession;
   }

   public String getId() {
      return id;
   }

   @XmlElement
   public void setId(String id) {
      this.id = id;
   }

   public String getProfession() {
      return profession;
   }
   @XmlElement
   public void setProfession(String profession) {
      this.profession = profession;
   }
   
	public String getFirstName() {
		return firstName;
	}
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}

