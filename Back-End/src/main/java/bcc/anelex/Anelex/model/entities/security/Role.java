package bcc.anelex.Anelex.model.entities.security;

public enum Role {
    MANAGER("manager"),
    CLIENT("client");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
