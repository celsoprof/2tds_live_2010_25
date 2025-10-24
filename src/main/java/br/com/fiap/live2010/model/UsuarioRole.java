package br.com.fiap.live2010.model;

public enum UsuarioRole {
    ADMIN("admin"),
    USUARIO("usuario"),
    GERENTE("gerente");

    private String roleName;

    UsuarioRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
