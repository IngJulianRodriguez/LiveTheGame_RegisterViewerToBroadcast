package com.livethegame.RegisterViewerToBroadcast.repository;

import com.livethegame.RegisterViewerToBroadcast.entities.BroadcastsAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BroadcastAccessRepository extends JpaRepository<BroadcastsAccess, Long> {
}
