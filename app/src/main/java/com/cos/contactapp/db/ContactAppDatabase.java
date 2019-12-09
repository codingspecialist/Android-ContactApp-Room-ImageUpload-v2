package com.cos.contactapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cos.contactapp.db.model.Contact;

@Database(entities = {Contact.class}, version = 2)
public abstract class ContactAppDatabase extends RoomDatabase {

    // @Database에서 DAO객체에 접근 (규칙)
    public abstract ContactDAO getContactDAO();

    // 해당 DB가 firestore 같은 거라면  dao를 얻기 위해서는 syncronized 걸고 싱글톤 걸어야 함. 동시 접근 막기

}
