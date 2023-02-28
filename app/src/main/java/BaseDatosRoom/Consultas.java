package BaseDatosRoom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Consultas {
    @Query("SELECT * FROM persona")
    List<Persona> getAll();

    @Insert
    void insertAll(Persona... persona);

}
