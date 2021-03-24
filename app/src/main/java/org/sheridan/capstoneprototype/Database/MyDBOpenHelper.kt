package org.sheridan.sqliteandroidkotldemo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.sheridan.capstoneprototype.Classes.Medicine

class MyDBOpenHelper(
    context: Context?,
//    name: String?,
    factory: SQLiteDatabase.CursorFactory?
//    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private val version = 1
        private val name = "Medicine.db"
        val TABLE_NAME = "Medicine"
        val COLUMN_ID = "_id"
        val COLUMN_NAME1 = "medName"
        val COLUMN_NAME2="medDosage"
        val COLUMN_NAME3="medFrequency"
        val COLUMN_NAME4="medQuantity"
        val COLUMN_NAME5="medDescription"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY," +
                COLUMN_NAME1 + " TEXT," +
        COLUMN_NAME2 + " INTEGER," +
        COLUMN_NAME3 + " INTEGER," +
                COLUMN_NAME4 + " INTEGER," +
                COLUMN_NAME5 + " TEXT" + ")")
        db?.execSQL(CREATE_PRODUCTS_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

    // insert the new row to the rable
    fun addName(name: Medicine){
        val values = ContentValues()
        values.put(COLUMN_NAME1, name.medName)
        values.put(COLUMN_NAME2, name.dosage)
        values.put(COLUMN_NAME3, name.frequency)
        values.put(COLUMN_NAME4, name.quantity)
        values.put(COLUMN_NAME5, name.description)
        val db = this.writableDatabase
        db.insert(TABLE_NAME,null, values)
        db.close()
    }


    fun getAllName() : Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

}