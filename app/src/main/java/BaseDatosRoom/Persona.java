package BaseDatosRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Persona {
    @PrimaryKey
    private String nombre;

    @ColumnInfo(name="edad")
    private int edad;

    @ColumnInfo(name="Localizacion")
    private String lugar;

    @ColumnInfo(name="Conexion")
    private Boolean conexion;

}
