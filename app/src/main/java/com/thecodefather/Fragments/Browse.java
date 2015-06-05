package com.thecodefather.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.thecodefather.Helpers.Constants;
import com.thecodefather.trouver.R;

import java.util.LinkedList;

@SuppressLint("ValidFragment")
public class Browse extends Fragment implements View.OnClickListener{

    LinkedList <String> selectedVenues = new LinkedList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_browse, container, false);

        SeekBar ratingSeekBar = (SeekBar) rootView.findViewById(R.id.ratingSeekBar);
        ratingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                TextView ratingTxtValue = (TextView) rootView.findViewById(R.id.seekbarValue);
                ratingTxtValue.setTypeface(null, Typeface.BOLD);
                String value = null;

                int amt = (progress / 10);
                if (amt >= 1 && amt < 10)
                    value = Integer.toString(amt) + "+";
                else if (amt == 10)
                    value = Integer.toString(amt);
                else {

                    value = "X";
                    ratingTxtValue.setTypeface(null, Typeface.NORMAL);
                }

                ratingTxtValue.setText(value);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rootView.findViewById(R.id.cafe_layout).setOnClickListener(this);
        rootView.findViewById(R.id.meal_takeaway_layout).setOnClickListener(this);
        rootView.findViewById(R.id.diner_layout).setOnClickListener(this);
        rootView.findViewById(R.id.bar_layout).setOnClickListener(this);
        rootView.findViewById(R.id.night_club_layout).setOnClickListener(this);
        rootView.findViewById(R.id.browse_search_action).setOnClickListener(this);


        return rootView;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.cafe_layout:
                elementSelect ((LinearLayout) view.findViewById(R.id.cafe_layout), Constants.CAFE);
                break;
            case R.id.meal_takeaway_layout:
                elementSelect ((LinearLayout) view.findViewById(R.id.meal_takeaway_layout), Constants.MEAL_TAKEAWAY);
                break;
            case R.id.diner_layout:
                elementSelect ((LinearLayout) view.findViewById(R.id.diner_layout), Constants.DINER);
                break;
            case R.id.bar_layout:
                elementSelect ((LinearLayout) view.findViewById(R.id.bar_layout), Constants.BAR);
                break;
            case R.id.night_club_layout:
                elementSelect ((LinearLayout) view.findViewById(R.id.night_club_layout), Constants.NIGHTCLUB);
                break;

        }

    }

//    CUSTOM

    void elementSelect (LinearLayout linearLayout, String label) {

        if (selectedVenues.contains(label)) {

            linearLayout.setBackgroundResource(R.drawable.custom_border);
            selectedVenues.remove(label);
        } else {

            linearLayout.setBackgroundResource(R.drawable.custom_border_2);
            selectedVenues.add(label);
        }
    }


    static void preBrowseTask(View rootView) {

//        b_venues = ((TextView) rootView.findViewById(R.id.venue_txtview)).getText().toString().trim();
        String browseDistance = ((EditText) rootView.findViewById(R.id.browse_distance)).getText().toString().trim();
        String browseHashtag = ((EditText) rootView.findViewById(R.id.browse_hashtag_editText)).getText().toString().trim();

        }
}
