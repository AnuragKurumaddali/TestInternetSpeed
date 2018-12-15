package com.raj.internetspeed;

import android.net.TrafficStats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tofa on 2/22/2016.
 */

public class RetrieveData {


    static long totalUpload = 0;
    static long totalDownload = 0;
    static long totalUpload_n = 0;
    static long totalDownload_n = 0; //for notification


    //  static long totalDownload = TrafficStats.getTotalRxBytes();

    /**
     *
     * @return downloaded and uploaded data per second
     */
    public static List<Long> findData() {
        List<Long> allData = new ArrayList<>();

        long newTotalDownload, incDownload, newTotalUpload, incUpload;


        //totalDownload and totalUpload set to zero if new session starts
        if (totalDownload == 0)
            totalDownload = TrafficStats.getTotalRxBytes();

        if (totalUpload == 0)
            totalUpload = TrafficStats.getTotalTxBytes();

        //calculate downloaded or uploaded data in every second
        newTotalDownload = TrafficStats.getTotalRxBytes();
        incDownload = newTotalDownload - totalDownload;

        newTotalUpload = TrafficStats.getTotalTxBytes();
        incUpload = newTotalUpload - totalUpload;


        //total downloaded and uploaded data after started new session
        totalDownload = newTotalDownload;
        totalUpload = newTotalUpload;

        allData.add(incDownload);
        allData.add(incUpload);


        return allData;


        //return incDownload + incUpload;
    }

}
