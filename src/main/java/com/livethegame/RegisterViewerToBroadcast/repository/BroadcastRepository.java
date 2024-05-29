package com.livethegame.RegisterViewerToBroadcast.repository;

import com.livethegame.RegisterViewerToBroadcast.entities.Broadcasts;
import com.livethegame.RegisterViewerToBroadcast.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroadcastRepository extends JpaRepository<Broadcasts, Long> {
}
