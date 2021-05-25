package com.example.android.wedmist

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context):
        SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){

            companion object{
                private val DATABASE_VERSION = 1
                private val DATABASE_NAME = "UserDatabase"
                private val TABLE_CONTACTS = "UserTable"
                private val KEY_NAME = "name"
                private val KEY_EMAIL = "email"
                private val KEY_PASSWORD = "password"
            }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_PASSWORD + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)

}


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACTS)
        onCreate(db)
    }

    fun addUser(user: UserModelClass): Long{

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME,user.userName)
        contentValues.put(KEY_EMAIL,user.userEmail)
        contentValues.put(KEY_PASSWORD,user.userPassword)

        val success = db.insert(TABLE_CONTACTS,null,contentValues)
        db.close()
        return  success
    }

    fun viewUser(): List<UserModelClass>{

        val userList:ArrayList<UserModelClass> = ArrayList<UserModelClass>()

        val selectQuery = "SELECT *FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var user_Name: String
        var user_Email: String
        var user_Password: String

        if(cursor.moveToFirst()){
            do{
                user_Name = cursor.getString(cursor.getColumnIndex("name"))
                user_Email = cursor.getString(cursor.getColumnIndex("email"))
                user_Password = cursor.getString(cursor.getColumnIndex("password"))

                val user = UserModelClass(user_Name,user_Email,user_Password)
                userList.add(user)
            }while (cursor.moveToNext())
        }
        return userList
    }

}