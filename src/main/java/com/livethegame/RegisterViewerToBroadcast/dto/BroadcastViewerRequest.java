package com.livethegame.RegisterViewerToBroadcast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class BroadcastViewerRequest {

    @ApiModelProperty(name = "id del usuario", required = true,example = "", value = "")
    private long user_id;
    @ApiModelProperty(name = "id de la transmision", required = true,example = "", value = "")
    private long broadcast_id;

    public BroadcastViewerRequest(){
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBroadcast_id() {
        return broadcast_id;
    }

    public void setBroadcast_id(long broadcast_id) {
        this.broadcast_id = broadcast_id;
    }
}
