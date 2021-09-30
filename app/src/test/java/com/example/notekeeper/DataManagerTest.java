package com.example.notekeeper;

import static org.junit.Assert.*;


import com.example.notekeeper.MemoryData.CourseInfo;
import com.example.notekeeper.MemoryData.DataManager;
import com.example.notekeeper.MemoryData.NoteInfo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataManagerTest {
    static DataManager sDataManager;

    @BeforeClass
    public static void classSetup() {
        sDataManager = DataManager.getInstance();
    }

    @Before
    public void setUp() {
        sDataManager.getNotes().clear();
        sDataManager.initializeExampleNotes();
    }
    @Test
    public void createNewNote() {
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String title = "Test Note Title";
        final String noteText = "This is the body of my text note";

         int noteIndex = sDataManager.createNewNote();
         NoteInfo newNote = sDataManager.getNotes().get(noteIndex);
         newNote.setCourse(course);
         newNote.setTitle(title);
         newNote.setText(noteText);

         NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
         assertEquals(compareNote.getCourse(), course);
         assertEquals(compareNote.getTitle(), title);
         assertEquals(compareNote.getText(), noteText);
    }

    @Test
    public void findSimilarNotes() {
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String title = "Test Note Title";
        final String noteText1 = "This is the body of my text note";
        final String noteText2 = "This is the body of my second test note";

        int noteIndex1 = sDataManager.createNewNote();
        NoteInfo newNote1 = sDataManager.getNotes().get(noteIndex1);
        newNote1.setCourse(course);
        newNote1.setTitle(title);
        newNote1.setText(noteText1);

        int noteIndex2 = sDataManager.createNewNote();
        NoteInfo newNote2 = sDataManager.getNotes().get(noteIndex2);
        newNote2.setCourse(course);
        newNote2.setTitle(title);
        newNote2.setText(noteText2);

        int foundIndex1 = sDataManager.findNote(newNote1);
        assertEquals(noteIndex1, foundIndex1);

        int foundIndex2 = sDataManager.findNote(newNote2);
        assertEquals(noteIndex2, foundIndex2);

    }

    @Test
    public void createNewNoteOneStepCreation() {
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String title = "Test Note Title";
        final String noteText = "This is the body of my text note";

        int noteIndex = sDataManager.createNewNote(course, title, noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(compareNote.getCourse(), course);
        assertEquals(compareNote.getTitle(), title);
        assertEquals(compareNote.getText(), noteText);
    }
}