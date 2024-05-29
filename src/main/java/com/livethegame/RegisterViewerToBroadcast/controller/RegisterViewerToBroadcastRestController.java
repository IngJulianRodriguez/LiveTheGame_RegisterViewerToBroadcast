package com.livethegame.RegisterViewerToBroadcast.controller;

import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerRequest;
import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerResponse;
import com.livethegame.RegisterViewerToBroadcast.exception.*;
import com.livethegame.RegisterViewerToBroadcast.services.BroadcastService;
import com.livethegame.RegisterViewerToBroadcast.services.MonitoringService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Api Register Viewer To Broadcast")
@RestController
@RequestMapping("/viewer-to-broadcast")
public class RegisterViewerToBroadcastRestController {

    @Autowired
    BroadcastService broadcastService;
    @Autowired
    MonitoringService monitoringService;

    @PostMapping("/register")
    public ResponseEntity<?> registerViewer(@RequestBody BroadcastViewerRequest input) {
        try {
            BroadcastViewerResponse BroadcastViewerResponse = broadcastService.registerViewer(input);
            monitoringService.registerSuccessLog(String.valueOf(input.getUser_id()),"/register "+input.toString()+" "+BroadcastViewerResponse);
            return ResponseEntity.ok(BroadcastViewerResponse);
        } catch (UserNotFoundException
                 | BroadcastNotFoundException
                 | ParamsNotFoundException e) {
            monitoringService.registerControlledExceptionLog("","/register "+input.toString()+" "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/register "+input.toString()+" "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/test-register")
    public ResponseEntity<?> testRegister(){
        return ResponseEntity.ok().build();
    }
}
