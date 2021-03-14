package alexbatista.br.edu.fateclins.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class UsuarioMyDatabasehelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "_id_user";
    private static final String COLUMN_NAME = "user_name";
    private static final String COLUMN_LOGIN = "user_login";
    private static final String COLUMN_PASSWORD = "user_password";

    UsuarioMyDatabasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_LOGIN + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";
        db.execSQL(query);
        db.execSQL("INSERT INTO users VALUES(1, 'adminstrador', 'admin@admin.com.br', 'admin12345')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addUser(String name, String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_LOGIN, login);
        cv.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registro adicionado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String name, String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_LOGIN, login);
        cv.put(COLUMN_PASSWORD, password);

        long result = db.update(TABLE_NAME, cv, "_id_user=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registro atualizado com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id_user=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registro atualizado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        db.execSQL("INSERT INTO users VALUES(1, 'adminstrador', 'admin@admin.com.br', 'admin12345')");
    }

    boolean findByLogin(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_LOGIN + "= ? AND " + COLUMN_PASSWORD + " = ? LIMIT 1", new String[]{user, password});
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        return false;
    }
}