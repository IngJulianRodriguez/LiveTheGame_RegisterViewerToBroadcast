package com.livethegame.RegisterViewerToBroadcast.services;

import com.livethegame.RegisterViewerToBroadcast.Utils.Generator;
import com.livethegame.RegisterViewerToBroadcast.Utils.Mapper;
import com.livethegame.RegisterViewerToBroadcast.common.BroadcastViewerResponseMapper;
import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerRequest;
import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerResponse;
import com.livethegame.RegisterViewerToBroadcast.entities.*;
import com.livethegame.RegisterViewerToBroadcast.exception.*;
import com.livethegame.RegisterViewerToBroadcast.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BroadcastService {

    @Autowired
    BroadcastRepository broadcastRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BroadcastAccessRepository broadcastAccessRepository;
    @Autowired
    BroadcastViewerResponseMapper broadcastViewerResponseMapper;


    public BroadcastViewerResponse registerViewer(BroadcastViewerRequest broadcastViewerRequest){
        Optional<Users> optionalUser = userRepository.findById(broadcastViewerRequest.getUser_id());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Usuario no encontrado con ID: " + broadcastViewerRequest.getUser_id());
        }
        Optional<Broadcasts> optionalBroadcasts = broadcastRepository.findById(broadcastViewerRequest.getBroadcast_id());
        if (optionalBroadcasts.isEmpty()) {
            throw new BroadcastNotFoundException("Transmision no encontrada con ID: " + broadcastViewerRequest.getBroadcast_id());
        }

        BroadcastsAccess broadcastViewerRequestToBroadcastAccess = Mapper.broadcastViewerRequestToBroadcastAccess(optionalUser.get(), optionalBroadcasts.get());
        broadcastViewerRequestToBroadcastAccess.setAccess_code(Generator.generateCode());
        BroadcastsAccess save = broadcastAccessRepository.save(broadcastViewerRequestToBroadcastAccess);
        BroadcastViewerResponse broadcastsAccessToBroadcastViewerResponse = broadcastViewerResponseMapper.BroadcastsAccessToBroadcastViewerResponse(save);
        return broadcastsAccessToBroadcastViewerResponse;

    }
}
