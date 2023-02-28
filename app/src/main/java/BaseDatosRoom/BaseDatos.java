package BaseDatosRoom;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Persona.class}, version = 2, exportSchema = false)
public abstract class BaseDatos  extends RoomDatabase {
    public abstract Consultas consultas();
}
