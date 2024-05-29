package com.livethegame.RegisterViewerToBroadcast.repository;

import com.livethegame.RegisterViewerToBroadcast.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
