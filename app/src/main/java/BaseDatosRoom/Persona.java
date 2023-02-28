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
    private Boolean email;

    @ColumnInfo(name="GitHub")
    private Boolean github;



    public Persona(String nombre, int edad, String lugar, Boolean conexion) {
        this.nombre = nombre;
        this.edad = edad;
        this.lugar = lugar;
        this.conexion = conexion;
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

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public Boolean getGithub() {
        return github;
    }

    public void setGithub(Boolean github) {
        this.github = github;
    }
}
