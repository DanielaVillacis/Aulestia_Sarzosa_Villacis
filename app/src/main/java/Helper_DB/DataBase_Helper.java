package Helper_DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBase_Helper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "login.db";
    public static final String TABLE_NOMBRE = "usuarios";

    public DataBase_Helper(@Nullable Context context){
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NOMBRE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cedula TEXT NOT NULL,"+
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL,"+
                "correo TEXT NOT NULL," +
                "clave TEXT NOT NULL)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NOMBRE);
        onCreate(sqLiteDatabase);
    }
}