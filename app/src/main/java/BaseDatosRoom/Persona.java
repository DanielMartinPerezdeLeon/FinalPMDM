package BaseDatosRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Persona {
    @PrimaryKey
    @NotNull private String nombre;

    @ColumnInfo(name="edad")
    private int edad;

    @ColumnInfo(name="Localizacion")
    private String lugar;

    @ColumnInfo(name="Conexion")
    private Boolean conexion;

    @ColumnInfo(name="Email")
    private String email;

    @ColumnInfo(name="GitHub")
    private String github;

    public Persona(){

    }

    public Persona(String nombre, int edad, String lugar, Boolean conexion) {
        this.nombre = nombre;
        this.edad = edad;
        this.lugar = lugar;
        this.conexion = conexion;
    }

    public Persona(String nombre, int edad, String lugar, Boolean conexion, String email, String github) {
        this.nombre = nombre;
        this.edad = edad;
        this.lugar = lugar;
        this.conexion = conexion;
        this.email=email;
        this.github=github;
    }

    public Persona(String nombre, int edad,String email, String github) {
        this.nombre = nombre;
        this.edad = edad;
        this.email=email;
        this.github=github;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Boolean getConexion() {
        return conexion;
    }

    public void setConexion(Boolean conexion) {
        this.conexion = conexion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }



}
