package com.daniel.server.TimerTask;

import com.daniel.server.dal.ICouponDal;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.CouponsLogic;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class CouponsRemove extends TimerTask {

    private final Timer timer;
    private CouponsLogic couponsLogic;
    private ICouponDal couponsDal;
    private long oncePerDay = 1000*60*60*24;
    private static int timeToStart = 0;
    private static int zeroMinutes = 0;

    public CouponsRemove() {
        this.timer = new Timer();
        this.couponsLogic = couponsLogic;
    }


    @Override
    public void run() {
        long currennTime = System.currentTimeMillis();
        long stopTime = currennTime;
        while(stopTime != System.currentTimeMillis()){
            try {
                couponsLogic.removeOutDated();
            } catch (ServerException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static Date getTomorrowMorning0AM(){

        Date date0am = new Date();
        date0am.setHours(timeToStart);
        date0am.setMinutes(zeroMinutes);

        return date0am;
    }
    //call this method from your servlet init method
    public static void startTask(){
        CouponsRemove task = new CouponsRemove();
        Timer timer = new Timer();
        timer.schedule(task, getTomorrowMorning0AM(),1000*10);// for your case u need to give 1000*60*60*24
    }
    public static void main(String args[]){
        startTask();

    }

}