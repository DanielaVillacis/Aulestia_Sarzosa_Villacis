package DatosUser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import Entities.User;
import Helper_DB.DataBase_Helper;

public class UserData extends DataBase_Helper {
    Context context;

    public UserData(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String cedula, String nombre, String apellido, String correo, String clave) {

        long id = 0;

        try {
            DataBase_Helper dbHelper = new DataBase_Helper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("cedula", cedula);
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("correo", correo);
            values.put("clave", clave);

            id = db.insert(TABLE_NOMBRE, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public User login(String correo, String clave) {

        DataBase_Helper dbHelper = new DataBase_Helper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        User usuario = null;
        Cursor cursorUsuario;

        cursorUsuario = db.rawQuery("SELECT * FROM " + TABLE_NOMBRE + " WHERE correo = '" + correo + "' and clave = '" + clave + "' LIMIT 1", null);

        if (cursorUsuario.moveToFirst()) {
            usuario = new User();
            usuario.setId(cursorUsuario.getInt(0));
            usuario.setCedula(cursorUsuario.getString(1));
            usuario.setNombre(cursorUsuario.getString(2));
            usuario.setApellido(cursorUsuario.getString(3));
            usuario.setCorreo(cursorUsuario.getString(4));
            usuario.setClave(cursorUsuario.getString(5));
        }

        cursorUsuario.close();

        return usuario;
    }
}