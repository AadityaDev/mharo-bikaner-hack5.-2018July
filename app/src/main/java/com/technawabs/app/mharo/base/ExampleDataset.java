package com.technawabs.app.mharo.base;

import com.ramotion.expandingcollection.ECCardData;
import com.technawabs.app.mharo.R;
import com.technawabs.app.mharo.base.pojo.CardData;
import com.technawabs.app.mharo.base.pojo.Comment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ExampleDataset {

    private List<ECCardData> dataset;
    private String[] cardNames = { "Aadhar Card", "Pan Card", "Voter ID", "Driving License", "Passport" };

    public ExampleDataset() {
        dataset = new ArrayList<>(5);

        CardData item5 = new CardData();
        item5.setMainBackgroundResource(R.drawable.attractions);
        item5.setHeadBackgroundResource(R.drawable.attractions_head);
        item5.setHeadTitle(cardNames[4]);
        item5.setPersonName(cardNames[4]);
        item5.setPersonPictureResource(R.drawable.passport);
        dataset.add(item5);

        CardData item4 = new CardData();
        item4.setMainBackgroundResource(R.drawable.city_scape);
        item4.setHeadBackgroundResource(R.drawable.city_scape_head);
        item4.setHeadTitle(cardNames[3]);
        item4.setPersonName(cardNames[3]);
        item4.setPersonPictureResource(R.drawable.pan_card);
        dataset.add(item4);

        CardData item3 = new CardData();
        item3.setMainBackgroundResource(R.drawable.night_life);
        item3.setHeadBackgroundResource(R.drawable.night_life_head);
        item3.setHeadTitle(cardNames[2]);
        item3.setPersonName(cardNames[2]);
        item3.setPersonPictureResource(R.drawable.voterid);
        dataset.add(item3);

        CardData item2 = new CardData();
        item2.setMainBackgroundResource(R.drawable.nature);
        item2.setHeadBackgroundResource(R.drawable.nature_head);
        item2.setHeadTitle(cardNames[1]);
        item2.setPersonName(cardNames[1]);
        item2.setPersonPictureResource(R.drawable.driving);
        dataset.add(item2);

        CardData item1 = new CardData();
        item1.setMainBackgroundResource(R.drawable.night_life);
        item1.setHeadBackgroundResource(R.drawable.night_life_head);
        item1.setHeadTitle(cardNames[0]);
        item1.setPersonName(cardNames[0]);
        item1.setPersonPictureResource(R.drawable.aadhar);
        dataset.add(item1);

    }

    public List<ECCardData> getDataset() {
        Collections.shuffle(dataset);
        return dataset;
    }

}