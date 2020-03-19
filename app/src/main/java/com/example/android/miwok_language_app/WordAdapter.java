package com.example.android.miwok_language_app;

import android.app.Activity;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is a {@link ArrayAdapter} that can provide the layout for each lis item
 * based on data source , which is  a list of {@link Word} objects.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /**Resource ID for the background color for this list of words
     ***/
    private int mColorResourceId;

    public WordAdapter(Activity context , ArrayList<Word>words, int colorResourceId)
    {
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        //Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);
        //Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //Get the miwok translation from current  word object set  this text on the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());

       //Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //Get the default translation from current  word object set  this text on the Default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());
        //Find ImageView in the list_item.xml layout with ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()){
        //SET the image view to the image resource specified in the current Word
        imageView.setImageResource(currentWord.getImageResourceId());
        //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            //otherwise hide the image view (Set visibility to GONE - as gone will not take up the space of hidded view as invisible does)
            imageView.setVisibility(View.GONE);
        }
        //Set theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the Resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of text container view
        textContainer.setBackgroundColor(color);

        //Return the whole list item layout (containing two text views) so that it can be shown in the list view.
        return listItemView;
    }



}
