package com.example.android.miwok_language_app;

import android.media.MediaPlayer;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation  and a Miwok translation for that word.
 */
public class Word {
    /** Default translation for the word */
    private String mDefaultTranslation;     //use of m is not necessary as m stands for member variable and is mostly used for Non public and Non-Staic fields.
    /** Miwok translation for the word */
    private  String mMiwoTranslation ;
    /** Image Resource ID for the word to access the images **/
    private  int mImageResourceId = NO_IMAGE_PROVIDED ;
    /** Constant value that represents no image was provided for this word**/
    private static final int NO_IMAGE_PROVIDED = -1;
    /** Audio resource ID for the word**/
    private int mAudioResourceId;

    /**
     * create a new word object
     * @param DefaultTranslation is the word in a default english language that the user speaks
     * @param MiwokTranslation is the word in the miwok language
     * @param audioResourceId is the resource ID for the audio files associated with this word
     */
    public Word(String DefaultTranslation , String MiwokTranslation, int audioResourceId)  // constructor
    {
        mDefaultTranslation = DefaultTranslation;
        mMiwoTranslation = MiwokTranslation;
        mAudioResourceId = audioResourceId;
    }
    /**
     * create a new word object.
     * @param DefaultTranslation is the word in a default english language that the user speaks.
     * @param MiwokTranslation is the word in the miwok language.
     * @param ImageResourceId is the drawable resource ID for the image associated with the word.
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    public Word(String DefaultTranslation , String MiwokTranslation, int ImageResourceId, int audioResourceId)  // constructor
    {
        mDefaultTranslation = DefaultTranslation;
        mMiwoTranslation = MiwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public  String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    /**
     * Get the Miwok translation of the word.
     */
    public  String getMiwokTranslation(){
        return mMiwoTranslation;
    }
    /**
     * Return the Image Resource ID of the word
     */
    public int getImageResourceId (){
        return mImageResourceId;
    }
    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage(){
       return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    /**
     * Return the Audio resource ID for the word.
     * @return
     */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

}
