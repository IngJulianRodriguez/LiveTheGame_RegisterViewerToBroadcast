package com.livethegame.RegisterViewerToBroadcast.Utils;

import com.livethegame.RegisterViewerToBroadcast.entities.*;

public  class Mapper {
    public static BroadcastsAccess broadcastViewerRequestToBroadcastAccess(Users user, Broadcasts broadcasts){
        BroadcastsAccess broadcastsAccess = new BroadcastsAccess();
        broadcastsAccess.setUser(user);
        broadcastsAccess.setBroadcast(broadcasts);
        return broadcastsAccess;
    };
}
