package ContentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by Bharatwaaj on 06-09-2015.
 */
public class LoginDataInternalStorage extends ContentProvider {

    private SQLiteDatabase db;
    public static final String DATABASE_NAME = "ReachDb";
    public static final String TABLE_CONTENT = "contentTable";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_CONTENT_TABLE =
            " CREATE TABLE IF NOT EXISTS " + TABLE_CONTENT +
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " _usrid TEXT NOT NULL, " +
                    " _pwd TEXT NOT NULL );";
    public static final String PROVIDER_NAME = "design.material.myapplication.ContentProvider.LoginData";
    public static final String CONTENT_URL = "content://" + PROVIDER_NAME + "/content";
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URL);

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_CONTENT_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENT);
            onCreate(db);
        }
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID;
        rowID = db.insert(TABLE_CONTENT, "", values);
        Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
        getContext().getContentResolver().notifyChange(_uri, null);
        return _uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count;
        count = db.delete(TABLE_CONTENT, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
