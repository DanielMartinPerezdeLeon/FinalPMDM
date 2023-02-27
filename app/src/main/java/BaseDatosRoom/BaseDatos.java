package BaseDatosRoom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Persona.class}, version = 1)
public abstract class BaseDatos  extends RoomDatabase {
    public abstract Consultas consultas();
}
