package com.example.notekeeper.Note.SQLiteDatabase;

import android.provider.BaseColumns;

public final class NoteKeeperDatabaseContract {
    private NoteKeeperDatabaseContract() {} // Non-creatable constructor.

    public static final class CourseInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "course_info";
        public static final String COLUMN_COURSE_ID = "course_id";
        public static final String COLUMN_COURSE_TITLE = "course_title";

        // CREATE INDEX course_info_index1 ON course_info (course_title)
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME + "(" + COLUMN_COURSE_TITLE + ")";

        public static String getQName(String columnName) { return TABLE_NAME + "." + columnName; }

        // CREATE TABLE course_info (_ID INTEGER PRIMARY KEY, course_id TEXT UNIQUE NOT NULL, course_title TEXT NOT NULL)
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_COURSE_ID + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_COURSE_TITLE + " TEXT NOT NULL " + ")";
    }

    public static final class NoteInfoEntry implements BaseColumns{
        public static final String TABLE_NAME = "note_info";
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
        public static final String COLUMN_COURSE_ID= "course_id";

        // CREATE INDEX note_info_index2 ON note_info(note_title)
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME + "(" + COLUMN_NOTE_TITLE + ")";

        public static String getQName(String columnName) {return TABLE_NAME + "." + columnName; }

        // CREATE TABLE note_info (_ID INTEGER PRIMARY KEY, note_title TEXT NOT NULL, note_text TEXT, course_id TEXT NOT NULL)
        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "( " + _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NOTE_TITLE + " TEXT NOT NULL, " +
                COLUMN_NOTE_TEXT + " TEXT, " +
                COLUMN_COURSE_ID + " TEXT NOT NULL)";
    }


}
