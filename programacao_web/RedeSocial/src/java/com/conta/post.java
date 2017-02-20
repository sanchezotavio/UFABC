package com.conta;

public class post {

    private long id;
    private int id_usuario;
    private String post;
    private String data;
    private String hora;

    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUsuario() {
        return id_usuario;
    }

    public void setUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post =  post;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return   hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
