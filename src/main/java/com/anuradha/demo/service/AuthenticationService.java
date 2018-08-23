package com.anuradha.demo.service;


import com.anuradha.demo.Repository.TestRepo;
import com.anuradha.demo.Repository.UserRepository;
import com.anuradha.demo.model.Test;
import com.anuradha.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    TestRepo testRepo;
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
//      fetch data from the database by using DBConnection

        User user = new User(
                1,
                "Anuradha",
                "anuradha@gmail.com",
                "SE",
                "0767140151",
                "geust",
                "password",
                "",
                "salt",
                "AGdpqewEKlm6o9MoagyhrH_gFletXwk_o33hlSMddolpeXNuy5hILOmxCrksrRU6W4G5SiDaWwebkUtHLeykIegYLmEPsb4Xlab6v5zXrHg_oi83uPPYwSAhnKIxg3HC91lvhuHZgU58wYMj2FuyPdWu5ZDEnc5XSdgffGW9-i098INxNgSzUGnEzs3hFNnDqIrWJz02W2p5gnUDsnq-a5hIAZWu8c-Kp2JkIcmJZ-MSJntn0eVyxVpSqhu5OB7w0sNnTDJ3zn4EDullM_XStdIZfvcObi6qzsUsI9PvbAlBQo0laG8KXakEDWQCJVhlNa_QPfv-NYgoEn8xUr3zyWVaQ8qBQUHJE1oRI7XIEvW0Y06MeUq32PZLI6MhltnV8JwHENPfFSXXOghJL3Obqh3Req1pXZHNpYnsSIzuFau7mFXpNAcFgpE",
                "image_url",
                "2018-06-04",
                2311,
                0
        );
        return user;
    }

    public User addUser(User user) {
//        call repository

        User save = userRepository.save(user);

        return save;
    }

//    public Test addTest(Test ruwan) {
//
//        System.out.println("\n\n" + ruwan + "\n\n");
//
//        Test save = testRepo.save(ruwan);
//        System.out.println("\n\n" + save + "\n\n");
//        return null;
//
//    }
}
