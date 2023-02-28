package BaseDatosRoom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Consultas {
    @Query("SELECT * FROM persona")
    List<Persona> getAll();

    @Insert
    void insertAll(Persona... persona);

    @Query("SELECT * FROM Persona WHERE nombre = :search")
    Persona finByName(String search);

    @Delete
    void deletePersona(Persona persona);

    @Update
    void updatePersona(Persona p);

    @Query("SELECT * FROM Persona WHERE nombre=:busqueda")
    Persona findSingleByNombre(String busqueda);
}