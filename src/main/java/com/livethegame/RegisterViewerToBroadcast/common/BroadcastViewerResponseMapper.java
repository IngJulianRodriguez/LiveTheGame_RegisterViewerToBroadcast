package com.livethegame.RegisterViewerToBroadcast.common;

import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerResponse;
import com.livethegame.RegisterViewerToBroadcast.entities.BroadcastsAccess;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BroadcastViewerResponseMapper {
    BroadcastViewerResponse BroadcastsAccessToBroadcastViewerResponse(BroadcastsAccess source);
}
