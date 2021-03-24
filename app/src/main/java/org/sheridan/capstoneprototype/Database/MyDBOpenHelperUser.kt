package org.sheridan.capstoneprototype.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.sheridan.capstoneprototype.Classes.Medicine
import org.sheridan.capstoneprototype.Classes.User


class MyDBOpenHelperUser(
    context: Context?,
//    name: String?,
    factory: SQLiteDatabase.CursorFactory?
//    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private val version = 1
        private val name = "User.db"
        val TABLE_NAME = "User"
        val COLUMN_ID = "_id"
        val COLUMN_NAME1 = "userName"
        val COLUMN_NAME2="userEmail"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY," +
                COLUMN_NAME1 + " TEXT," +
                COLUMN_NAME2 + " TEXT" + ")")
        db?.execSQL(CREATE_USER_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }


    fun addUser(name: User){
        val values = ContentValues()
        values.put(COLUMN_NAME1, name.userName)
        values.put(COLUMN_NAME2, name.email)

        val db = this.writableDatabase
        db.insert(TABLE_NAME,null, values)
        db.close()
    }

    fun getAllName() : Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

}