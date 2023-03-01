package BaseDatosRoom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Persona{
    @PrimaryKey
    @NotNull private String nombre;

    @ColumnInfo(name="nota1")
    private int nota1;

    @ColumnInfo(name="nota2")
    private int nota2;

    @ColumnInfo(name="nota3")
    private int nota3;

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

    public Persona(String nombre, int nota1,int nota2, int nota3, String lugar, Boolean conexion) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2=nota2;
        this.nota3=nota3;
        this.lugar = lugar;
        this.conexion = conexion;
    }

    public Persona(String nombre, int nota1,int nota2, int nota3, String lugar, Boolean conexion, String email, String github) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2=nota2;
        this.nota3=nota3;
        this.lugar = lugar;
        this.conexion = conexion;
        this.email=email;
        this.github=github;
    }

    public Persona(String nombre, int nota1,int nota2, int nota3, String email, String github) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2=nota2;
        this.nota3=nota3;
        this.email=email;
        this.github=github;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }



}
