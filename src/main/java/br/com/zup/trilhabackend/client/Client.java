package br.com.zup.trilhabackend.client;

public class Client {
		private String cpf;
	    private String name;
	    private int age;
	    private String email;
	    private String address;
	    
	    public Client() {
			super();
		}

	    public Client(String cpf, String name, int age, String email, String address) {
	 		this.cpf = cpf;
	 		this.name = name;
	 		this.age = age;
	 		this.email = email;
	 		this.address = address;
	 	}
	    
	    @Override
		public String toString() {
			return "Client [cpf=" + cpf + ", name=" + name + ", age=" + age + ", email=" + email + ", address="
					+ address + "]";
		}
	    
	    //métodos GET
	    public String getCpf() {
	    	return cpf;
	    }
	    
		public String getName() {
	    	return name;
	    }
	    
	    public int getAge() {
	    	return age;
	    }
	    
	   	public String getEmail() {
	    	return email;
	    }
	    
	    public String getAddress() {
	    	return address;
	    }
	   
	    //métodos SET
	    public void setName(String newName) {
	    	this.name = newName;
	    }
	    
	    public void setAge(int newAge) {
	    	this.age = newAge;
	    }
	    
	    public void setEmail(String newEmail) {
	    	this.email = newEmail;
	    }
	    
	    public void setAddress(String newAddress) {
	    	this.address = newAddress;
	    }
}
