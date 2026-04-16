package com.example.gestionEtudiants.Utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Configs {

// for db
        @Value("${mysql.host}")
        private String mysqlHost;

        @Value("${mysql.username}")
        private String mysqlUsername;

        @Value("${mysql.password}")
        private String mysqlPassword;

        @Value("${mysql.driver}")
        private String mysqlDriver;

}


