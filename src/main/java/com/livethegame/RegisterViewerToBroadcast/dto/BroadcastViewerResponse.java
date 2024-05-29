package com.livethegame.RegisterViewerToBroadcast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class BroadcastViewerResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;

    public BroadcastViewerResponse(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
